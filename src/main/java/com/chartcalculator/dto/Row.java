package com.chartcalculator.dto;

import com.chartcalculator.CalculatorContext;
import com.chartcalculator.type.ValueType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Row {

    private long overviewTblRowSeq;
    private BigDecimal value = BigDecimal.ZERO;
    private String chartType;
    private Map<ColumnType, Column> columnMap = new LinkedHashMap<>();

    public void addColumn(ColumnType columnType, BigDecimal minValue, BigDecimal maxValue, String detailValue) {
        if (columnType == null) {
            return;
        }

        Column column = columnMap.get(columnType);
        if (column == null) {
            column = createColumn(columnType, minValue, maxValue, detailValue);
        } else {
            throw new RuntimeException("잘못된 변수입니다.");
        }

        columnMap.put(columnType, column);
    }

    private Column createColumn(ColumnType columnType, BigDecimal minValue, BigDecimal maxValue, String detailValue) {
        ColumnValue value = new ColumnValue();
        value.setValueType(columnType.getValueType());

        if (columnType.getValueType() == ValueType.Range) {
            value.setMinValue(minValue);
            value.setMaxValue(maxValue);
        } else {
            if (detailValue != null) {
                value.setDetailValue(detailValue);
            }
        }

        Column column = new Column();
        column.setColumnType(columnType);
        column.setColumnValue(value);

        return column;
    }

    public boolean okCondition(CalculatorContext context) {
        for (Column column : columnMap.values()) {
            if (!column.okCondition(context)) {
                return false;
            }
        }
        return true;
    }
}
