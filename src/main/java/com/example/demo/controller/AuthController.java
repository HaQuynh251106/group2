package com.example.demo.controller;




import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class AuthController {



    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("register")
    public String registerForm(Model model) {
        model.addAttribute("user", new Users()); // để form binding
        return "auth/register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute Users user){

        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        return "redirect:/register";
    }

//    @GetMapping("register")
//    public String registerForm(Model model) {
////        model.addAttribute("user", new Users());
//        return "auth/register";
//    }ư
//
//    @PostMapping("register")
//    public String register(@ModelAttribute Users user) {
//        user.setRole("GUEST");
//        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword()); // ma hoa mat khau
//        user.setPassword(hashPassword);
//        userRepository.save(user);
//        return "redirect:/login";
//    }

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }

//    @PostMapping("login")
//    public String postLogin(@ModelAttribute Users user, HttpSession session) {
//        List<Users> list = userRepository.findByEmail(user.getEmail());
//        if (list.size() > 0) {
//            Users exisUser = list.get(0);
//            // so sanh password
//            if (bCryptPasswordEncoder.matches(user.getPassword(), exisUser.getPassword())) {
//                session.setAttribute("currentUser",exisUser);
//                return "redirect:/";
//            }
//        }
//        return "redirect:/login";
//    }

    @PostMapping("login")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session) {
        List<Users> list = userRepository.findByUsername(username);
        if (!list.isEmpty()) {
            Users existingUser = list.get(0);
            if (bCryptPasswordEncoder.matches(password, existingUser.getPassword())) {
                session.setAttribute("currentUser", existingUser);
                return "redirect:/";
            }
        }
        return "redirect:/login?error=true";
    }


    @GetMapping("logout")
    public String logout(HttpSession session){
        session.setAttribute("currentUser",null);
        return"redirect:/";
    }
}
