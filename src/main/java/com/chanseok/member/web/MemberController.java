package com.chanseok.member.web;

import com.chanseok.domain.Member;
import com.chanseok.domain.RoleType;
import com.chanseok.member.dto.MemberDto;
import com.chanseok.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private MemberService memberService;
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/save")
    public String saveForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "member/saveForm";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute MemberDto memberDto) {

        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member member = new Member(memberDto.getEmail(), memberDto.getPassword(), memberDto.getNickname(), memberDto.getPhone(), RoleType.ROLE_USER);
        memberService.saveMember(member);
        return "login/loginForm";
    }
}
