/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.infrastructure.persistence.mybatis.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * @description: CustomCommentGenerator
 * @author: HamaWhite
 */
public class CustomCommentGenerator implements CommentGenerator {

    private final Properties properties = new Properties();
    private boolean suppressDate = false;
    private boolean suppressAllComments = false;
    private boolean addRemarkComments = false;
    private SimpleDateFormat dateFormat;

    public CustomCommentGenerator() {
        // do nothing
    }

    @Override
    public void addConfigurationProperties(Properties props) {
        this.properties.putAll(props);
        this.suppressDate = StringUtility.isTrue(this.properties.getProperty("suppressDate"));
        this.suppressAllComments = StringUtility.isTrue(this.properties.getProperty("suppressAllComments"));
        this.addRemarkComments = StringUtility.isTrue(this.properties.getProperty("addRemarkComments"));
        String dateFormatString = this.properties.getProperty("dateFormat");
        if (StringUtility.stringHasValue(dateFormatString)) {
            this.dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (!this.suppressAllComments) {
            String description =
                    "This class corresponds to the database table " + introspectedTable.getFullyQualifiedTable();
            topLevelClass.addJavaDocLine("/**");
            topLevelClass.addJavaDocLine(" * @description: " + description);
            topLevelClass.addJavaDocLine(" * @author: " + properties.getProperty("author"));
            // topLevelClass.addJavaDocLine(" * @version: " + properties.getProperty("version"));
            // topLevelClass.addJavaDocLine(" * @date: " + getDateString());
            // add @mbg.generated
            addJavadocTag(topLevelClass);
            topLevelClass.addJavaDocLine(" */");
        }
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        // get the column comment and add it to the comment
        String remarks = introspectedColumn.getRemarks();
        if (!suppressAllComments && addRemarkComments && StringUtility.stringHasValue(remarks)) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + remarks);
            field.addJavaDocLine(" */");
        }
    }

    private void addJavadocTag(JavaElement javaElement) {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append("@mbg.generated");
        javaElement.addJavaDocLine(sb.toString());
    }

    private String getDateString() {
        if (this.suppressDate) {
            return null;
        } else {
            return this.dateFormat != null ? this.dateFormat.format(new Date()) : (new Date()).toString();
        }
    }
}
