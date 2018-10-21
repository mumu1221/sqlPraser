package com.mucfc.cn.ddl;

import io.debezium.connector.mysql.MySqlDdlParser;
import io.debezium.connector.mysql.antlr.MySqlAntlrDdlParser;
import io.debezium.connector.mysql.antlr.listener.AlterTableParserListener;
import io.debezium.ddl.parser.mysql.generated.MySqlLexer;
import io.debezium.ddl.parser.mysql.generated.MySqlParser;
import io.debezium.relational.Column;
import io.debezium.relational.TableEditor;
import io.debezium.relational.TableId;
import io.debezium.relational.Tables;
import io.debezium.relational.ddl.DdlParser;
import io.debezium.relational.ddl.DdlParserListener;
import io.debezium.relational.ddl.DdlTokenizer;
import io.debezium.text.TokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenSource;

import java.util.List;
import java.util.Set;

public class mysqlParser {
    public static void main(String[] args) {

        String createDDL="CREATE TABLE products (\n" +
                "  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  name VARCHAR(255) NOT NULL,\n" +
                "  description numeric(12,5),\n" +
                "  weight FLOAT\n" +
                ");";

        String alterDDLOne="ALTER TABLE tbl_name ADD PRIMARY KEY (column), ALGORITHM=INPLACE, LOCK=NONE;";


        MySqlDdlParser parser=new MySqlDdlParser();

        Tables tables=new Tables();

        parser.parse(alterDDLOne,tables);
        System.out.println(tables.);

/*        Set<TableId> tableIdSet=tables.tableIds();

        for (TableId tableId: tableIdSet) {
            TableEditor tableEditor=tables.editOrCreateTable(tableId);
            List<Column> columnList=tableEditor.columns();
            List<String> parimayColumn=tableEditor.primaryKeyColumnNames();

            for (Column column:columnList) {
                System.out.println(column.name());
                System.out.println(column.typeName());
                System.out.println(column.typeExpression());
                System.out.println(column.length());
                System.out.println(column.scale());
                System.out.println();
            }
        }*/




//        System.out.println(tables.editOrCreateTable(tables.tableIds().iterator().next()).columns().get(0));
    }


}
