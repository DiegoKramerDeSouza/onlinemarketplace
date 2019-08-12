package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private SellerService sellerService;



    @GetMapping("users/manageSellers")
    public String manageSellerForm(Model model){
        model.addAttribute("manageSeller",sellerService.getAllSeller());
        System.out.println("Seller="+sellerService.getAllSeller());
        return "manageSeller";
    }

    @PostMapping("users/addSeller/{id}")
    public String approveSeller(@PathVariable("id")Long id,Model model){
        User newSeller = sellerService.findUserBySellerId(id);
        newSeller.setStatus("Approved");
//        System.out.println("status==============="+status);
        sellerService.save(newSeller);
        return "redirect:/users/manageSellers";
    }

    @PostMapping("/users/removeSeller/{id}")
    public String removeSeller(@PathVariable("id")Long id){
        User newSeller = sellerService.findUserBySellerId(id);
        newSeller.setType("BUYER");
//        System.out.println("status==============="+status);
        sellerService.save(newSeller);
        return "redirect:/users/manageSellers";
    }

}
