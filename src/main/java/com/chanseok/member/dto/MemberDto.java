package com.chanseok.member.dto;

import com.chanseok.domain.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberDto {
    private Long no;

    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String nickname;

    @NotEmpty(message = "휴대 전화번호를 입력해주세요.")
    private String phone;
    private RoleType roleType;
}
