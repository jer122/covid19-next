package com.covid19next.repository.city;

import com.covid19next.domain.city.City;
import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.QCovidInformation;
import com.covid19next.jpa.Querydsl4RepositorySupport;
import com.covid19next.repository.covidinfo.CustomCovidInformationRepository;

import java.util.List;

public class CustomCityRepositoryImpl extends Querydsl4RepositorySupport implements CustomCityRepository {
    public CustomCityRepositoryImpl() {
        super(City.class);
    }


}
