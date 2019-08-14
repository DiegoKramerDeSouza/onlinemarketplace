package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Ads;
import edu.mum.cs.onlinemarketplace.domain.Product;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.service.AdsService;
import edu.mum.cs.onlinemarketplace.service.ProductService;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class IndexController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    AdsService adsService;

    @RequestMapping(value="/")
    public String getAllProducts(Model model, HttpSession session){
//        Long id = (Long) session.getAttribute("userid");
        Long id = 1L;
        User user = userService.getUserById(id);
        model.addAttribute("allProducts",productService.getAllProducts());

        //Get Ads
        List<Product> products = productService.getProductsFromAds();
        if(products.size() > 0) model.addAttribute("adsProducts", products);

        //Set user data
        if(user == null){
            session.setAttribute("type", "OFF");
            return "index";
        }
        session.setAttribute("user", user);
        session.setAttribute("type", user.getType());
        return "index";
    }
}
