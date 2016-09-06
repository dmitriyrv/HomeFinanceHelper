package com.helper.finance.controller;

import com.helper.finance.Main;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Date;

/**
 * Created by Iryna_Vasilyeva on 9/11/2015.
 */
@Controller
public class MainController {


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String root(Model model) {

        model.addAttribute("currentTime", (new Date()).toString());

        return "index";
    }
}
