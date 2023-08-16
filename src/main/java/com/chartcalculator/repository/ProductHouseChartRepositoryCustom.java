package com.chartcalculator.repository;

import com.chartcalculator.ColumnValueData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHouseChartRepositoryCustom {

    List<ColumnValueData> selectOverviewTable();
}
