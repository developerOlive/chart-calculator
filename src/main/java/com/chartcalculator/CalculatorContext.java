package com.chartcalculator;

import com.chartcalculator.dto.HouseInfo;
import com.chartcalculator.dto.UserInfo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculatorContext {
    private UserInfo userInfo;
    private HouseInfo houseInfo;
    private BigDecimal ltv;

    public void addFailResultList(long productSeq, String message) {
        // 실패한 계산 데이터 처리
    }

}
