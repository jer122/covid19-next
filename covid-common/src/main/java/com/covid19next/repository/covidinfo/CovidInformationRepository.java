package com.covid19next.repository.covidinfo;

import com.covid19next.domain.covidinfo.CovidInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CovidInformationRepository extends JpaRepository<CovidInformation, String>, CustomCovidInformationRepository {
    public List<CovidInformation> findByContent(String content);
    public Page<CovidInformation> findAll(Pageable pageable);
    public List<CovidInformation> findByTitleContainingOrContentContaining(String title, String content);

}
