package com.chartcalculator.repository;

import com.chartcalculator.dto.ColumnValueData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.chartcalculator.repository.QProductHouseChart.productHouseChart;
import static com.chartcalculator.repository.QProductHouseChartValue.productHouseChartValue;
import static com.chartcalculator.repository.QProductHouseChartVariable.productHouseChartVariable;

@Repository
@RequiredArgsConstructor
public class ProductHouseChartRepositoryImpl implements ProductHouseChartRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ColumnValueData> selectOverviewTable() {
        return queryFactory
                .select(Projections.fields(ColumnValueData.class,
                        productHouseChart.productHouseSeq,
                        productHouseChart.chartType,
                        productHouseChart.productHouseChartSeq.as("overviewTblSeq"),
                        productHouseChartValue.productHouseChartValueSeq.as("overviewTblRowSeq"),
                        productHouseChartValue.variableValue.as("value"),
                        productHouseChartVariable.variableType.as("colName"),
                        productHouseChartVariable.variableMin.as("minValue"),
                        productHouseChartVariable.variableMax.as("maxValue"),
                        productHouseChartVariable.variableDetail.as("detailValue"),
                        productHouseChart.launchStart.as("startDate"),
                        productHouseChart.launchEnd.as("endDate")
                ))
                .from(productHouseChart)
                .leftJoin(productHouseChartVariable).on(productHouseChart.productHouseChartSeq.eq(productHouseChartVariable.productHouseChart.productHouseChartSeq))
                .leftJoin(productHouseChartValue).on(productHouseChartVariable.productHouseChartValue.productHouseChartValueSeq.eq(productHouseChartValue.productHouseChartValueSeq))
                .fetch();
    }
}
