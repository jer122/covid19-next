package com.covid19next.repository.covid.status;

import com.covid19next.domain.covid.status.CovidGlobalLatest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidGlobalLatestRepository extends JpaRepository<CovidGlobalLatest, Long> {
}
