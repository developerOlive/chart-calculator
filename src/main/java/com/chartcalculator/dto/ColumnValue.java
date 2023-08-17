package com.chartcalculator.dto;

import com.chartcalculator.type.ValueType;
import lombok.Data;

import java.math.BigDecimal;

/*
    조견표 변수 입력값 테이블 - 변수 입력 값
 */
@Data
public class ColumnValue {
    private ValueType valueType;
    private BigDecimal minValue = BigDecimal.ZERO;
    private BigDecimal maxValue = BigDecimal.ZERO;
    private String detailValue = null;

    // 사용자의 조건이 조견표 변수와 일치하는지 체킹
    public boolean okCondition(UserValue userValue) {
        if (valueType == ValueType.Range) {
            return (minValue.compareTo(userValue.getDecimalValue()) <= 0 && maxValue.compareTo(userValue.getDecimalValue()) >= 0);
        } else {
            if (detailValue == null) {
                return false;
            }
            return detailValue.contains(userValue.getStringValue());
        }
    }
}
