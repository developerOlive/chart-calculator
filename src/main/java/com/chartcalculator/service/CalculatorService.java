package com.chartcalculator.service;

import com.chartcalculator.CalculatorContext;
import com.chartcalculator.OverviewTable;
import com.chartcalculator.dto.ColumnValueData;
import com.chartcalculator.dto.HouseInfo;
import com.chartcalculator.dto.UserInfo;
import com.chartcalculator.repository.ProductHouseChartRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Log4j2
@RequiredArgsConstructor
public class CalculatorService implements CommandLineRunner {

    private List<OverviewTable> overviewTableList;

    private final ProductHouseChartRepositoryCustom repository;

    @Override
    public void run(String... args) {
        loadOverviewChart();

        List<OverviewTable> availableOverviewTables = getAvailableOverviewTables();
        Map<OverviewTable, BigDecimal> successOverviewTables = new HashMap<>();
        for (OverviewTable availableOverviewTable : availableOverviewTables) {
            BigDecimal ltv = testCalculate(availableOverviewTable);
            if (ltv != null) {
                successOverviewTables.put(availableOverviewTable, ltv);
            }
        }
        log.info("result : {}", successOverviewTables);
    }

    private List<OverviewTable> getAvailableOverviewTables() {
        List<OverviewTable> overviewTables = this.overviewTableList;
        LocalDateTime now = LocalDateTime.now();

        return overviewTables.stream().filter(ot -> ot.getStartAt().isBefore(now) && ot.getEndAt().isAfter(now)).toList();
    }


    @Scheduled(initialDelay = 0, fixedDelayString = "${app.overviewtable.refresh:3}", timeUnit = TimeUnit.MINUTES)
    public void loadOverviewChart() {

        List<ColumnValueData> overviewTableDataList = repository.selectOverviewTable(1L);

        Map<Long, OverviewTable> overviewTableMap = new HashMap<>();

        for (ColumnValueData columnValueData : overviewTableDataList) {
            OverviewTable overviewTable = overviewTableMap.computeIfAbsent(columnValueData.getOverviewTblSeq(), _seq -> {
                OverviewTable _overviewTbl = new OverviewTable();
                _overviewTbl.setOverviewTabSeq(_seq);
                _overviewTbl.setStartAt(columnValueData.getStartDate());
                _overviewTbl.setEndAt(columnValueData.getEndDate());
                return _overviewTbl;
            });
            overviewTable.add(columnValueData);
        }

        this.overviewTableList = new ArrayList<>(overviewTableMap.values());
    }

    public BigDecimal testCalculate(OverviewTable overviewTable) {

        long start = System.nanoTime();
        CalculatorContext context = new CalculatorContext();
        UserInfo userInfo = new UserInfo();
        userInfo.setCreditPoint(850);
        context.setUserInfo(userInfo);
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setGrade("1");
        houseInfo.setSize(BigDecimal.valueOf(100));
        houseInfo.setBondRank("Y");
        context.setHouseInfo(houseInfo);

        BigDecimal ltv = overviewTable.calculate(context);

        long end = System.nanoTime();
        Duration duration = Duration.ofNanos(end - start);
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
        System.out.println(ltv);

        return ltv;
    }
}
