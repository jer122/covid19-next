package com.covid19next.service.covid.restriction;

import com.covid19next.domain.covid.restriction.CountryRestrictionDescription;
import com.covid19next.domain.covid.restriction.CovidCountryRestriction;
import com.covid19next.domain.covid.restriction.RestrictionDescription;
import com.covid19next.repository.covid.restriction.CovidCountryRestrictionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidCountryRestrictionService {
    private final CovidCountryRestrictionRepository covidCountryRestrictionRepository;
    private final RestrictionDescriptionService restrictionDescriptionService;

    @Transactional(readOnly = true)
    public CountryRestrictionDescription findByCountryRestrictionDescription(String code) {
        CovidCountryRestriction covidCountryRestriction = covidCountryRestrictionRepository.findByCode(code).orElseThrow(() -> new IllegalArgumentException("해당 국가는 정보가 없습니다."));
        String description = restrictionDescriptionService.findByCode(covidCountryRestriction.getCode())
                .stream()
                .map(RestrictionDescription::getDescription)
                .collect(Collectors.joining());

        return CountryRestrictionDescription.builder()
                .code(covidCountryRestriction.getCode())
                .countryName(covidCountryRestriction.getName())
                .restrictionType(covidCountryRestriction.getRestrictionType())
                .description(description)
                .build();
    }
}
