package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Product;
import edu.mum.cs.onlinemarketplace.domain.Review;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.service.ProductService;
import edu.mum.cs.onlinemarketplace.service.ReviewService;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SessionAttributes({"username","userId"})
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String getAllProducts(Model model, HttpSession session){
//        session.setAttribute("userId",1L);
        if(!model.containsAttribute("userId")){
            model.addAttribute("productList",productService.getAllProducts());
            System.out.println("products are ==All Products"+productService.getAllProducts().toString());
        }
        else{
            model.addAttribute("productList",productService.findProductByUserId(1L));
            System.out.println("products are ==Some Products");
        }

        model.addAttribute("message","This is unavailable");
        return "home";
    }

    @GetMapping(value = "/addProduct")
    public String getProductForm(@ModelAttribute("newProduct") Product product, Model model){
        model.addAttribute("userId",1L);
//        if(!model.containsAttribute("userId")){
//            model.addAttribute("message","This is currently unavailable");
//            return "errorMsg";
//        }
        model.addAttribute("product",new Product());

        return "addProductForm";
    }

    @PostMapping(value = "/product/",params = "uid")
    public String addProduct(@RequestParam String uid,@Valid @ModelAttribute("newProduct") Product product, BindingResult result, Model model,@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {

//        System.out.println("User Id= "+userId);
        if (result.hasErrors()) {
            System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            model.addAttribute("errors", result.getAllErrors());
            return "addProductForm";
        }else {
            if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File dir = new File("src/main/resources/static/imgages/");
            dir.mkdir();
            File destination = new File(dir,product.getName()+product.getId()+".jpg");
            destination.createNewFile();
            ImageIO.write(src,"JPG",destination);
            product.setProductImage(destination.getName());
        }
            System.out.println("SUUUUUUUUUUUUUUUUUUUUCCCCCCCCCCCCCCESSSSSSSSSS");

            product.setCreateDate(LocalDate.now());
//            System.out.println("seller Id="+product.getSeller().getId());
//            product.getSeller().setId(1L);
            productService.save(product);
            return "redirect:/";
        }
//
    }

    @PostMapping("/product/delete/{pid}")
    public String deleteProduct(@PathVariable Long pid){
         productService.delete(pid);
         return "redirect:/";
    }

    @GetMapping(value = "/product/update/{pid}")
    public String updateProductForm(@PathVariable(value = "pid",required = false) Long pid, @ModelAttribute("updateProduct") Product product,Model model){
        model.addAttribute("product",productService.findById(pid));
        return "updateProductForm";
    }

    @PostMapping("/product/update/{pid}")
    public String updateProduct(Product product, @PathVariable Long pid){
        Product updateProduct = productService.findById(pid);
        updateProduct.setName(product.getName());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
       // updateProduct.setProductImage(product.getProductImage());
        productService.save(updateProduct);
        return "redirect:/";
    }

    @GetMapping("/error")
    public String errorMsg(Model model){
        return "errorMsg";
    }

    @GetMapping("/product/{pid}")
    public String viewProduct(@ModelAttribute("newReview") Review review, @PathVariable("pid")Long id, Model model){

        User user =userService.findUserById(2L);
        Product product = productService.findById(id);

        if(user.getType().equalsIgnoreCase("BUYER")){
            List<User>follow = user.getUserList();
            List<User>followList = follow.stream().filter(u->u.getId()==product.getSeller().getId()).collect(Collectors.toList());
            if(followList.size()==0){
                model.addAttribute("follow",1);
            }
            else {
                model.addAttribute("follow",0);
            }
        }


        model.addAttribute("product",product);
        model.addAttribute("reviews", reviewService.getReviewsByProduct(id));

        return "productview";

    }

    @PostMapping("/product/{pid}/newReview")
    public String addReview(@Valid @ModelAttribute("newReview") Review review, BindingResult result, @PathVariable Long pid, Model model){
        review.setCreateDate(LocalDate.now());
        review.setProduct(productService.findById(pid));
        review.setUser(userService.findUserById(1l));

//        if(result.hasErrors())
//            return "/product/{pid}";
//        else {

            reviewService.addReview(review);
            return "redirect:/product/{pid}";

//        }


    }


}
