package com.chanseok.member.web;

import com.chanseok.member.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @GetMapping(value = "/save")
    public String saveForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "member/saveForm";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam MemberDto memberDto) {

        return "login/loginForm";
    }
}
