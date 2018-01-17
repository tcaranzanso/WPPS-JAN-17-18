package com.capstone.jmt.controller;

import com.capstone.jmt.data.*;
import com.capstone.jmt.service.OrderService;
import com.capstone.jmt.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Jabito on 24/02/2017.
 */
@Controller
@SessionAttributes("shopUser")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private OrderService orderService;

    /*
    List of all GET Requests
     */
    @ModelAttribute("shopUser")
    public ShopLogin getShopUser() {
        return new ShopLogin();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginShopUser(@RequestParam(value = "error", required = false) String error, HttpServletRequest request,
//                                Model model) {
//
//
//        return "login";
//    }

//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public String showDashboard(@ModelAttribute("shopUser") ShopLogin shopUser, Model model) {
//        if (shopUser.getId() == null)
//            return "redirect:/login";
//        Double sales = shopService.getTotalSalesToday(shopUser.getStaffOf());
//        Integer saleCount = shopService.getSalesCount(shopUser.getStaffOf());
//        Double total = 0.0;
//        List<LastSevenDays> orders = shopService.getLastSevenDays(shopUser.getStaffOf());
//        for (LastSevenDays lastSevenDays : orders) {
//            total+= lastSevenDays.getSales();
//        }
//        model.addAttribute("orders", orders);
//        model.addAttribute("total", "P " + String.valueOf(total));
//        model.addAttribute("totalSales", "P " + sales==null? "0.00": String.valueOf(sales));
//        model.addAttribute("inventoryCount", String.valueOf(shopService.getInventoryCount(shopUser.getStaffOf())));
//        model.addAttribute("saleCount", saleCount==null? "0": saleCount);
//        model.addAttribute("rating", shopService.getShopRating(shopUser.getStaffOf()));
//        model.addAttribute("username  ", shopUser.getUsername());

//        return "dashboard";
//    }

//    @RequestMapping(value = "/rating", method = RequestMethod.GET)
//    public String shopRating(@ModelAttribute("shopUser") ShopLogin shopUser, Model model) {
////        if (shopUser.getId() == null)
////            return "redirect:/login";
////
////        model.addAttribute("username", shopUser.getUsername());
////
////        return "rating";
////    }
////
////    @RequestMapping(value = "/main", method = RequestMethod.GET)
////    public String loginShopUser3(Model model) {
////
////
//        return "main";
//    }
//
//    @RequestMapping(value = "/sales", method = RequestMethod.GET)
//    public String showSales(@ModelAttribute("shopUser") ShopLogin shopUser, Model model) {
//        if (shopUser.getId() == null)
//            return "redirect:/login";
//
//        List<OrderInfo> orders = orderService.getOrdersByShopId(shopUser.getStaffOf());
//        model.addAttribute("orders", orders);
//        model.addAttribute("username", shopUser.getUsername());
//        Double sales = 0.0;
//        for(int x=0; x<orders.size(); x++){
//            if(null!=orders.get(x).getTotalCost())
//                    sales += orders.get(x).getTotalCost();
//        }
//
//        model.addAttribute("totalSales", "P " + sales.toString());

//        return "sales";
//    }
////
//    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
//    public String showTransactions(@ModelAttribute("shopUser") ShopLogin shopUser, Model model) {
////        if (shopUser.getId() == null)
////            return "redirect:/login";
////
//        return "transactions";
//    }
//
//    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
//    public String shopInventory(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
//        if (shopUser.getId() == null)
//            return "redirect:/login";
//
//
//        model.addAttribute("shop1", new ShopSalesInformation());
//        model.addAttribute("shop2", new ShopSalesInformation());
//        model.addAttribute("water", new ShopSalesInformation());
//        model.addAttribute("username", shopUser.getUsername());
//        model.addAttribute("inventory", shopService.getShopSalesInformationById(shopUser.getStaffOf()));
//
//        return "inventory";
//    }

//    @RequestMapping(value = "/bottlesales", method = RequestMethod.GET)
//    public String showBottleSales(@ModelAttribute("shopUser") ShopLogin shopUser, Model model) {
//        if (shopUser.getId() == null)
//            return "redirect:/login";
//
//        model.addAttribute("username", shopUser.getUsername());
//        model.addAttribute("bottleSalesRecord", orderService.getBottleSales());
//
//        return "bottlesales";
//    }
//
//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public String shopProfile(@ModelAttribute("shopUser") ShopLogin shopUser, Model model) {
//        if (shopUser.getId() == null)
//            return "redirect:/login";
//
//        model.addAttribute("prices", new ShopSalesInformation());
//        model.addAttribute("shop", shopService.getShopInfoById(shopUser.getStaffOf()));
//        model.addAttribute("water", shopService.getShopSalesInformationById(shopUser.getStaffOf()));
//        model.addAttribute("username", shopUser.getUsername());
//
//        return "profile";
////    }

    /*
    List of all POST Requests
     */
//    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
//    public String loginUser(ShopLogin shop, Model model) {
//        ShopLogin user = shopService.validateUser(shop);
//        if (null != user) {
//            model.addAttribute("shopUser", user);
//            return "redirect:/dashboard/";
//        } else {
//            return "redirect:/login/?error=" + "1";
//        }
//    }
//    }

//    @RequestMapping(value = "/logout", method = RequestMethod.POST)
//    public String logOutUser(@ModelAttribute("shopUser") ShopLogin shopUser, HttpServletRequest request, SessionStatus session) {
//        session.setComplete();
//
//        return "login";
//    }

//    @RequestMapping(value = "/updateInventory1", method = RequestMethod.POST)
//    public String updateInventory1(@ModelAttribute("shopUser") ShopLogin shopUser, ShopSalesInformation shop, Model model){
//
//        shopService.updateRoundStock(shopUser.getId(), shopUser.getStaffOf(), shop.getRoundStock());
//        return "redirect:/inventory";
//    }
//
//    @RequestMapping(value = "/updateInventory2", method = RequestMethod.POST)
//    public String updateInventory2(@ModelAttribute("shopUser") ShopLogin shopUser, ShopSalesInformation shop, Model model){
//
//        shopService.updateSlimStock(shopUser.getId(), shopUser.getStaffOf(), shop.getSlimStock());
//        return "redirect:/inventory";
//    }
//
//    @RequestMapping(value = "/updatePrices", method = RequestMethod.POST)
//    public String updatePrices(@ModelAttribute("shopUser") ShopLogin shopUser, ShopSalesInformation water, Model model){
//
//        shopService.updatePrices(shopUser.getUsername(), shopUser.getStaffOf(), water);
//        return "redirect:/inventory";
//    }
//
//    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
//    public String updateProfile(@ModelAttribute("shopUser") ShopLogin shopUser, ShopInfo shop, Model model){
//
//        shopService.updateProfile(shop, shopUser.getId());
//        return "redirect:/profile";
//    }
}
