package com.chartcalculator;

import com.chartcalculator.dto.ColumnType;
import com.chartcalculator.dto.ColumnValueData;
import com.chartcalculator.dto.Row;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/*
   조견표
 */
@Getter
@ToString
public class overviewTable {

    private long overviewTabSeq;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private final Map<Long, Row> rowMap = new LinkedHashMap<>();

    public void add(ColumnValueData data) {
        ColumnType columnType = ColumnType.of(data.getColName());
        if (columnType == null) {
            return;
        }

        /*
            rowMap 에서 사용자 입력값 순번으로 데이터를 조회하고
            데이터가 존재하지 않는 경우는 해당값을 반환,
            존재하지 않는 경우는 rowMap 에 put 처리
         */
        Row row = rowMap.computeIfAbsent(data.getOverviewTblRowSeq(), _seq -> {
           Row _row = new Row();
           _row.setOverviewTblRowSeq(_seq);
           _row.setValue(data.getValue());
           _row.setChartType(data.getChartType());
           return _row;
        });

        row.addColumn(columnType, data.getMinValue(), data.getMaxValue(), data.getDetailValue());
    }

    /*
        rowMap 을 돌면서 조견표 조건을 확인함
        조건이 만족되는 첫 번째 행을 찾아 조견표 사용자 입력값을 찾아오고, 조건을 만족하지 못하면 null 반환
     */
    public BigDecimal calculate(CalculatorContext context) {
        Row row = rowMap.values().stream().filter(r -> r.okCondition(context)).findFirst().orElse(null);
        if (row == null) {
            return null;
        }

        return row.getValue();
    }

    public void setOverviewTabSeq(long overviewTabSeq) {
        this.overviewTabSeq = overviewTabSeq;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }
}
