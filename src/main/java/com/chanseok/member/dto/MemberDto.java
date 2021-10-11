package com.chanseok.member.dto;

import com.chanseok.domain.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private Long no;
    private String email;
    private String password;
    private String nickname;
    private RoleType roleType;
    private String phone;
}
