package com.guvi.springthymeleaf.controller;


import com.guvi.springthymeleaf.entity.Product;
import com.guvi.springthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm() {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/displayProduct")
    public String displayProducts(Model model) {
        model.addAttribute("products",new Product());
        return "displayProduct";
    }


    @PostMapping ("/displayProduct")
    public String displayProducts(@RequestParam("category") String category, Model model) {
    List<Product>products=productService.getAllProductsByCategory (category);
    model.addAttribute("products", products);
    return "productList";
}
    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products"; // This will return products.html Thymeleaf template
    }

}

