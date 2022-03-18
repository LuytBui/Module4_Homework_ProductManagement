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
    public static final String MSG_ACTION_SUCCESSED = "Thao tac thanh cong";
    public static final String MSG_ACTION_FAILED = "Thao tac that bai!";
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
        String message = success ? MSG_ACTION_SUCCESSED : MSG_ACTION_FAILED;
        modelAndView.addObject("success", success);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Product product = productService.findByID(id);
        if (product == null) {
            return new ModelAndView("redirect: /products");
        }

        ModelAndView modelAndView = new ModelAndView("product/delete");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id){
        boolean success = productService.deleteById(id);
        String message = success ? MSG_ACTION_SUCCESSED : MSG_ACTION_FAILED;

        ModelAndView modelAndView = new ModelAndView("product/delete");
        modelAndView.addObject("success", success);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Product product = productService.findByID(id);
        if (product == null) {
            return new ModelAndView("redirect: /products");
        }

        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id, @ModelAttribute Product product){
        boolean success = productService.updateById(id, product);
        String message = success ? MSG_ACTION_SUCCESSED : MSG_ACTION_FAILED;

        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("success", success);
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
