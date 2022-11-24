package com.dtwave.flink.lineage.lookup.join;

import com.dtwave.flink.lineage.basic.AbstractBasicTest;

import org.junit.Before;
import org.junit.Test;

/**
 * @description: LookupJoinTest
 * @author: baisong
 * @version: 1.0.0
 * @date: 2022/11/24 8:03 PM
 */
public class LookupJoinTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();

        // create mysql dim table dim_mysql_company
        createTableOfDimMysqlCompany();

        // create hudi sink table dwd_hudi_users
        createTableOfDwdHudiUsers();
    }


    /**
     * insert-select-two-table lookup join.
     *
     * insert into hudi table from mysql cdc stream lookup join mysql dim table, which has system
     * udf CONCAT
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

}
