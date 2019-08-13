package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/mainpage")
    public String getAllProducts(Model model){
        model.addAttribute("allProducts",productService.getAllProducts());
        return "index";
    }
}
