package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reviews")
@Controller
public class ReviewController {

    private ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping()
    public String reviewList(Model model){
        model.addAttribute("content2", "admin/reviews/list");

        return "layouts2/main";
    }

    @GetMapping("delete/{id}")
    public String reviewDelete(@PathVariable Long id) {
        Review s = reviewRepository.findById(id).orElseThrow();
        reviewRepository.delete(s);
        return "redirect:/reviews";
    }
}
