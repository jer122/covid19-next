package com.covid19next.domain.member;

import com.covid19next.domain.travel.TravelCourse;
import com.covid19next.domain.auth.AuthProvider;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId ;
    private String name;
    private String displayName;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private String subscribeStatus;
    private Boolean socialCertification;
    private String authId;
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private LocalTime createdAt;
    private LocalTime updateAt;

    @OneToMany(mappedBy = "member")
    private List<TravelCourse> travelCourses = new ArrayList<>();

    public Member(String name, String email, String authId, Boolean socialCertification, AuthProvider provider, MemberRole memberRole){
        this.name = name;
        this.email = email;
        this.authId = authId;
        this.socialCertification = socialCertification;
        this.provider = provider;
        this.memberRole = memberRole;
    }

    public void changeMember(MemberRequestDto memberRequestDto){
        this.gender = memberRequestDto.getGender();
        this.phone = memberRequestDto.getPhone();
        this.displayName = memberRequestDto.getDisplayName();
        this.socialCertification = true;
    }

    public void changeMemberOauth(Long memberId, String name, String email, String authId, AuthProvider provider){
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.authId = authId;
        this.provider = provider;
    }

}
