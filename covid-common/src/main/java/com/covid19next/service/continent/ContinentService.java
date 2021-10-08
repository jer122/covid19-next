package com.covid19next.service.continent;

import com.covid19next.domain.continent.Continent;
import com.covid19next.domain.continent.ContinentClientResponse;
import com.covid19next.repository.continent.ContinentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContinentService {

    private final ContinentRepository continentRepository;

    public int saveAll(List<Continent> continentList) {
        return continentRepository.saveAll(continentList).size();
    }

    public List<ContinentClientResponse> findAll() {
        return continentRepository.findAll().stream().map(continent -> ContinentClientResponse.builder()
                        .id(continent.getId())
                        .code(continent.getCode())
                        .continent(continent.getName())
                        .name(continent.getNameEn())
                        .imgUrl(continent.getImgUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
