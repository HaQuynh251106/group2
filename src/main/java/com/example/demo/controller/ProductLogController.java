package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product-log")
@Controller
public class ProductLogController {
    @GetMapping()
    public String dashboard(Model model){
        model.addAttribute("content2", "admin/product-log/index");

        return "layouts2/main";
    }
}
