package com.covid19next.service.covid.status;

import com.covid19next.repository.covid.status.CovidGlobalLatestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidGlobalLatestService {
    private final CovidGlobalLatestRepository covidGlobalLatestRepository;
}
