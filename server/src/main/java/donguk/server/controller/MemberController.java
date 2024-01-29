package donguk.server.controller;

import donguk.server.domain.Member;
import donguk.server.domain.MemberDTO;
import donguk.server.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/signup")
    public String signupForm() {
        return "member/signup";
    }

    @PostMapping("/member/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO) {
        //System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "redirect:/";
    }


    @GetMapping("/member/signin")
    public String signinForm() {
        return "member/signin";
    }

    @PostMapping("/member/signin")
    public String signin(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO result = memberService.signin(memberDTO);
        if (result != null) {
            session.setAttribute("signinName", result.getName());
            session.setAttribute("signinEmail", result.getEmail());
            return "redirect:/";
        } else {
            return "member/signin";
        }
    }

    @GetMapping("/member/account")
    public String accountForm() {
        return "member/account";
    }


    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
