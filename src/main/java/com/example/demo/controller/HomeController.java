package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("content","home");

        return "layouts/main";
    }

    @GetMapping("blog-details")
    public String blogDetails(Model model){
        model.addAttribute("content","blog-details");

        return "layouts/main";
    }


    @GetMapping("about")
    public String about(Model model){
        model.addAttribute("content","about");

        return "layouts/main";
    }
    @GetMapping("blog")
    public String blog(Model model){
        model.addAttribute("content","blog");

        return "layouts/main";
    }

    @GetMapping("/shop") // Ánh xạ tới đường dẫn "/shop"
    public String showShopPage(Model model) {
        model.addAttribute("content","shop");

        return "layouts/main";
    }

    @GetMapping("/contact") // Ánh xạ tới đường dẫn "/contact"
    public String showContactPage(Model model) {
        model.addAttribute("content","contact");

        return "layouts/main";
    }


    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        model.addAttribute("content","checkout");

        return "layouts/main";
    }

    @GetMapping("/shop-details")
    public String showShopDetailsPage(Model model) {
        model.addAttribute("content","shop-details");

        return "layouts/main";
    }

    @GetMapping("/shopping-cart")
    public String showShoppingCartPage(Model model) {
        model.addAttribute("content","shopping-cart");

        return "layouts/main";
    }
}