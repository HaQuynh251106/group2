package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@Controller
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping()
    public String orderList(Model model){
        model.addAttribute("content2", "admin/orders/list");

        return "layouts2/main";
    }

    @GetMapping("create")
    public String orderCreate(Model model){
        model.addAttribute("content2", "admin/orders/create");

        return "layouts2/main";
    }

    @PostMapping("create")
    public String orderCreate(@ModelAttribute Order order){
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping("edit/{id}")
    public String orderEdit(@PathVariable Long id, Model model){
        Order s = orderRepository.findById(id)
                .orElseThrow();
        model.addAttribute("order",s);
        model.addAttribute("content2","admin/orders/edit");
        return "layouts2/main";
    }

    @GetMapping("edit")
    public String orderEdit(Model model){
        model.addAttribute("content2", "admin/orders/edit");

        return "layouts2/main";
    }

    @GetMapping("delete/{id}")
    public String orderDelete(@PathVariable Long id) {
        Order s = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(s);
        return "redirect:/orders";
    }
}
