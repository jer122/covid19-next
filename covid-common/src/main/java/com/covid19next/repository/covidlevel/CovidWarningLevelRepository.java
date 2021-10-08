package com.covid19next.repository.covidlevel;

import com.covid19next.domain.covidlevel.CovidWarningLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidWarningLevelRepository extends JpaRepository<CovidWarningLevel, Long>, CustomCovidWarningLevelRepository {
//    List<CovidWarningLevel> findByLevel(Long level);
    List<CovidWarningLevel> findAll();
}
