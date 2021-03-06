package com.chanseok.common.security.service;

import com.chanseok.domain.Member;
import com.chanseok.member.dto.MemberDto;
import com.chanseok.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberDto memberDto = memberRepository.findByEmail(email);

        if(memberDto == null) {
            throw new UsernameNotFoundException("email not found exception");
        }

        List<GrantedAuthority> role = new ArrayList<>();
        role.add(new SimpleGrantedAuthority(memberDto.getRoleType().toString()));
        return new MemberContext(memberDto, role);
    }
}
