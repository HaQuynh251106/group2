package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("test")
//    public String testUser (Model model){
//        model.addAttribute("content2", "admin/users/create_form");
//        return "layouts2/main";
//    }

    @GetMapping()
    public String getAllUser(Model model){
        List<Users> list = userRepository.findAll();
        model.addAttribute("user",list);
        model.addAttribute("content2","admin/users/list");
        return "layouts2/main";
    }

    @GetMapping("create")
    public String formCreate(Model model){
        model.addAttribute("content2","admin/users/create");
        return "layouts2/main";
    }

    @PostMapping("create")
    public String createUser(@ModelAttribute Users user){
        userRepository.save(user);
        return "redirect:/admin/users/create";
    }

    @GetMapping("edit/{id}")
    public String editUser(@PathVariable Long id, Model model){
        Users s = userRepository.findById(id)
                .orElseThrow();
        model.addAttribute("users",s);
        model.addAttribute("content2","admin/users/edit");
        return "layouts2/main";
    }

    @PostMapping("edit")
    public String updateUser(@ModelAttribute Users user){
        userRepository.save(user);
        return "redirect:admin/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id){
        Users s = userRepository.findById(id).orElseThrow();
        userRepository.delete(s);
        return "redirect:/admin/users";
    }

}
