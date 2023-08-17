package com.chartcalculator.dto;

import com.chartcalculator.CalculatorContext;
import lombok.Data;

/*
    조견표 - 변수 타입 및 변수 입력값 통합 클래스
 */
@Data
public class Column {
    private ColumnType columnType;
    private ColumnValue columnValue;

    public boolean okCondition(CalculatorContext context) {
        UserValue userValue = extractValueForCompare(context);
        return columnValue.okCondition(userValue);
    }

    public UserValue extractValueForCompare(CalculatorContext context) {
        return columnType.getExtractor().extract(context);
    }
}
