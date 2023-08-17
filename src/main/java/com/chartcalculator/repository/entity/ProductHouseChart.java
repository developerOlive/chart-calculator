package com.chartcalculator.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_house_chart")
public class ProductHouseChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_house_chart_seq")
    private Long productHouseChartSeq;

    @Column(name = "product_house_seq")
    private Long productHouseSeq;

    @Column(name = "chart_type")
    private String chartType;

    @Column(name = "launch_start")
    private String launchStart;

    @Column(name = "launch_end")
    private String launchEnd;

    @Column(name = "grade_level")
    private int gradeLevel;

    @Column(name = "reg_user_seq")
    private Long regUserSeq;

    @Column(name = "upd_user_seq")
    private Long updUserSeq;

    @Column(name = "reg_date")
    private String regDate;

    @Column(name = "upd_date")
    private String updDate;
}
