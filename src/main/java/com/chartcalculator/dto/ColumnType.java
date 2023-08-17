package com.chartcalculator.dto;

import com.chartcalculator.CalculatorContext;
import com.chartcalculator.type.ValueType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    조견표 변수 테이블 - 변수 타입
 */
@Getter
@RequiredArgsConstructor
public enum ColumnType {

    CreditPoint("credit", ValueType.Range, context -> new UserValue(BigDecimal.valueOf(context.getUserInfo().getCreditPoint()))),
    Ltv("ltv", ValueType.Range, context -> new UserValue(context.getLtv())),
    Grade("grade", ValueType.Detail, context -> new UserValue(context.getHouseInfo().getGrade())),
    BondRank("bond_rank", ValueType.Detail, context -> new UserValue(context.getHouseInfo().getBondRank())),
    Size("size", ValueType.Range, context -> new UserValue(context.getHouseInfo().getSize()));

    private final String name;
    private final ValueType valueType;
    private final UserValueExtractor extractor;

    private final static Map<String, ColumnType> typeMap;
    static {
        typeMap = new HashMap<>();
        Arrays.stream(values()).forEach(s -> typeMap.put(s.getName().toLowerCase(), s));
    }

    public static ColumnType of(String name) {
        if (name == null) {
            return null;
        }
        return typeMap.get(name.toLowerCase());
    }

    /*
        CalculatorContext 에서 UserValue 추출하는 역할을 하는 함수형 인터페이스
     */
    @FunctionalInterface
    public interface UserValueExtractor {
        UserValue extract(CalculatorContext context);
    }
}
