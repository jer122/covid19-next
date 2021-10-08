package com.covid19next.repository.city;

import com.covid19next.domain.city.City;
import com.covid19next.domain.country.Country;
import com.covid19next.jpa.Querydsl4RepositorySupport;
import com.covid19next.repository.covidinfo.CustomCovidInformationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, CustomCovidInformationRepository {
    List<City> findByCountry(Country country);
}
