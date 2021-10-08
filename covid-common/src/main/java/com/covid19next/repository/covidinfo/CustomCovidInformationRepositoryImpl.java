package com.covid19next.repository.covidinfo;

import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.QCovidInformation;
import com.covid19next.jpa.Querydsl4RepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

public class CustomCovidInformationRepositoryImpl extends Querydsl4RepositorySupport implements CustomCovidInformationRepository {
    public CustomCovidInformationRepositoryImpl() {
        super(CovidInformation.class);
    }

    QCovidInformation ci = QCovidInformation.covidInformation;

    public List<CovidInformation> searchByContainsTitle(String title) {
        return selectFrom(ci)
                .where(ci.title.contains(title))
                .fetch();
    }

}
