package com.dtwave.flink.lineage;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @description: LineageContextTest
 * @author: baisong
 * @version: 1.0.0
 * @date: 2022/8/12 12:27 PM
 */
public class LineageContextTest {

    private static final Logger LOG = LoggerFactory.getLogger(LineageContextTest.class);

    private String catalogName = "hive";
    private String defaultDatabase = "flink_demo";
    private String warehouse = "hdfs://192.168.90.150:9000/hudi";

    private LineageContext context = new LineageContext(catalogName, defaultDatabase);


    @Before
    public void setUp() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();

        // create mysql dim table dim_mysql_company
        createTableOfDimMysqlCompany();

        // create hudi sink table dwd_hudi_users
        createTableOfDwdHudiUsers();
    }


    /**
     * insert-select.
     *
     * insert into hudi table from mysql cdc stream join.
     */
    @Test
    public void testInsertSelect() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   name as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition"}
        };

        parseFieldLineage(sql, expectedArray);
    }


    /**
     * insert-select-select
     *
     * insert into hudi table from mysql cdc stream join.
     */
    @Test
    public void testInsertSelectSelect() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   sum_id ," +
                "   name ," +
                "   company_name ," +
                "   birthday1 ," +
                "   ts ," +
                "   p " +
                "FROM ( " +
                "   SELECT " +
                "       SUM(id) as sum_id ," +
                "       name," +
                "       '1' as company_name ," +
                "       NOW() as birthday1 ," +
                "       NOW() as ts ," +
                "       DATE_FORMAT(birthday, 'yyyyMMdd') as p " +
                "   FROM " +
                "       ods_mysql_users " +
                "   GROUP BY" +
                "       name, " +
                "       DATE_FORMAT(birthday, 'yyyyMMdd')" +
                ")";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition"}
        };

        parseFieldLineage(sql, expectedArray);
    }


    /**
     * insert-select-two-table join.
     *
     * insert into hudi table from mysql cdc stream join mysql dim table, which has system function
     * CONCAT
     */
    @Test
    public void testInsertSelectTwoJoin() {
        String sql = "INSERT into dwd_hudi_users " +
                "SELECT " +
                "       a.id as id1," +
                "       CONCAT(a.name,b.company_name) , " +
                "       b.company_name , " +
                "       a.birthday ," +
                "       a.ts ," +
                "       DATE_FORMAT(a.birthday, 'yyyyMMdd') as p " +
                "FROM" +
                "       ods_mysql_users as a " +
                "JOIN " +
                "   dim_mysql_company as b " +
                "ON " +
                "   a.id = b.user_id";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"dim_mysql_company", "company_name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"dim_mysql_company", "company_name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition"}
        };

        parseFieldLineage(sql, expectedArray);
    }


    /**
     * insert-select-two-table lookup join.
     *
     * insert into hudi table from mysql cdc stream lookup join mysql dim table, which has system
     * function CONCAT
     */
    @Test
    public void testInsertSelectTwoLookupJoin() {
        String sql = "INSERT into dwd_hudi_users " +
                "SELECT " +
                "       a.id as id1," +
                "       CONCAT(a.name,b.company_name) , " +
                "       b.company_name , " +
                "       a.birthday ," +
                "       a.ts ," +
                "       DATE_FORMAT(a.birthday, 'yyyyMMdd') as p " +
                "FROM" +
                "       ods_mysql_users as a " +
                "JOIN " +
                "   dim_mysql_company FOR SYSTEM_TIME AS OF a.proc_time AS b " +
                "ON " +
                "   a.id = b.user_id";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"dim_mysql_company", "company_name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"dim_mysql_company", "company_name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition"}
        };

        parseFieldLineage(sql, expectedArray);
    }


    /**
     * Create mysql cdc table ods_mysql_users
     */
    private void createTableOfOdsMysqlUsers() {
        context.execute("DROP TABLE IF EXISTS ods_mysql_users ");

        context.execute("CREATE TABLE IF NOT EXISTS ods_mysql_users (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "       proc_time as proctime()                              " +
                ") WITH ( " +
                "       'connector' = 'mysql-cdc'            ," +
                "       'hostname'  = '192.168.90.150'       ," +
                "       'port'      = '3306'                 ," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'root@123456'          ," +
                "       'server-time-zone' = 'Asia/Shanghai' ," +
                "       'database-name' = 'demo'             ," +
                "       'table-name'    = 'users' " +
                ")"
        );
    }


    /**
     * Create mysql dim table dim_mysql_company
     */
    private void createTableOfDimMysqlCompany() {
        context.execute("DROP TABLE IF EXISTS dim_mysql_company ");

        context.execute("CREATE TABLE IF NOT EXISTS dim_mysql_company (" +
                "       user_id                  BIGINT     ," +
                "       company_name              STRING     " +
                ") WITH ( " +
                "       'connector' = 'jdbc'                 ," +
                "       'url'       = 'jdbc:mysql://192.168.90.150:3306/demo?useSSL=false&characterEncoding=UTF-8'," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'root@123456'          ," +
                "       'table-name'= 'company' " +
                ")"
        );
    }

    /**
     * Create Hudi sink table dwd_hudi_users
     */
    private void createTableOfDwdHudiUsers() {
        context.execute("DROP TABLE IF EXISTS dwd_hudi_users");

        // 删除表的时候不会删除HDFS路径,手动删除
        // hadoop fs -rmr /hudi/dwd_hudi_users

        context.execute("CREATE TABLE IF NOT EXISTS  dwd_hudi_users ( " +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       company_name        STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "        `partition`        VARCHAR(20)                      " +
                ") PARTITIONED BY (`partition`) WITH ( " +
                "       'connector' = 'hudi'                                    ," +
                "       'table.type' = 'COPY_ON_WRITE'                          ," +
                "       'path' = '" + warehouse + "/dwd_hudi_users'             ," +
                "       'read.streaming.enabled' = 'true'                       ," +
                "       'read.streaming.check-interval' = '1'                    " +
                ")"
        );
    }


    private void parseFieldLineage(String sql, String[][] expectedArray) {
        List<Result> actualList = context.parseFieldLineage(sql);
        LOG.info("Linage Result: ");
        actualList.forEach(e -> LOG.info(e.toString()));

        List<Result> expectedList = Stream.of(expectedArray)
                .map(e -> buildResult(e[0], e[1], e[2], e[3]))
                .collect(Collectors.toList());


        assertEquals(expectedList, actualList);
    }

    private Result buildResult(String sourceTable, String sourceColumn, String targetTable, String targetColumn) {
        return Result.builder()
                .sourceCatalog(catalogName)
                .sourceDatabase(defaultDatabase)
                .sourceTable(sourceTable)
                .sourceColumn(sourceColumn)
                .targetCatalog(catalogName)
                .targetDatabase(defaultDatabase)
                .targetTable(targetTable)
                .targetColumn(targetColumn)
                .build();
    }
}