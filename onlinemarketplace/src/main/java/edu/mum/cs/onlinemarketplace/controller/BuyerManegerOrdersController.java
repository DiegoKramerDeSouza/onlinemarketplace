package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.service.OrderService;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/buyer")
public class BuyerManegerOrdersController {

    //Order number
    //product list
    //seller name
    //seller email
    //buyer address
    //total price
    //order status
    //* cancel
    //* download PDF

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String userOrders(Model model, HttpSession session){
        return "";
    }
}
