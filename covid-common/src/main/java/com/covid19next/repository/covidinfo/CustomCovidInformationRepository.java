package com.covid19next.repository.covidinfo;

import com.covid19next.domain.covidinfo.CovidInformation;

import java.util.List;

public interface CustomCovidInformationRepository {
    List<CovidInformation> searchByContainsTitle(String title);
}
