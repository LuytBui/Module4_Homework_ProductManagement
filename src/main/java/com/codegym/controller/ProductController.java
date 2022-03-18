package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    public static final String MSG_ADD_PRODUCT_SUCCESSED = "Thêm sản phẩm thành công";
    public static final String MSG_ADD_PRODUCT_FAILED = "Thất bại! Kiểm tra lại dữ liệu nhập vào!";
    @Autowired
    IProductService productService;

    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("product/list");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/add")
    public String showAddProductForm(){
        return "product/add";
    }

    @PostMapping("/add")
    public ModelAndView addNewProduct(
            @RequestParam String name,
            @RequestParam Long price,
            @RequestParam String description,
            @RequestParam String image
    ){
        ModelAndView modelAndView = new ModelAndView("product/add");
        Product product = new Product(name, price, description, image);
        boolean success = productService.create(product);
        String message = success ? MSG_ADD_PRODUCT_SUCCESSED : MSG_ADD_PRODUCT_FAILED;
        modelAndView.addObject("success", success);
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
