package com.chanseok.member.repository;

import com.chanseok.domain.Member;
import com.chanseok.member.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select new com.chanseok.member.dto.MemberDto(m.no, m.email, m.password, m.nickname, m.phone, m.roleType) from Member m where m.email = :email")
    MemberDto findByEmail(@Param("email") String email);
}
