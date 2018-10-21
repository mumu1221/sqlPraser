package com.mucfc.cn.ddl;

import io.debezium.ddl.parser.mysql.generated.MySqlParser;

import java.util.List;

public class AlterStatment {
    private String alterType;

    public String getAlterType() {
        return alterType;
    }

    public void setAlterType(String alterType) {
        this.alterType = alterType;
    }

    public List<ColumnDefine> getColumnDefineList() {
        return columnDefineList;
    }

    public void setColumnDefineList(List<ColumnDefine> columnDefineList) {
        this.columnDefineList = columnDefineList;
    }

    private List<ColumnDefine> columnDefineList;
}
