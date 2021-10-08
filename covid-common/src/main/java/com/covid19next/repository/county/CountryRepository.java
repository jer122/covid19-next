package com.covid19next.repository.county;

import com.covid19next.domain.country.Country;
import com.covid19next.domain.covidinfo.CovidInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository  extends JpaRepository<Country, Long> {
    public Optional<Country> findByNameEn(String name);
    public Optional<Country> findByCode(String code);
    public Optional<List<Country>> findByNameKrContainsOrNameEnContains(String nameKr, String nameEn);
}
