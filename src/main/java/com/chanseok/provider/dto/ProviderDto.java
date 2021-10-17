package com.chanseok.provider.dto;

import com.chanseok.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProviderDto {
    private Member member;
    private String nickname;
    private String verification;
    private String location;

    public ProviderDto(String nickname, String verification, String location) {
        this.nickname = nickname;
        this.verification = verification;
        this.location = location;
    }
}
