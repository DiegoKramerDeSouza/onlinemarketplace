package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.UserOrder;
import edu.mum.cs.onlinemarketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class SellerManagerOrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String managerOrders(Model model, HttpSession session){
//        Long id = (Long) session.getAttribute("userid");
        Long id = 1L;
        model.addAttribute("orders", orderService.getOrdersBySellerId(id));
        return "sellerManageOrders";
    }

    @PostMapping("/order/change/{id}/{status}")
    public String cancelOrder(@PathVariable("id") Long id,
                              @PathVariable("status") String status, Model model, RedirectAttributes redirect){
        UserOrder userOrder = orderService.getOrderById(id);
        userOrder.setStatus(status);
        orderService.saveOrder(userOrder);
        redirect.addFlashAttribute("result", true);
        return "redirect:/seller/orders";
    }


}
