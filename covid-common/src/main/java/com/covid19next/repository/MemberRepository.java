package com.covid19next.repository;

import com.covid19next.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
    public Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

}
