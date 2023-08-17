package com.chartcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnValueData {

    private long overviewTblSeq; // 조견표 순번
    private long overviewTblRowSeq; // 사용자 입력값 순번
    private String chartType; // 조견표 유형
    private BigDecimal value; // 사용자 입력값
    private String colName; // 변수종류 (credit, size 등)
    private BigDecimal minValue; // 변수 최소값
    private BigDecimal maxValue; // 변수 최대값
    private String detailValue; // 변수 상세
    private String startDate; // 조견표 운영 시작 일시
    private String endDate; // 조견표 운영 종료 일시
}
