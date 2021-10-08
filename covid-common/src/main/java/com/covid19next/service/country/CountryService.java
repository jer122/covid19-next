package com.covid19next.service.country;

import com.covid19next.domain.country.Country;
import com.covid19next.domain.country.CountryResponse;
import com.covid19next.repository.county.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {

    private final CountryRepository countryRepository;

    @Transactional
    public List<Country> saveCountries(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    public Country findById(Long id) {
        return countryRepository
                .findById(id)
                .orElseThrow(NullPointerException::new);
    }

    public CountryResponse findByCode(String code) {
        return countryRepository.findByCode(code)
                .map(this::getCountryResponse)
                .orElseThrow(() -> new IllegalArgumentException("해당 국가 데이터가 없습니다."));
    }

    @Transactional
    public void updateCode(String name, String code) {
        Country country = countryRepository.findByNameEn(name)
                .orElse(null);
        if (country != null) {
            country.codeSync(code);
            log.info("updateCode ->{}", code);
        }
    }

    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    public Page<CountryResponse> findCountries(Pageable pageable) {
        List<CountryResponse> collect = countryRepository.findAll(pageable)
                .stream()
                .map(this::getCountryResponse)
                .collect(Collectors.toList());
        return new PageImpl<CountryResponse>(collect);
    }

    public List<CountryResponse> findNameByKeyword(String keyword) {
        return countryRepository.findByNameKrContainsOrNameEnContains(keyword, keyword)
                .orElseThrow(() -> new IllegalArgumentException("해당 키워드에 대한 정보가 없습니다."))
                .stream()
                .map(country -> CountryResponse.builder()
                        .countryId(country.getId())
                        .countryNameKr(country.getNameKr())
                        .countryNameEn(country.getNameEn())
                        .imgUrl(country.getImgUrl())
                        .code(country.getCode())
                        .build())
                .collect(Collectors.toList());
    }

    private CountryResponse getCountryResponse(Country country) {
        return CountryResponse.builder()
                .countryId(country.getId())
                .code(country.getCode())
                .countryNameEn(country.getNameEn())
                .countryNameKr(country.getNameKr())
                .imgUrl(country.getImgUrl())
                .build();
    }
}
