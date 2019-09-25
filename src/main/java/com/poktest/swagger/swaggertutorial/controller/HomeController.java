package com.poktest.swagger.swaggertutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    //http://localhost:8080/home/model-view?name=pokAha&fname=Yakuza
    @RequestMapping("/hello")
    public String hello(HttpServletRequest req, HttpServletResponse res, HttpSession session, @RequestParam(required=false) String fname){
        String name = req.getParameter("name");
        session.setAttribute("name",name);
        System.err.println("poktset name : "+name);
        System.err.println("poktset fname : "+fname);
        return "home";
    }
}
