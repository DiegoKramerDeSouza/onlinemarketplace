package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Address;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.repository.UserRepository;
import edu.mum.cs.onlinemarketplace.service.AddressService;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserprofileController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable(value = "id", required = false) Long id, Model model, HttpSession session){

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("shippingAddress", user.getShippingAddress());
        model.addAttribute("billingAddress", user.getBillingAddress());
//        model.addAttribute("addresses", addressService.getAddressByUserId(id));
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String getEditProfile(@ModelAttribute("user") User user,@PathVariable  Long id, Model model, HttpSession session){
        User objUser = (User)session.getAttribute("user");
        model.addAttribute("user", objUser);
        return "editProfileNew";
    }

    @PostMapping("/profile/{id}/update")
    public String updateProfile(@Valid @ModelAttribute("user")User user, @PathVariable Long id, BindingResult result,
                                Model model, HttpSession session){
        User u = (User)session.getAttribute("user");
        u.setName(user.getName());
        u.setCreditCard(user.getCreditCard());
        u.setShippingAddress(user.getShippingAddress());
        u.setBillingAddress(user.getBillingAddress());
        userService.saveUser(u);
        return "redirect:/profile/{id}";
    }







}
