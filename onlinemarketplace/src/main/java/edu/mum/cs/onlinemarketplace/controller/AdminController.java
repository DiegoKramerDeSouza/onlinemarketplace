package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Review;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.email.EmailService;
import edu.mum.cs.onlinemarketplace.service.ReviewService;
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
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private EmailService emailService;



    @GetMapping("/users/SellerList")
    public String getAllSeller(Model model){
        model.addAttribute("sellerList",sellerService.getAllSeller());
        System.out.println("Seller="+sellerService.getAllSeller());
        return "adminHome";
    }

    @GetMapping("/users/manageSellers")
    public String manageSellerForm(Model model){
        model.addAttribute("manageSeller",sellerService.getAllPendingSeller());
        System.out.println("Seller="+sellerService.getAllPendingSeller());

        return "manageSeller";
    }

    @PostMapping("/users/addSeller/{id}")
    public String approveSeller(@PathVariable("id")Long id,Model model){
        User newSeller = sellerService.findUserBySellerId(id);
        newSeller.setName(newSeller.getName());
        newSeller.setName(newSeller.getEmail());
        newSeller.setPassword(newSeller.getPassword());
        newSeller.setStatus("Approved");
//        System.out.println("status==============="+status);
        sellerService.save(newSeller);
        emailService.sendSimpleMessage("sanjtrital@gmail.com","Accepted","Congratulations!! You are accepted as Seller.");
        return "redirect:/users/SellerList";
    }

    @PostMapping("/users/removeSeller/{id}")
    public String removeSeller(@PathVariable("id")Long id){
        User newSeller = sellerService.findUserBySellerId(id);
        newSeller.setName(newSeller.getName());
        newSeller.setName(newSeller.getEmail());
        newSeller.setPassword(newSeller.getPassword());
        newSeller.setType("BUYER");
//        System.out.println("status==============="+status);
        sellerService.save(newSeller);
        emailService.sendSimpleMessage("sanjtrital@gmail.com","Rejected","Sorry! we can't approve you as Seller");
        return "redirect:/users/SellerList";
    }

    @GetMapping("/users/manageReviews")
    public String manageReviewForm(Model model){
        model.addAttribute("reviewList",reviewService.getAllReview());
        return "manageReview";
    }
    @PostMapping("/users/manageReview/{rid}/accept")
    public String acceptReview(@PathVariable("rid") Long rid,Model model){
        Review updateReview = reviewService.findReviewById(rid);
        updateReview.setStatus("approved");
        reviewService.save(updateReview);
        return "redirect:/users/manageReviews";
    }
    @PostMapping("/users/manageReview/{rid}/delete")
    public String deleteReview(@PathVariable("rid") Long rid){
        reviewService.delete(rid);
        return "redirect:/users/manageReviews";
    }

}
