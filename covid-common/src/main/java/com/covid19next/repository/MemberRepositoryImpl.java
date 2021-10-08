package com.covid19next.repository;

import com.covid19next.domain.member.Member;
import com.covid19next.jpa.Querydsl4RepositorySupport;

public class MemberRepositoryImpl extends Querydsl4RepositorySupport implements CustomMemberRepository {
    public MemberRepositoryImpl() {
        super(Member.class);
    }



}
