package com.learning.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.page-size}")
    private int pageSize;

    @RequestMapping("/")
    public String index() {
        System.out.println("Application Name: " + appName);
        System.out.println("page size: " + pageSize);
        return "index.html";
    }

}