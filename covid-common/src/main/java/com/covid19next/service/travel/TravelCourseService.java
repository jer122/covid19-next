package com.covid19next.service.travel;

import com.covid19next.domain.city.City;
import com.covid19next.domain.member.Member;
import com.covid19next.domain.travel.*;
import com.covid19next.repository.MemberRepository;
import com.covid19next.repository.city.CityRepository;
import com.covid19next.repository.travel.TravelCourseRepository;
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
public class TravelCourseService {

    private final TravelCourseRepository travelCourseRepository;
    private final MemberRepository memberRepository;
    private final CityRepository cityRepository;

    @Transactional(readOnly = true)
    public Page<TravelCourseListResponse> findAllTravelCourse(PageRequest request) {
        List<TravelCourseListResponse> collect = travelCourseRepository.findAll(request).stream().map(TravelCourseListResponse::new).collect(Collectors.toList());
        Page<TravelCourseListResponse> page = new PageImpl<>(collect);
        return page;
    }

    @Transactional(readOnly = true)
    public List<TravelCourseResponse> findTravelCourseByKeyword(String keyword) {
        return travelCourseRepository.findByCourseNameContainsOrContentContainsOrCity_NameKrOrCity_Country_NameKr(keyword, keyword, keyword, keyword)
                .orElseThrow(() -> new IllegalArgumentException("해당 키워드에 대한 정보가 없습니다."))
                .stream()
                .map(travelCourse -> TravelCourseResponse.builder()
                        .countryId(travelCourse.getCity().getCountry().getId())
                        .countryName(travelCourse.getCity().getCountry().getNameKr())
                        .countryNameEn(travelCourse.getCity().getCountry().getNameEn())
                        .cityId(travelCourse.getCity().getId())
                        .cityName(travelCourse.getCity().getNameKr())
                        .cityNameEn(travelCourse.getCity().getNameEn())
                        .cityName(travelCourse.getCity().getNameKr())
                        .cityNameEn(travelCourse.getCity().getNameEn())
                        .travelCourseId(travelCourse.getId())
                        .image(travelCourse.getImage())
                        .displayName(travelCourse.getMember().getDisplayName())
                        .starPoint(travelCourse.getStarPoint())
                        .content(travelCourse.getContent())
                        .createdAt(travelCourse.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public TravelCourse findTravelCourse(Long id) {
        return travelCourseRepository.findById(id).orElseThrow(IllegalArgumentException::new);

    }


    @Transactional
    public Long save(TravelCourseRequest travelCourse) {
        Member member = memberRepository.findById(travelCourse.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자 정보가 없습니다."));

        City city = cityRepository.findById(travelCourse.getCityId())
                .orElseThrow(() -> new IllegalArgumentException("도시 정보가 없습니다."));

        return travelCourseRepository
                .save(travelCourse.toEntity(city, member))
                .getId();
    }

    @Transactional
    public TravelCourseResponse update(Long id, TravelCourseRequest request) {
        TravelCourse travelCourse = getTravelCourse(id);
        travelCourse.update(request.getCourseName(), request.getContent());

        return TravelCourseResponse.builder()
                .travelCourseId(travelCourse.getId())
                .courseName(travelCourse.getCourseName())
                .content(travelCourse.getContent())
                .build();
    }


    @Transactional
    public Long updateStarPoint(Long id, StarPointRequest startPoint) {
        TravelCourse travelCourse = getTravelCourse(id);
        travelCourse.updateStarPoint(startPoint.getStarPoint());
        return travelCourse.getStarPoint();
    }

    @Transactional
    public Long delete(Long id) {
        TravelCourse travelCourse = getTravelCourse(id);
        travelCourseRepository.delete(travelCourse);
        return travelCourse.getId();
    }

    private TravelCourse getTravelCourse(Long id) {
        return travelCourseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("여행 코스 정보가 없습니다"));
    }
}
