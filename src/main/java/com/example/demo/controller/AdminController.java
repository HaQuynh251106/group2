package com.example.demo.controller;


import com.example.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Tạo danh sách sản phẩm giả để test
    private List<Product> productList = new ArrayList<>(List.of(
            new Product(1L, "Áo Thun Cotton In Họa Tiết", 250000, 150, "https://via.placeholder.com/60"),
            new Product(2L, "Quần Jean Skinny Nam", 550000, 80, "https://via.placeholder.com/60"),
            new Product(3L, "Váy Hoa Mùa Hè", 450000, 120, "https://via.placeholder.com/60")
    ));
    private long nextProductId = 4L;


    @GetMapping("/dashboard")
    public String dashboard() {
        // Trả về tên của file view (không cần .html)
        return "admin/dashboard";
    }

    // --- Product CRUD ---

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productList);
        return "admin/products/index";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        // Gửi một đối tượng Product rỗng để form có thể binding
        model.addAttribute("product", new Product());
        return "admin/products/form";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product) {
        // Logic để lưu sản phẩm (ở đây chỉ là thêm vào list)
        product.setId(nextProductId++);
        productList.add(product);
        System.out.println("Added new product: " + product.getName());
        return "redirect:/admin/products"; // Chuyển hướng về trang danh sách
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Optional<Product> productToEdit = productList.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (productToEdit.isPresent()) {
            model.addAttribute("product", productToEdit.get());
            return "admin/products/form";
        }
        return "redirect:/admin/products"; // Nếu không tìm thấy, về trang danh sách
    }

    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        Optional<Product> existingProduct = productList.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setStock(product.getStock());
            p.setImageUrl(product.getImageUrl());
            System.out.println("Updated product: " + p.getName());
        }
        return "redirect:/admin/products";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productList.removeIf(p -> p.getId().equals(id));
        System.out.println("Deleted product with id: " + id);
        return "redirect:/admin/products";
    }

    // --- Các trang khác (tạm thời chỉ trả về view) ---

    @GetMapping("/categories")
    public String listCategories() {
        return "admin/categories/index";
    }

    @GetMapping("/orders")
    public String listOrders() {
        return "admin/orders/index";
    }

}
