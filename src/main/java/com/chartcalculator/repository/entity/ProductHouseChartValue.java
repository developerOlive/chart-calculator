package com.chartcalculator.repository.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_house_chart_value")
public class ProductHouseChartValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_house_chart_value_seq")
    private Long productHouseChartValueSeq;

    @Column(name = "variable_value")
    private BigDecimal variableValue;
}
