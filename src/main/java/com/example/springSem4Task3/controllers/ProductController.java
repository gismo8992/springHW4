package com.example.springSem4Task3.controllers;

import com.example.springSem4Task3.models.Product;
import com.example.springSem4Task3.services.DataProcessingService;
import com.example.springSem4Task3.services.ProductService;
import com.example.springSem4Task3.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private DataProcessingService dataProcessingService;

    @GetMapping("/products")
    public String getAllProduct(Model model) {
        model.addAttribute("product", dataProcessingService.getRepository().getProduct());
        return "products";
    }
    @PostMapping("/products")
    public String addProduct(Product p, Model model) {
        dataProcessingService.addProduct(p);
        model.addAttribute("products", dataProcessingService.getRepository().getProduct());
        return "products";
    }

    /**
     * Сервис регистрации продуктов.
     */
    @Autowired
    private RegistrationService service;

    /**
     * Получение списка продуктов.
     * @return JSON ответ со списком продуктов.
     */
    @GetMapping
    public List<Product> productList() {
        return service.getDataProcessingService().getRepository().getProduct();
    }
}
