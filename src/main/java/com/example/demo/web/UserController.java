package com.example.demo.web;


        import com.example.demo.model.User;
        import com.example.demo.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.servlet.ModelAndView;

        import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/","/profile"},method = RequestMethod.GET)
    @ResponseBody
    public User profile(ModelAndView modelAndView, Principal principal){
        String userEmail = principal.getName();
        User user = userService.findUserByEmail(userEmail);
        return user;

    }

    @RequestMapping(value = {"/","/profile"},method = RequestMethod.POST)
    @ResponseBody
    public User updateProfile(ModelAndView modelAndView, Principal principal){
        //TODO
        return null;

    }
}
