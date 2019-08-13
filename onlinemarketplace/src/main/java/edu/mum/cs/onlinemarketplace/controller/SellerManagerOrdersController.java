package edu.mum.cs.onlinemarketplace.controller;

import com.itextpdf.text.DocumentException;
import edu.mum.cs.onlinemarketplace.domain.Product;
import edu.mum.cs.onlinemarketplace.domain.UserOrder;
import edu.mum.cs.onlinemarketplace.service.OrderService;
import edu.mum.cs.onlinemarketplace.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/seller")
public class SellerManagerOrdersController {

    @Autowired
    OrderService orderService;

    @Autowired
    PDFService pdfService;

    @GetMapping("/orders")
    public String managerOrders(Model model, HttpSession session){
//        Long id = (Long) session.getAttribute("userid");
        Long id = 1L;
        model.addAttribute("orders", orderService.getOrdersBySellerId(id));
        return "sellerManageOrders";
    }

    @PostMapping("/order/change/{id}/{status}")
    public String cancelOrder(@PathVariable("id") Long id,
                              @PathVariable("status") String status, Model model, RedirectAttributes redirect) throws FileNotFoundException, DocumentException {
        UserOrder userOrder = orderService.getOrderById(id);
        if(userOrder.getStatus().equals("waiting")){
            userOrder.setStatus(status);
            orderService.saveOrder(userOrder);
            redirect.addFlashAttribute("result", status);
            List<Product> products = userOrder.getCart().getProductList()
                    .stream()
                    .filter(prod -> prod.getSeller().getId() == userOrder.getSeller().getId())
                    .collect(Collectors.toList());
            pdfService.createPDFFile(userOrder, products);
        }
        return "redirect:/seller/orders";
    }


}
