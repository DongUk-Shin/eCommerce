package donguk.server.controller;

import donguk.server.domain.DTO.MemberDTO;
import donguk.server.domain.Member;
import donguk.server.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signupForm() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO) {
        //System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "redirect:/";
    }


    @GetMapping("/signin")
    public String signinForm() {
        return "member/signin";
    }

    @PostMapping("/signin")
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

    @GetMapping("/account")
    public String accountForm() {
        return "member/account";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
