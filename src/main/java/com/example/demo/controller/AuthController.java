package com.example.demo.controller;




import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class AuthController {



    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("content","auth/login");

        return "auth/login";
    }



//    @GetMapping("/login")
//    public String login() {
//        return "auth/login";
//    }


    @GetMapping("logout")
    public String logout(HttpSession session){
        session.setAttribute("currentUser",null);
        return"redirect:/";
    }
}
