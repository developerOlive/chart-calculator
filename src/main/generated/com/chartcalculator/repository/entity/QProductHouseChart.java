package com.chartcalculator.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductHouseChart is a Querydsl query type for ProductHouseChart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductHouseChart extends EntityPathBase<ProductHouseChart> {

    private static final long serialVersionUID = -1242637781L;

    public static final QProductHouseChart productHouseChart = new QProductHouseChart("productHouseChart");

    public final StringPath chartType = createString("chartType");

    public final NumberPath<Integer> gradeLevel = createNumber("gradeLevel", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> launchEnd = createDateTime("launchEnd", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> launchStart = createDateTime("launchStart", java.time.LocalDateTime.class);

    public final NumberPath<Long> productHouseChartSeq = createNumber("productHouseChartSeq", Long.class);

    public final NumberPath<Long> productHouseSeq = createNumber("productHouseSeq", Long.class);

    public final StringPath regDate = createString("regDate");

    public final NumberPath<Long> regUserSeq = createNumber("regUserSeq", Long.class);

    public final StringPath updDate = createString("updDate");

    public final NumberPath<Long> updUserSeq = createNumber("updUserSeq", Long.class);

    public QProductHouseChart(String variable) {
        super(ProductHouseChart.class, forVariable(variable));
    }

    public QProductHouseChart(Path<? extends ProductHouseChart> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductHouseChart(PathMetadata metadata) {
        super(ProductHouseChart.class, metadata);
    }

}

