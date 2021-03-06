package com.chanseok.common.security.service;

import com.chanseok.member.dto.MemberDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MemberContext extends User {

    private final MemberDto memberDto;

    public MemberContext(MemberDto memberDto, Collection<? extends GrantedAuthority> authorities) {
        super(memberDto.getEmail(), memberDto.getPassword(), authorities);
        this.memberDto = memberDto;
    }

    public MemberDto getMemberDto() {
        return memberDto;
    }
}
