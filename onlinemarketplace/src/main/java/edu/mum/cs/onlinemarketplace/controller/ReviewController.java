package edu.mum.cs.onlinemarketplace.controller;


import edu.mum.cs.onlinemarketplace.domain.Review;
import edu.mum.cs.onlinemarketplace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;


@Controller

public class ReviewController {

    @Autowired
    ReviewService reviewService;

//    @PostMapping("/product/{pid}/newReview")
//    public String addReview(@Valid @ModelAttribute("newReview") Review review,BindingResult result, @PathVariable Long pid,  Model model){
//
//        if(result.hasErrors())
//            return "/product/{pid}";
//        else {
//            review.setCreateDate(LocalDate.now());
//            reviewService.addReview(review);
//
//        }
//
//    return "redirect:/product/{pid}";
//    }
}
