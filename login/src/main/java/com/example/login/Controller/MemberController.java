package com.example.login.Controller;

import com.example.login.dto.MemberDTO;
import com.example.login.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;

    @GetMapping("/")
    public String main(Model model) {
        // model.addAttribute("data","hello!!!");
        return "main";
    }

    @PostMapping("/")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginRequest = memberService.login(memberDTO);
        if (loginRequest != null) {
            session.setAttribute("loginname",loginRequest.getName());
            return "ksg";
        } else {
            //로그인 실패
            return "main";
        }
    }
}
