package com.mucfc.cn.ddl;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.stmt.TAlterTableStatement;
import gudusoft.gsqlparser.stmt.TCreateTableSqlStatement;

public class GSPSQLParser {
    public static void main(String[] args) {

        String createDDL = "CREATE TABLE products (\n" +
                "  id INTEGER NOT NULL AUTO_INCREMENT primary key,\n" +
                "  name VARCHAR(255) NOT NULL,\n" +
                "  description numeric(12,5),\n" +
                "  weight FLOAT comment 'column'\n" +
//                "  primary key(id)\n" +
                ")COMMENT 'FASFDA' max_row;";


        String verticaCreateTableDDL="create table ods_cas.trx_apply_info" +
                "(a int," +
                "b varchar(100)," +
                "constraint pk_fasfsa_dasf primary key (a))" +
                "order by a" +
                "segemented by a;";
        String alterDDLOne = "ALTER TABLE tbl_name change a b int ;";
        String alterDDLModify = "ALTER TABLE tbl_name modify a  int ,change b c varchar(100);";

        TGSqlParser verticaSqlParser = new TGSqlParser(EDbVendor.dbvvertica);
        verticaSqlParser.sqltext = verticaCreateTableDDL;
        int rs = verticaSqlParser.checkSyntax();
        if(rs == 0){
            System.out.println("语法正确！");
        }else{
            System.out.println("语法错误："+verticaSqlParser.getErrormessage());
        }

        System.out.println();

        TCreateTableSqlStatement createTable  = (TCreateTableSqlStatement)verticaSqlParser.sqlstatements.get(0);

        System.out.println(createTable.getTableComment());
        System.out.println(createTable.getTableName());

        System.out.println(createTable.getTableConstraints());
        System.out.println(createTable.getColumnList());
    }
}
