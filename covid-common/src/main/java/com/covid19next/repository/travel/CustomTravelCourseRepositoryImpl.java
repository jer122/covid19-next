package com.covid19next.repository.travel;

import com.covid19next.domain.city.QCity;
import com.covid19next.domain.country.QCountry;
import com.covid19next.domain.covidlevel.CovidWarningLevel;
import com.covid19next.domain.travel.QTravelCourse;
import com.covid19next.domain.travel.TravelCourse;
import com.covid19next.domain.travel.TravelCourseListResponse;
import com.covid19next.domain.travel.TravelCourseResponse;
import com.covid19next.jpa.Querydsl4RepositorySupport;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class CustomTravelCourseRepositoryImpl extends Querydsl4RepositorySupport implements CustomTravelCourseRepository {
    public CustomTravelCourseRepositoryImpl() {
        super(TravelCourse.class);
    }

    QTravelCourse travelCourse = QTravelCourse.travelCourse;
    QCountry country = QCountry.country;
    QCity city = QCity.city;

    public Page<TravelCourseResponse> findByTravelCourseResponse(String keyword, Pageable pageable) {
        JPAQuery<TravelCourseResponse> query = getQueryFactory().select(
                        Projections.constructor(TravelCourseResponse.class,
                                country.id,
                                country.nameKr,
                                country.nameEn,
                                city.id,
                                city.nameKr,
                                city.nameEn,
                                travelCourse.id,
                                travelCourse.courseName,
                                travelCourse.starPoint,
                                travelCourse.content,
                                travelCourse.member.displayName,
                                travelCourse.image,
                                travelCourse.createdAt
                        )
                ).from(travelCourse)
                .join(city)
                .on(city.id.eq(travelCourse.city.id))
                .leftJoin(country)
                .on(country.id.eq(city.country.id))
                .where(
                        containsContinentName(keyword)
                                .or(containsCountryName(keyword))
                                .or(containsCountryNameEn(keyword))
                                .or(containsCityName(keyword))
                                .or(containsCityNameEn(keyword))
                                .or(containsCourse(keyword))
                                .or(containsContent(keyword))
                );

        if (pageable != null) {
            query.limit(pageable.getPageSize());
            query.offset(pageable.getOffset());
        }

        return new PageImpl<TravelCourseResponse>(query.fetch());
    }


    private BooleanExpression containsContinentName(String keyWord) {

        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return country.continent.name.contains(keyWord);
    }


    private BooleanExpression containsCountryName(String keyWord) {

        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return country.nameKr.contains(keyWord);
    }

    private BooleanExpression containsCountryNameEn(String keyWord) {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return country.nameEn.contains(keyWord);
    }

    private BooleanExpression containsCityName(String keyWord) {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return city.nameKr.contains(keyWord);
    }

    private BooleanExpression containsCityNameEn(String keyWord) {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return country.nameEn.contains(keyWord);
    }

    private BooleanExpression containsCourse(String keyWord) {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return travelCourse.courseName.contains(keyWord);
    }

    private BooleanExpression containsContent(String keyWord) {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        return travelCourse.content.contains(keyWord);
    }
}
