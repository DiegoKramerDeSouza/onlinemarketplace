package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Ads;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.service.AdsService;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminAdsController {
    @Autowired
    UserService userService;

    @Autowired
    AdsService adsService;

    @GetMapping("/manage/ads")
    public String manageAds(Model model){
        List<Ads> ads = adsService.getAllAds();
        model.addAttribute("adsList", ads);
        return "adminManageADs";
    }

    @PostMapping("/manage/ads/search")
    public String searchUser(Model model, @RequestParam("email") String email, RedirectAttributes redirect){
        System.out.println("==>" + email);
        List<User> users = userService.getUserByEmail(email);
        if(users.size() <= 0)
            redirect.addFlashAttribute("notFound", true);
        else
            redirect.addFlashAttribute("users", users);
        return "redirect:/admin/manage/ads";
    }

    @PostMapping("/ads/add/{id}")
    public String addUserAds(Model model, @PathVariable("id") Long id){
        User user = userService.getUserById(id);
        user.setHasAds(true);
        Ads ads = new Ads();
        ads.setUser(user);
        userService.saveUser(user);
        adsService.saveAds(ads);
        return "redirect:/admin/manage/ads";
    }

    @PostMapping("/ads/remove/{aid}")
    public String removeUserAds(Model model, @PathVariable("aid") Long aid){
        Ads ads = adsService.getAdsById(aid);
        User user = ads.getUser();
        user.setHasAds(false);
        userService.saveUser(user);
        adsService.deleteAdsById(aid);
        return "redirect:/admin/manage/ads";
    }


}
