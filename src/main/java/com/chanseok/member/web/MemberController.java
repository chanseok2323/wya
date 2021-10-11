package com.chanseok.member.web;

import com.chanseok.domain.Member;
import com.chanseok.domain.RoleType;
import com.chanseok.member.dto.MemberDto;
import com.chanseok.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String save(@Valid MemberDto form, BindingResult result) {

        if(result.hasErrors()) {
            return "member/saveForm";
        }

        form.setPassword(passwordEncoder.encode(form.getPassword()));
        Member member = new Member(form.getEmail(), form.getPassword(), form.getNickname(), form.getPhone(), RoleType.ROLE_USER);

        memberService.saveMember(member);
        return "login/loginForm";
    }
}
