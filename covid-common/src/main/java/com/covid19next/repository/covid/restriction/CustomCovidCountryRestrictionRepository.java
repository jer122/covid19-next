package com.covid19next.repository.covid.restriction;

import com.covid19next.domain.covid.restriction.CountryRestrictionDescription;

public interface CustomCovidCountryRestrictionRepository {
    CountryRestrictionDescription findByCountryRestriction(String code);
}
