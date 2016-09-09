package com.helper.finance.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Iryna_Vasilyeva on 9/11/2015.
 */
@RestController
@RequestMapping("/")
public class MainController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/first/{someInfo}")
    public String first(@PathVariable("someInfo") String info) {


        return null;
    }
}
