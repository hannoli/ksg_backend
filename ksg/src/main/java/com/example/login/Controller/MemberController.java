package com.example.login.Controller;

import com.example.login.dto.AlterDTO;
import com.example.login.dto.MemberDTO;
import com.example.login.service.AlterService;
import com.example.login.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;
    private final AlterService alterService;
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
            return "redirect:ksg";
        } else {
            //로그인 실패
            return "redirect:";
        }
    }

    @GetMapping("/ksg")
    public String ksg(Model model, HttpSession session) {
        // 로그인한 회원에게만 접근 가능한 기능 처리
        String loginName = (String) session.getAttribute("loginname");
        if (loginName != null) {
            // 로그인한 회원의 이름이 존재하면 처리할 로직 작성
            // 예를 들어 모델에 데이터를 추가하거나 다른 작업을 수행할 수 있습니다.
            model.addAttribute("username", loginName);
            return "ksg"; // 해당하는 뷰 페이지로 이동
        } else {
            // 로그인하지 않은 경우에는 다른 페이지로 리다이렉트 또는 예외 처리 등을 수행할 수 있습니다.
            return "redirect:/"; // 로그인 페이지로 리다이렉트
        }
    }

  /*  @PostMapping("/ksg")
    public String add(@ModelAttribute AlterDTO alterDTO, HttpSession session) {
        AlterDTO saveRequest = alterService.save(alterDTO);
        if (saveRequest != null) {
            session.setAttribute("saveroom",saveRequest.getRoom());
            return "redirect:ksg";
        } else {
            //로그인 실패
            return "redirect:ksg";
        }
    }

    @PostMapping("/ksg")
    public String remove() {
        // 삭제 작업 수행
        // 삭제 작업을 위한 필요한 로직을 구현합니다.
        // 예시로서 remove() 메서드를 호출하여 특정 작업을 수행합니다.
        alterService.remove();

        // 삭제 작업 후 리다이렉트할 페이지나 뷰 이름을 반환합니다.
        return "redirect:/";
    }*/
  @PostMapping("/ksg")
  public String handleKsgAction(@ModelAttribute AlterDTO alterDTO, @RequestParam(name = "action", required = false) String action, HttpSession session) {
      if ("호출하기".equals(action)) {
          // 호출하기 버튼을 눌렀을 때의 동작
          AlterDTO saveRequest = alterService.save(alterDTO);
          if (saveRequest != null) {
              session.setAttribute("saveroom", saveRequest.getRoom());
          }
          return "redirect:/ksg";
      } else if ("삭제하기".equals(action)) {
          // 삭제하기 버튼을 눌렀을 때의 동작
          alterService.remove();
          return "redirect:/";
      } else {
          // 액션 파라미터가 없거나 잘못된 값일 경우 처리할 로직
          return "redirect:/";
      }
  }

}
