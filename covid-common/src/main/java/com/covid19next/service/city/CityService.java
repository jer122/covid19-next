package com.covid19next.service.city;


import com.covid19next.domain.city.City;
import com.covid19next.domain.city.CityListResponse;
import com.covid19next.domain.city.CityRequest;
import com.covid19next.domain.city.CityResponse;
import com.covid19next.domain.country.Country;
import com.covid19next.repository.city.CityRepository;
import com.covid19next.repository.county.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public int saveCities(List<City> cityList) {
        return cityRepository.saveAll(cityList).size();
    }

    @Transactional(readOnly = true)
    public List<CityResponse> getCities(String name) {
        Country country = countryRepository.findByNameEn(name).orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다"));
        return cityRepository.findByCountry(country).stream().map(CityResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CityResponse> findAll() {
        return cityRepository.findAll().stream().map(CityResponse::new).collect(Collectors.toList());
    }


    @Transactional
    public Long saveCity(CityRequest cityRequest) {
        Country country = getCountry(cityRequest.getCountyId());

        return cityRepository.save(cityRequest.toEntity(country)).getId();
    }

    private Country getCountry(Long countyId) {
        return countryRepository.findById(countyId).orElseThrow(() -> new IllegalArgumentException("등록된 국가 정보가 없습니다"));
    }
}
