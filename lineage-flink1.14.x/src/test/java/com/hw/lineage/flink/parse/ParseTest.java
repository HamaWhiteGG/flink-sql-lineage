package com.hw.lineage.flink.parse;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.apache.flink.table.api.SqlParserException;
import org.apache.flink.table.api.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

/**
 * @description: ParseTest
 * @author: HamaWhite
 */
public class ParseTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();
    }


    @Test
    public void testParse() {
        context.parse("SELECT id, name, birthday FROM ods_mysql_users");
    }


    @Test
    public void testParseWithErrorSyntax() {
        assertThrows("SQL parse failed. Encountered \"ods_mysql_users\" at line 1, column 38."
                , SqlParserException.class
                , () -> context.parse("SELECT id, name, birthday ERROR_FROM ods_mysql_users")
        );
    }


    @Test
    public void testParseWithErrorTable() {
        assertThrows("SQL validation failed. From line 1, column 32 to line 1, column 52: Object 'error_ods_mysql_users' not found"
                , ValidationException.class
                , () -> context.parse("SELECT id, name, birthday FROM error_ods_mysql_users")
        );

    }


    @Test
    public void testParseWithErrorFiled() {
        assertThrows("SQL validation failed. From line 1, column 8 to line 1, column 15: Column 'error_id' not found in any table"
                , ValidationException.class
                , () -> context.parse("SELECT error_id, name, birthday FROM ods_mysql_users")
        );
    }

    @Test
    public void testParseShow() {
        context.parse("SHOW CATALOGS");
    }
}
