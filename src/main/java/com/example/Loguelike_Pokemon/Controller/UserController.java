package com.example.Loguelike_Pokemon.Controller;

import com.example.Loguelike_Pokemon.Entity.UserEntity;
import com.example.Loguelike_Pokemon.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 1. 메인 페이지 이동
    @GetMapping("/")
    public String homePage() {
        return "HomePage";
    }

    // 2. 회원가입 페이지 이동 (중복 제거됨!)
    @GetMapping("/register")
    public String registerPage() {
        return "Register";
    }

    // 3. 회원가입 처리 (DB 저장)
    @PostMapping("/register")
    public String registerUser(UserEntity user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    // 4. 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("userPw") String userPw,
                        HttpSession session) {

        UserEntity user = userService.login(userId, userPw);

        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/";
        } else {
            return "redirect:/?error=true";
        }
    }

    // 5. 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // 6. 아이디/비번 찾기 페이지 이동
    @GetMapping("/find")
    public String findUser() {
        return "Find";
    }

    // UserController.java 에 추가
    @GetMapping("/homeMenu")
    public String homeMenu() {
        return "HomeMenu"; // templates/HomeMenu.html 을 열어줍니다.
    }
}