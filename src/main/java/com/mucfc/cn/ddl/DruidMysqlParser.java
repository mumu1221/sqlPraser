package com.mucfc.cn.ddl;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlCreateTableParser;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlExprParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;

import java.util.List;

public class DruidMysqlParser {
    public static void main(String[] args) {
        String createDDL = "CREATE TABLE products (a int PRIMARY KEY comment 'mysql',b varchar(10)) comment='saffsda';";


        String verticaCreateTableDDL="create table ods_cas.trx_apply_info" +
                "(a int," +
                "b varchar(100)," +
                "constraint pk_fasfsa_dasf primary key (a))" +
                "order by a" +
                "segemented by a;";
        String alterDDLOne = "ALTER TABLE tbl_name changy a b int ;";

        SQLStatementParser sqlStatementParser=new SQLStatementParser(createDDL);


        MySqlSchemaStatVisitor mySqlSchemaStatVisitor=new MySqlSchemaStatVisitor();

        sqlStatementParser.parseCreate().accept(mySqlSchemaStatVisitor);

        System.out.println(mySqlSchemaStatVisitor.getColumns());
        System.out.println(mySqlSchemaStatVisitor.getParameters());
        System.out.println(mySqlSchemaStatVisitor.getVariants());
        System.out.println(mySqlSchemaStatVisitor.getRelationships());
        System.out.println(mySqlSchemaStatVisitor.getOrderByColumns());



    }

}
