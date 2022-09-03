package springSecurityTest.kangsh.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springSecurityTest.kangsh.domain.MemberEntity;
import springSecurityTest.kangsh.dto.MemberDto;
import springSecurityTest.kangsh.service.MemberService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/") // 메인페이지
    public String index(){
        return "Milky/index2";
    }

    @GetMapping("/user/signup") // 회원가입 페이지
    public String dispSignup(){
        return "Milky/signup";
    }

    @PostMapping("/user/signup") // 회원가입 처리
    public String execsignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }
    
    @GetMapping("/user/login") // 로그인 페이지
    public String dispLogin() {
        return "Milky/login";
    }

    @GetMapping("/user/login/result") // 로그인 결과 페이지
    public String dispLoginResult() {
        return "loginSuccess";
    }

    @GetMapping("/user/logout/result") // 로그아웃 결과 페이지
    public String dispLogout() {
        return "/logout";
    }

    @GetMapping("/user/denied") //접근 거부 페이지
    public String dispDenied() {
        return "/denied";
    }

    @GetMapping("/user/info") // 내정보 페이지
    public String dispMyInfo(Model model, @AuthenticationPrincipal MemberEntity currentMember) {
        List<MemberEntity> memberEntityList = memberService.memberEntityList();

        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(currentMember.getEmail());
        memberDto.setGoon(currentMember.getGoon());

        model.addAttribute("memberEntityList", memberEntityList);

        return "myinfo";
    }

    @GetMapping("/admin") // 관리자용 페이지
    public String dispAdmin() {
        return "/admin";
    }

    @GetMapping("/user/allmembers") //전체 회원 조회
    public String memberEntityList(Model model) {
        model.addAttribute("member", memberService.memberEntityList());
        return "memberlist";
    }



}
