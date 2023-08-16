package com.chartcalculator;

import com.chartcalculator.repository.ProductHouseChartRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CalculatorService implements CommandLineRunner {

    private final ProductHouseChartRepositoryCustom productHouseChartRepositoryCustom;

    public List<ColumnValueData> getOverviewTable() {
        return productHouseChartRepositoryCustom.selectOverviewTable();
    }

    @Override
    public void run(String... args) {

    }
}
