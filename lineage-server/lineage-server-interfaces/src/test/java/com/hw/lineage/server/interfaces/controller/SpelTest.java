package com.hw.lineage.server.interfaces.controller;


import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;


/**
 * @description: SpelTest
 * @author: HamaWhite
 */
public class SpelTest {

    @Test
    public void testSpelWithParameters() {
        ExpressionParser parser = new SpelExpressionParser();
        String expressionString = "'Query Table: ' + #catalog + '.' + #database+'.' + #tableName";

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("catalog", "memory_catalog");
        context.setVariable("database", "default");
        context.setVariable("tableName", "ods_mysql_users");

        String result = parser.parseExpression(expressionString).getValue(context, String.class);
        assertThat(result).isEqualTo("Query Table: memory_catalog.default.ods_mysql_users");
    }


    @Test
    public void testSpelWithoutParameters() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("pluginName", "plugin_demo_1");

        String expression1 = "Check Plugin Exist";
        assertThrows("EL1041E: After parsing a valid expression, there is still more data in the expression: 'Plugin'"
                , SpelParseException.class
                , () -> parser.parseExpression(expression1).getValue(context, String.class));

        // strings with no parameters are enclosed in single quotation marks
        String expression2 = "'Check Plugin Exist'";
        String result=parser.parseExpression(expression2).getValue(context, String.class);
        assertThat(result).isEqualTo("Check Plugin Exist");
    }
}