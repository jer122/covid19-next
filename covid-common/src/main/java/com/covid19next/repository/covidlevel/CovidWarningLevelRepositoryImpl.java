package com.covid19next.repository.covidlevel;

import com.covid19next.domain.country.QCountry;
import com.covid19next.domain.covid.restriction.QCovidCountryRestriction;
import com.covid19next.domain.covid.status.QCovidStatusGlobal;
import com.covid19next.domain.covid.status.QCovidStatusGlobal_CovidStatusGlobalId;
import com.covid19next.domain.covidinfo.CovidLevelCountry;
import com.covid19next.domain.covidlevel.CovidWarningLevel;
import com.covid19next.domain.covidlevel.QCovidWarningLevel;
import com.covid19next.jpa.Querydsl4RepositorySupport;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

public class CovidWarningLevelRepositoryImpl extends Querydsl4RepositorySupport implements CustomCovidWarningLevelRepository {
    public CovidWarningLevelRepositoryImpl() {
        super(CovidWarningLevel.class);
    }

    QCovidWarningLevel covidWarningLevel = QCovidWarningLevel.covidWarningLevel;
    QCountry country = QCountry.country;
    QCovidStatusGlobal_CovidStatusGlobalId covidStatusGlobalId = QCovidStatusGlobal_CovidStatusGlobalId.covidStatusGlobalId;
    QCovidStatusGlobal covidStatusGlobal = QCovidStatusGlobal.covidStatusGlobal;
    QCovidCountryRestriction covidCountryRestriction = QCovidCountryRestriction.covidCountryRestriction;

    public List<CovidWarningLevel> findByLevel(List<Long> level) {
        return selectFrom(covidWarningLevel)
                .where(covidWarningLevel.level.in(level))
                .fetch();
    }

    public List<CovidLevelCountry> findByContinentCovidLevelCountriesCovidLevel(List<Long> level) {
        return getCovidLevelCountries(level, null, null).fetch();

    }

    public CovidLevelCountry findCountryCovidLevelData(List<Long> level, String countryName) {
        JPAQuery<CovidLevelCountry> query = getCovidLevelCountries(level, countryName, PageRequest.of(0, 1));
        return query.fetchOne();
    }

    private JPAQuery<CovidLevelCountry> getCovidLevelCountries(List<Long> level, String name, Pageable pageable) {
        boolean pageableCheck = pageable != null;
        JPAQuery<CovidLevelCountry> query = getQueryFactory().select(
                        Projections.constructor(CovidLevelCountry.class,
                                country.id,
                                country.code,
                                country.continentNameKr,
                                country.continentNameEn,
                                country.nameKr,
                                country.nameEn,
                                country.imgUrl,
                                covidWarningLevel.country,
                                covidWarningLevel.level,
                                covidWarningLevel.levelName,
                                covidStatusGlobal.population,
                                covidStatusGlobal.todayDeaths,
                                covidStatusGlobal.todayConfirmed,
                                covidStatusGlobal.updatedAt.as("latest_date"),
                                covidCountryRestriction.restrictionType)
                )
                .from(covidWarningLevel)
                .innerJoin(country)
                .on(covidWarningLevel.country.eq(country.nameKr))
                .leftJoin(covidStatusGlobal)
                .on(covidStatusGlobal.statusGlobalId.code.eq(country.code))
                .leftJoin(covidCountryRestriction)
                .on(covidCountryRestriction.code.eq(country.code))
                .where(
//                        containsContinentName(continentName),
                        containsCountryName(name),
                        inLevels(level)
                                .and(country.code.isNotNull())
                                .and(formatDateYmd("%Y-%m-%d")
                                        .eq(JPAExpressions.select(formatDateYmd("%Y-%m-%d").max()).from(covidStatusGlobal)
                                        )
                                )
                )
                .orderBy(orderByFiled(pageableCheck));

        if (pageableCheck) {
            query.limit(pageable.getPageSize());
            query.offset(pageable.getOffset());
        }

        return query;
    }

    private StringTemplate formatDateYmd(String format) {
        return Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , covidStatusGlobal.updatedAt
                , ConstantImpl.create(format)
        );
    }


    private BooleanExpression containsCountryName(String countryName) {
        if (StringUtils.isEmpty(countryName)) {
            return null;
        }
        return country.nameEn.contains(countryName);
    }

    private BooleanExpression containsContinentName(String continentName) {
        if (StringUtils.isEmpty(continentName)) {
            return null;
        }
        return country.continentNameEn.contains(continentName);
    }

    private BooleanExpression inLevels(List<Long> level) {
        if (level.isEmpty()) {
            return null;
        }
        return covidWarningLevel.level.in(level);
    }

    private OrderSpecifier orderByFiled(boolean checked) {
        if (checked) {
            return covidStatusGlobal.updatedAt.desc();
        }
        return country.continentNameEn.desc();
    }

}
