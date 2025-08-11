package com.example.demo.controller;


import com.example.demo.entity.Products;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String productList(Model model){
        model.addAttribute("content2", "admin/products/list");

        return "layouts2/main";
    }

    @GetMapping("create")
    public String productCreate(Model model){
        model.addAttribute("content2", "admin/products/create");
//        model.addAttribute("product", new Product()); // Product là entity hoặc DTO
//        model.addAttribute("categories", categoryService.findAll()); // để select danh mục hoạt động
        return "layouts2/main";
    }

    @PostMapping("create")
    public String productCreate(@ModelAttribute Products products){
        productRepository.save(products);
        return "redirect:/products";
    }

    @GetMapping("edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        Products s = productRepository.findById(id)
                .orElseThrow();
        model.addAttribute("product",s);
        model.addAttribute("content2","admin/products/edit");
        return "layouts2/main";
    }

    @GetMapping("edit")
    public String productEdit(Model model){
        model.addAttribute("content2", "admin/products/edit");

        return "layouts2/main";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Products s = productRepository.findById(id).orElseThrow();
        productRepository.delete(s);
        return "redirect:/products";
    }
}
