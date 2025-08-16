package com.springbootbasics.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/")
    public String index(){
        String viewName = getViewName();
        //return "index.html";
        //System.out.println(viewName);
        return viewName;
    }

    private String getViewName(){
        System.out.println("app name:" + appName);
        return "index.html";
    }
}
