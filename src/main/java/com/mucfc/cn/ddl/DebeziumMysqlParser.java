package com.mucfc.cn.ddl;

import io.debezium.connector.mysql.MySqlDdlParser;
import io.debezium.relational.Table;
import io.debezium.relational.TableId;
import io.debezium.relational.Tables;
import io.debezium.relational.ddl.DdlParser;

public class DebeziumMysqlParser {
    public static void main(String[] args) {

        String createDDL = "CREATE TABLE products (\n" +
                "  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  name VARCHAR(255) NOT NULL,\n" +
                "  description numeric(12,5),\n" +
                "  weight FLOAT comment 'column',\n" +
                "  primary key(id)\n" +
                ") comment='sadfadfa'  max_row=10;";

        DdlParser parser = new MySqlDdlParser();
        Tables tables = new Tables();
        parser.parse(createDDL, tables);

        tables.tableIds();
    }
}
