package com.covid19next.repository.covid.status;

import com.covid19next.domain.country.Country;
import com.covid19next.domain.covid.status.CovidStatusGlobal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidStatusGlobalRepository extends JpaRepository<CovidStatusGlobal, Long> {
}
