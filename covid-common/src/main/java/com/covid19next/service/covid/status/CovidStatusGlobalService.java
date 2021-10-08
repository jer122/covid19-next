package com.covid19next.service.covid.status;

import com.covid19next.domain.country.Country;
import com.covid19next.domain.covid.status.CovidStatusGlobal;
import com.covid19next.repository.covid.status.CovidStatusGlobalRepository;
import com.covid19next.service.country.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidStatusGlobalService {
    private final CovidStatusGlobalRepository covidStatusGlobalRepository;
    private final CountryService countryService;

    @Transactional
    public int covidStatusSaveAll(List<CovidStatusGlobal> covidStatusGlobalList) {
        covidStatusGlobalRepository.saveAll(covidStatusGlobalList);

        return covidStatusGlobalList.size();
    }

    @Transactional
    public void updateCountry(List<CovidStatusGlobal> covidStatusGlobalList) {
//        covidStatusGlobalList.forEach(covidStatusGlobal -> {
//                    Country country = countryService.findByCode(covidStatusGlobal.getCode()).orElse(null);
//                    covidStatusGlobal.countrySync(country);
//        });
    }
}
