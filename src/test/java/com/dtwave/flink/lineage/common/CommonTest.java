package com.dtwave.flink.lineage.common;

import com.dtwave.flink.lineage.basic.AbstractBasicTest;

import org.apache.flink.table.api.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @description: CommonTest
 * @author: baisong
 * @version: 1.0.0
 * @date: 2022/8/12 12:27 PM
 */
public class CommonTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();

        // create mysql dim table dim_mysql_company
        createTableOfDimMysqlCompany();

        // create hudi sink table dwd_hudi_users
        createTableOfDwdHudiUsers();

        // create my_suffix_udf
        createFunctionOfMySuffix();
    }


    /**
     * insert-select, but the fields of the query and sink do not match
     *
     * insert into hudi table from mysql cdc stream table.
     */
    @Test(expected = ValidationException.class)
    public void testInsertSelectMismatchField() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users";

        context.parseFieldLineage(sql);
    }


    /**
     * insert-select.
     *
     * insert into hudi table from mysql cdc stream table.
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
     * insert-select with my_suffix_udf
     *
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectWithUDF() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   my_suffix_udf(name) ," +
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
     * insert-partition-select.
     *
     * insert into hudi table with specified partition from mysql cdc table.
     */
    @Test
    public void testInsertPartitionSelect() {
        String sql = "INSERT INTO dwd_hudi_users PARTITION (`partition`='20220824') " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   name as company_name ," +
                "   birthday ," +
                "   ts " +
                "FROM" +
                "   ods_mysql_users";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"}
        };

        parseFieldLineage(sql, expectedArray);
    }


    /**
     * insert-partition-with-columnList select.
     *
     * insert into hudi table with specified partition from mysql cdc table.
     */
    @Test
    public void testInsertPartitionWithColumnListSelect() {
        String sql = "INSERT INTO dwd_hudi_users PARTITION (`partition`='20220824') (id,company_name) " +
                "SELECT " +
                "   id ," +
                "   name " +
                "FROM" +
                "   ods_mysql_users";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name"}
        };

        parseFieldLineage(sql, expectedArray);
    }


    /**
     * insert-select-select
     *
     * insert into hudi table from mysql cdc stream table.
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
     * insert into hudi table from mysql cdc stream join mysql dim table, which has system udf
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
     * Create my_suffix_udf
     */
    private void createFunctionOfMySuffix() {
        context.execute("DROP FUNCTION IF EXISTS my_suffix_udf");

        context.execute("CREATE FUNCTION IF NOT EXISTS my_suffix_udf " +
                "AS 'com.dtwave.flink.lineage.common.MySuffixFunction'"
        );
    }

}