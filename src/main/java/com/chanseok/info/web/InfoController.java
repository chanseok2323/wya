package com.chanseok.info.web;

import com.chanseok.member.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
public class InfoController {

    @GetMapping(value = "my-info")
    public String myInfo(@SessionAttribute MemberDto memberDto, Model model) {
        System.out.println("memberDto.getClass() = " + memberDto.getClass());
        model.addAttribute("memberDto", memberDto);
        return "info/myInfo";
    }
}
