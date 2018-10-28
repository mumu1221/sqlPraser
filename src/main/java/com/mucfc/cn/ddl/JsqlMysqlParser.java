package com.mucfc.cn.ddl;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import sun.java2d.pipe.OutlineTextRenderer;

import java.io.StringReader;
import java.util.List;

public class JsqlMysqlParser {
    public static void main(String[] args) {

        String createDDL = "CREATE TABLE products (\n" +
                "  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  name VARCHAR(255) NOT NULL,\n" +
                "  description numeric(12,5),\n" +
                "  weight FLOAT comment 'column',\n" +
                "  primary key(id)\n" +
                ") comment='sadfadfa'  max_row=10;";


        String verticaCreateTableDDL="create table ods_cas.trx_apply_info" +
                "(a int," +
                "b varchar(100)," +
                "constraint pk_fasfsa_dasf primary key (a))" +
                "order by a" +
                "segemented by a;";
        String alterDDLOne = "ALTER TABLE tbl_name changy a b int ;";


        CCJSqlParserManager pm = new CCJSqlParserManager();
        net.sf.jsqlparser.statement.Statement statement = null;
        try {
            statement = pm.parse(new StringReader(createDDL));
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }


        if (statement instanceof CreateTable) {
            CreateTable createTable = (CreateTable) statement;
            List<ColumnDefinition> createTableColumnDefine=createTable.getColumnDefinitions();

            for(ColumnDefinition columnDefinition:createTableColumnDefine){
                System.out.println(columnDefinition.getColumnName());
                System.out.println(columnDefinition.getColDataType());
                List<String> columnTags=columnDefinition.getColumnSpecStrings();
                for(String columnTag:columnTags){
                    columnTag.toLowerCase().equals("primary");
                    System.out.println("主键");
                }
            }

            System.out.println(createTable.getIndexes());
        }
    }
}
