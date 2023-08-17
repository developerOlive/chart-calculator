package com.chartcalculator.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.chartcalculator.repository.entity.ProductHouseChartVariable;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductHouseChartVariable is a Querydsl query type for ProductHouseChartVariable
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductHouseChartVariable extends EntityPathBase<ProductHouseChartVariable> {

    private static final long serialVersionUID = 619414752L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductHouseChartVariable productHouseChartVariable = new QProductHouseChartVariable("productHouseChartVariable");

    public final QProductHouseChart productHouseChart;

    public final QProductHouseChartValue productHouseChartValue;

    public final NumberPath<Long> productHouseChartVariableSeq = createNumber("productHouseChartVariableSeq", Long.class);

    public final StringPath variableDetail = createString("variableDetail");

    public final NumberPath<java.math.BigDecimal> variableMax = createNumber("variableMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> variableMin = createNumber("variableMin", java.math.BigDecimal.class);

    public final StringPath variableType = createString("variableType");

    public QProductHouseChartVariable(String variable) {
        this(ProductHouseChartVariable.class, forVariable(variable), INITS);
    }

    public QProductHouseChartVariable(Path<? extends ProductHouseChartVariable> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductHouseChartVariable(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductHouseChartVariable(PathMetadata metadata, PathInits inits) {
        this(ProductHouseChartVariable.class, metadata, inits);
    }

    public QProductHouseChartVariable(Class<? extends ProductHouseChartVariable> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productHouseChart = inits.isInitialized("productHouseChart") ? new QProductHouseChart(forProperty("productHouseChart")) : null;
        this.productHouseChartValue = inits.isInitialized("productHouseChartValue") ? new QProductHouseChartValue(forProperty("productHouseChartValue")) : null;
    }

}

