package donguk.server.controller;

import donguk.server.domain.Member;
import donguk.server.domain.MemberDTO;
import donguk.server.service.MemberService;
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
    public String singup() {
        return "member/signup";
    }

    @PostMapping("/member/signup")
    public String singup(@ModelAttribute MemberDTO memberDTO) {
        //System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "redirect:/";
    }


    @GetMapping("/member/signin")
    public String signin() {
        return "member/signin";
    }

}
