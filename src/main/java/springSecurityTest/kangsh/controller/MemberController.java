package springSecurityTest.kangsh.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springSecurityTest.kangsh.dto.MemberDto;
import springSecurityTest.kangsh.service.MemberService;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/") // 메인페이지
    public String index(){
        return "/index";
    }

    @GetMapping("/user/signup") // 회원가입 페이지
    public String dispSignup(){
        return "/signup";
    }

    @PostMapping("/user/signup") // 회원가입 처리
    public String execsignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }
    
    @GetMapping("/user/login") // 로그인 페이지
    public String dispLogin() {
        return "/login";
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
    public String dispMyInfo() {
        return "/myinfo";
    }

    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }

}
