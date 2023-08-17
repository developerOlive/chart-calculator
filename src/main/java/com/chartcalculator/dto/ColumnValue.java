package com.chartcalculator.dto;

import com.chartcalculator.type.ValueType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/*
    조견표 변수 입력값 테이블 - 변수 입력 값
 */
@Data
public class ColumnValue {
    private ValueType valueType;
    private BigDecimal minValue = BigDecimal.ZERO;
    private BigDecimal maxValue = BigDecimal.ZERO;
    private Set<String> detailValue = null;

    public void addDetailValue(String value) {
        if (detailValue == null) {
            detailValue = new HashSet<>();
        }
        detailValue.add(value);
    }

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
