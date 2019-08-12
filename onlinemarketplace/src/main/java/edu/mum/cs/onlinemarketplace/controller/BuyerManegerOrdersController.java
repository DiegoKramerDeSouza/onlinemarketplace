package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.CreditCard;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.domain.UserOrder;
import edu.mum.cs.onlinemarketplace.service.OrderService;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
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

        //Long id = (Long) session.getAttribute("userid");
        Long id = 2L;
        User user = userService.getUserById(id);
        CreditCard creditCard = user.getCreditCard();
        List<UserOrder> orders = orderService.getOrdersByBuyerId(id);
        Comparator<UserOrder> compareByStatus = (UserOrder u1, UserOrder u2) -> u1.getStatus().compareTo( u2.getStatus() );
        Collections.sort(orders, compareByStatus.reversed());

        model.addAttribute("user", user);
        model.addAttribute("creditCard", creditCard);
        model.addAttribute("orders", orders);
        return "buyerManageOrders";
    }

    @PostMapping("/order/{id}/cancel")
    public String cancelOrder(@PathVariable("id") Long id, Model model, RedirectAttributes redirect){
        UserOrder order = orderService.getOrderById(id);
        if(!order.getStatus().equals("shipped")){
            order.setStatus("canceled");
            orderService.saveOrder(order);
            redirect.addFlashAttribute("result", true);
        }
        return "redirect:/buyer/orders";
    }

}
