package com.chartcalculator.repository;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name ="product_house_chart_variable")
public class ProductHouseChartVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_house_chart_variable_seq")
    private Long productHouseChartVariableSeq;

    @Column(name = "variable_type")
    private String variableType;

    @Column(name = "variable_min")
    private BigDecimal variableMin;

    @Column(name = "variable_max")
    private BigDecimal variableMax;

    @Column(name = "variable_detail")
    private String variableDetail;

    @ManyToOne
    @JoinColumn(name = "product_house_chart_seq")
    private ProductHouseChart productHouseChart;

    @ManyToOne
    @JoinColumn(name = "product_house_chart_value_seq")
    private ProductHouseChartValue productHouseChartValue;
}
