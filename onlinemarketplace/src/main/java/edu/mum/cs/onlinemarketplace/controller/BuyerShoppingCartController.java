package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.*;
import edu.mum.cs.onlinemarketplace.service.CartService;
import edu.mum.cs.onlinemarketplace.service.OrderService;
import edu.mum.cs.onlinemarketplace.service.ProductService;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/buyer")
public class BuyerShoppingCartController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping("/cart")
    public String shoppingCart(Model model, HttpSession session){
        //Long id = (Long) session.getAttribute("userid");
        Long id = 2L;
        User user = userService.getUserById(id);
        CreditCard creditCard = user.getCreditCard();
        Cart cart = user.getCart();
        if(cart == null){
//            cart = cartService.newCart();
//            user.setCart(cart);
            Long cartId = 1L;
            user.setCart(cartService.getCartById(cartId));
            cart = user.getCart();
        }
//        user.setCart(cartService.getCartByBuyerId(user.getId()));
//        Cart cart = cartService.getCartByBuyerId(user.getId());
        cart.calculateTotalPrice();
        model.addAttribute("cart", cart);
        model.addAttribute("user", user);
        model.addAttribute("creditCard", creditCard);
        return "shoppingCart";
    }

    @PostMapping("/cart/remove/{id}/{pid}")
    public String removeProduct(@PathVariable("id") Long id,
                                @PathVariable("pid") Long pid, Model model, RedirectAttributes redirect){
        Cart cart = cartService.getCartById(id);
        System.out.println(cart.getProductList());
        List<Product> products = cart.getProductList()
                                        .stream()
                                        .filter(pd -> pd.getId() != pid)
                                        .collect(Collectors.toList());
        System.out.println(products);
        cart.setProductList(products);
        cart.calculateTotalPrice();
        cartService.saveCart(cart);
        redirect.addFlashAttribute("resultRemove", true);
        return "redirect:/buyer/cart";
    }

    @PostMapping("/cart/setorder/{cid}")
    public String setOrder(@PathVariable("cid") Long cid, HttpSession session, RedirectAttributes redirect){

        //Long id = (Long) session.getAttribute("userid");
        Long id = 2L;
        User user = userService.getUserById(id);

        Cart cart = cartService.getCartById(cid);

        HashMap<Long, List<Product>> mapProducts = new HashMap<>();
        cart.getProductList().stream().map(prod -> prod.getSeller()).distinct().forEach(seller ->{
            List<Product> prodList = new ArrayList<>();
            cart.getProductList().stream()
                    .filter(prod -> prod.getSeller().getId() == seller.getId())
                    .forEach(prod -> prodList.add(prod));
            mapProducts.put(seller.getId(), prodList);
        });

        for (Map.Entry me : mapProducts.entrySet()) {
            List<Product> pds= (List<Product>) me.getValue();
            UserOrder order = new UserOrder();
            order.setStatus("waiting");
            order.setCart(cart);
            order.setTotal(pds.stream().mapToDouble(p -> p.getPrice()).sum());
            order.setCreateDate(LocalDate.now());
            order.setSeller(userService.getUserById((Long) me.getKey()));
            order.setBuyer(user);
            orderService.saveOrder(order);
        }

        cart.setActive(false);
        cartService.saveCart(cart);
        Cart newCart = cartService.newCart();

        user.setCart(newCart);
        System.out.println(newCart);
        userService.saveUser(user);

        redirect.addFlashAttribute("result", true);

        return "redirect:/buyer/cart";
    }

}
