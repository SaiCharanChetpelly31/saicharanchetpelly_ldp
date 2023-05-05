package com.spring.springassignment.controller;

import com.spring.springassignment.entity.Product;
import com.spring.springassignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //get all available products
    @GetMapping
    public String getAllProducts(Model theModel){
        List<Product> products =  productService.findAll();
        theModel.addAttribute("products",products);
        return "products/list-products";
    }

    //save or update product
    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product theProduct) {
            productService.save(theProduct);
            return "redirect:/products";
    }

    //form mappings
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Product theProduct = new Product();
        theModel.addAttribute("product",theProduct);
        return "products/product-form";
    }

    //displaying form to update product
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
        Product theProduct = productService.findById(theId);
        theModel.addAttribute("product", theProduct);
        return "products/product-form";
    }

    //delete a product based on id
    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int theId) {
        productService.deleteById(theId);
        return "redirect:/products";
    }
}
