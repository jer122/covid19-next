package com.covid19next.service.covid.restriction;

import com.covid19next.domain.covid.restriction.RestrictionDescription;
import com.covid19next.repository.covid.restriction.RestrictionDescriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestrictionDescriptionService {

    private final RestrictionDescriptionRepository restrictionDescriptionRepository;

    @Transactional(readOnly = true)
    public List<RestrictionDescription> findByCode(String code) {
        return restrictionDescriptionRepository.findByCovidCountryRestriction_Code(code).orElseThrow(() -> new IllegalArgumentException("해당 국가는 정보가 없습니다."));
    }

}
