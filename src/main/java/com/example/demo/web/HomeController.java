package com.example.demo.web;


import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    private UserService userService;


    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView){
          modelAndView.setViewName("home/home");
          modelAndView.addObject("users",userService.findAllUsers());
            return modelAndView;
    }

    @RequestMapping(value = {"/fragments/footer"}, method = RequestMethod.GET)
    public ModelAndView footer(ModelAndView modelAndView){
        modelAndView.setViewName("fragments/footer");
        return modelAndView;
    }




}
