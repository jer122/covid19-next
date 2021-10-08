package com.covid19next.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private long id;
    private String email;
    private String name;
    private String displayName;
    private Boolean socialCertification;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getMemberId() ,member.getEmail(), member.getName(), member.getDisplayName(), member.getSocialCertification());
    }
}
