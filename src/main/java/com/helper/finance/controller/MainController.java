package com.helper.finance.controller;

import com.helper.finance.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Iryna_Vasilyeva on 9/11/2015.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/first")
    public String first(Model model) {
        String[] arr = {"123"};
        Main.main(arr);
        return "index";
    }
}
