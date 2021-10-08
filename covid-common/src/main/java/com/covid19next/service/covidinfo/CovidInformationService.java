package com.covid19next.service.covidinfo;

import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.CovidInformationResponse;
import com.covid19next.repository.covidinfo.CovidInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidInformationService {

    private final CovidInformationRepository covidInformationRepository;

    @Transactional(readOnly = true)
    public Page<CovidInformationResponse> findAll(PageRequest pageRequest) {
        List<CovidInformationResponse> collect = covidInformationRepository
                .findAll(pageRequest)
                .stream()
                .map(this::buildByDto)
                .collect(Collectors.toList());

        Page<CovidInformationResponse> page = new PageImpl<>(collect);
        return page;
    }

    @Transactional(readOnly = true)
    public CovidInformation findById(String id) {
        return covidInformationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional(readOnly = true)
    public List<CovidInformationResponse> findAllByKeyword(String keyword) {
        return covidInformationRepository.findByTitleContainingOrContentContaining(keyword, keyword).stream()
                .map(this::buildByDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public int saveCovidInformation(List<CovidInformation> informationList) {
        covidInformationRepository.saveAll(informationList);
        return informationList.size();
    }

    public CovidInformationResponse buildByDto(CovidInformation covidInformation) {
        return CovidInformationResponse.builder()
                .id(covidInformation.getNoticeId())
                .content(covidInformation.getContent())
                .title(covidInformation.getTitle())
                .code(covidInformation.getCode())
                .countryEngName(covidInformation.getCountryEngName())
                .countryName(covidInformation.getCountryName())
                .continentName(covidInformation.getContinentName())
                .continentEngName(covidInformation.getContinentEngName())
                .writeDt(covidInformation.getWrtDt())
                .fileUrl(covidInformation.getFileUrl())
                .filePath(covidInformation.getFilePath())
                .build();
    }


}
