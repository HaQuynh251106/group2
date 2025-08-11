package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String categoryList(Model model){
        model.addAttribute("content2", "admin/categories/list");

        return "layouts2/main";
    }

    @GetMapping("create")
    public String categoryCreate(Model model){
        model.addAttribute("content2", "admin/categories/create");

        return "layouts2/main";
    }

    @PostMapping("create")
    public String categoryCreate(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/category";
    }

    @GetMapping("edit/{id}")
    public String categoryEdit(@PathVariable Long id, Model model){
        Category s = categoryRepository.findById(id)
                .orElseThrow();
        model.addAttribute("category",s);
        model.addAttribute("content2","admin/categories/edit");
        return "layouts2/main";
    }

    @GetMapping("edit")
    public String categoryEdit(Model model){
        model.addAttribute("content2", "admin/categories/edit");

        return "layouts2/main";
    }

    @GetMapping("delete/{id}")
    public String categoryDelete(@PathVariable Long id) {
        Category s = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(s);
        return "redirect:/category";
    }
}
