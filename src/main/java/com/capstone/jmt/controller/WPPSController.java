package com.capstone.jmt.controller;

import com.capstone.jmt.data.LoginUser;
import com.capstone.jmt.data.Material;
import com.capstone.jmt.data.ShopLogin;
import com.capstone.jmt.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by macbookpro on 11/2/17.
 */
@Controller
@RequestMapping(value = "/")
@SessionAttributes("sessionUser")
public class WPPSController {

    @Autowired
    private ShopService shopService;

    private int increment = 0;


    @ModelAttribute("sessionUser")
    public LoginUser loginCurrentUser() {
        return new LoginUser();
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginCurrent(@RequestParam(value = "error", required = false) String error,
                               Model model) {
        if (null != error) {
            if (error.equals("1"))
                model.addAttribute("param.error", true);
            else if (error.equals("2"))
                model.addAttribute("param.logout", true);
        }
        model.addAttribute("user", new LoginUser());


        return "login";
    }


    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(LoginUser shop, Model model) {

        System.out.println("SHOP EMAIL: " + shop.getEmail());
        LoginUser user = shopService.validateUser(shop);


        if (null != user) {
            model.addAttribute("sessionUser", user);
            System.out.println("tama");
            return "redirect:/dashboard/";
        } else {
            System.out.println("MALI");
            return "redirect:/login/?error=" + "1";
        }
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(@ModelAttribute("sessionUser") LoginUser user, Model model) {
        System.out.println("USER EMAIL: " + user.getEmail());
        if (user.getEmail() == null)
         return "redirect:/login";

        model.addAttribute("email", user.getEmail());

        return "dashboard";
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String showRequest(Model model) {

        List<LoginUser> allUsers =  shopService.getAllUsers();
        //Validation
        if(null == allUsers)
            return "redirect:/login";
        model.addAttribute("users", allUsers);
        return "request";
    }

    @RequestMapping(value = "/approval", method = RequestMethod.GET)
    public String showApproval() {

        return "approval";
    }

    @RequestMapping(value = "/procure", method = RequestMethod.GET)
    public String showProcure() {

        return "procure";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String showReceive() {

        return "receive";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String showManage(Model model) {


        model.addAttribute("materials", shopService.getAllMaterials());
        return "manage";
    }

    @RequestMapping(value = "/addMaterial", method = RequestMethod.GET)
    public String showAddMaterial(Model model){

        model.addAttribute("newMaterial", new Material());
        return "addMaterial";
    }

    @RequestMapping(value = "/addNewMaterial", method = RequestMethod.POST)
    public String addMaterial(@Valid Material material, Model model){



        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String showReport() {

        return "report";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String showSettings() {

        return "settings";
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.GET)
    public String showSupplier() {

        return "supplier";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String showAdduser(@Valid LoginUser loginUser, Model model) {

        //Setting value to USER
        model.addAttribute("newUser", new LoginUser());
        model.addAttribute("typeOfUSer", shopService.getRefUsers());
        return "adduser";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public String addNewUser(@Valid LoginUser loginUser, BindingResult bindingResult, Model model){

        //Trying to save a New USER

        shopService.addUser(loginUser);
        return "redirect:/dashboard/";
    }

    @RequestMapping(value = "/budget", method = RequestMethod.GET)
    public String showBudget() {

        return "budget";
    }
    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String showSample(){

        return "sample";
    }
}
