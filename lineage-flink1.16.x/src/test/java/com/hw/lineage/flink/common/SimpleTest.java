package com.hw.lineage.flink.common;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Test;

/**
 * The test case comes from <a href="https://github.com/HamaWhiteGG/flink-sql-lineage/issues/53">main branch test error</a>, thanks
 *
 * @description: SimpleTest
 * @author: HamaWhite
 */
public class SimpleTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql table ods_user
        createTableOfOdsUser();

        // create mysql table mysql_user
        createTableOfMysqlUser();
    }

    @Test
    public void testConcat() {
        String sql = "INSERT INTO mysql_user                            " +
                "SELECT                                                 " +
                "       id                                             ," +
                "       birthday                                       ," +
                "       CONCAT(first_name, last_name) as full_name      " +
                "FROM                                                   " +
                "       ods_user                                        ";


        String[][] expectedArray = {
                {"ods_user", "id", "mysql_user", "id"},
                {"ods_user", "birthday", "mysql_user", "birthday"},
                {"ods_user", "first_name", "mysql_user", "full_name", "CONCAT(first_name, last_name)"},
                {"ods_user", "last_name", "mysql_user", "full_name", "CONCAT(first_name, last_name)"}
        };

        analyzeLineage(sql, expectedArray);
    }

    protected void createTableOfMysqlUser() {
        context.execute("DROP TABLE IF EXISTS mysql_user ");
        context.execute("CREATE TABLE IF NOT EXISTS mysql_user (    " +
                "       id                        BIGINT                    ," +
                "       birthday                  TIMESTAMP(3)              ," +
                "       full_name                 STRING                     " +
                ") WITH (                                                    " +
                "       'connector' = 'jdbc'                                ," +
                "       'url'       = 'jdbc:mysql://127.0.0.1:3306/demo'    ," +
                "       'username'  = 'root'                                ," +
                "       'password'  = 'xxx'                                 ," +
                "       'table-name'= 'mysql_user'                           " +
                ")"
        );
    }

    protected void createTableOfOdsUser() {
        context.execute("DROP TABLE IF EXISTS ods_user ");
        context.execute("CREATE TABLE IF NOT EXISTS ods_user (      " +
                "       id                        BIGINT                    ," +
                "       birthday                  TIMESTAMP(3)              ," +
                "       first_name                STRING                    ," +
                "       last_name                 STRING                    ," +
                "       company_name              STRING                     " +
                ") WITH (                                                    " +
                "       'connector' = 'jdbc'                                ," +
                "       'url'       = 'jdbc:mysql://127.0.0.1:3306/demo'    ," +
                "       'username'  = 'root'                                ," +
                "       'password'  = 'xxx'                                 ," +
                "       'table-name'= 'ods_user'                             " +
                ")"
        );
    }
}
