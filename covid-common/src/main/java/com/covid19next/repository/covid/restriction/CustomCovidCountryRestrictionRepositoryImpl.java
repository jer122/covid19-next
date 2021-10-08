package com.covid19next.repository.covid.restriction;

import com.covid19next.domain.covid.restriction.CountryRestrictionDescription;
import com.covid19next.domain.covid.restriction.QCovidCountryRestriction;
import com.covid19next.domain.covid.restriction.QRestrictionDescription;
import com.covid19next.domain.covidlevel.CovidWarningLevel;
import com.covid19next.jpa.Querydsl4RepositorySupport;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomCovidCountryRestrictionRepositoryImpl extends Querydsl4RepositorySupport implements CustomCovidCountryRestrictionRepository {
    public CustomCovidCountryRestrictionRepositoryImpl() {
        super(CovidWarningLevel.class);
    }

    QCovidCountryRestriction ccr = QCovidCountryRestriction.covidCountryRestriction;
    QRestrictionDescription rd = QRestrictionDescription.restrictionDescription;

    public CountryRestrictionDescription findByCountryRestriction(String code) {
        JPAQuery<CountryRestrictionDescription> query = getQueryFactory().select(
                        Projections.constructor(CountryRestrictionDescription.class,
                                ccr.code
                                , ccr.name
                                , ccr.restrictionType
                                , Expressions.stringTemplate("group_concat({0})", rd.description).as("description")
                        )
                ).from(ccr)
                .innerJoin(rd)
                .on(ccr.code.eq(rd.covidCountryRestriction.code))
                .where(
                        ccr.code.eq(code)
                )
                .groupBy(ccr.code, ccr.name, ccr.restrictionType);
        return query.fetchOne();
    }
}
