package com.covid19next.repository.travel;

import com.covid19next.domain.travel.TravelCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelCourseRepository extends JpaRepository<TravelCourse, Long>, CustomTravelCourseRepository {
    public Page<TravelCourse> findAll(Pageable pageable);

    public Optional<List<TravelCourse>> findByCourseNameContainsOrContentContainsOrCity_NameKrOrCity_Country_NameKr(String courseName, String content, String cityName, String countryName);
}
