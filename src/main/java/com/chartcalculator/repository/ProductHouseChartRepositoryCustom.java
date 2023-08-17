package com.chartcalculator.repository;

import com.chartcalculator.dto.ColumnValueData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHouseChartRepositoryCustom {

    List<ColumnValueData> selectOverviewTable(long overviewTableSeq);
}
