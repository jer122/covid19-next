package com.covid19next.repository.covidlevel;

import com.covid19next.domain.covidinfo.CovidLevelCountry;
import com.covid19next.domain.covidlevel.CovidWarningLevel;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomCovidWarningLevelRepository {
    public List<CovidWarningLevel> findByLevel(List<Long> levels);

    public List<CovidLevelCountry> findByContinentCovidLevelCountriesCovidLevel(List<Long> levels);

    public CovidLevelCountry findCountryCovidLevelData(List<Long> levels, String countryName);

}
