package com.chartcalculator.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductHouseChartValue is a Querydsl query type for ProductHouseChartValue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductHouseChartValue extends EntityPathBase<ProductHouseChartValue> {

    private static final long serialVersionUID = 496200198L;

    public static final QProductHouseChartValue productHouseChartValue = new QProductHouseChartValue("productHouseChartValue");

    public final NumberPath<Long> productHouseChartValueSeq = createNumber("productHouseChartValueSeq", Long.class);

    public final NumberPath<java.math.BigDecimal> variableValue = createNumber("variableValue", java.math.BigDecimal.class);

    public QProductHouseChartValue(String variable) {
        super(ProductHouseChartValue.class, forVariable(variable));
    }

    public QProductHouseChartValue(Path<? extends ProductHouseChartValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductHouseChartValue(PathMetadata metadata) {
        super(ProductHouseChartValue.class, metadata);
    }

}

