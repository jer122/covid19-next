package com.covid19next.service.member;

import com.covid19next.domain.member.Member;
import com.covid19next.domain.member.MemberRequestDto;
import com.covid19next.domain.member.MemberResponseDto;
import com.covid19next.repository.MemberRepository;
import com.covid19next.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public MemberResponseDto getMyInfo() {
        return memberRepository.findByEmail(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    @Transactional
    public MemberResponseDto changeMember(MemberRequestDto memberRequestDto) {
        Member member = memberRepository.findByEmail(memberRequestDto.getEmail())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        member.changeMember(memberRequestDto);
        return MemberResponseDto.of(member);
    }
}
