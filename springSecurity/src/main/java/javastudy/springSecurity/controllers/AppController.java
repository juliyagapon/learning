package javastudy.springSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @RequestMapping(value = {"/", "/helloworld"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring security tutorial");
        modelAndView.addObject("message", "Welcome page");
        modelAndView.setViewName("helloworld");
        return modelAndView;
    }

    @RequestMapping(value = "/protected**", method = {RequestMethod.GET})
    public ModelAndView protectedPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring security tutorial");
        modelAndView.addObject("message", "this is protected page - only for admin users");
        modelAndView.setViewName("protected");
        return modelAndView;
    }

    @RequestMapping(value = "/confidential**", method = {RequestMethod.GET})
    public ModelAndView adminPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring security tutorial");
        modelAndView.addObject("message", "this is admin page - only super admin user");
        modelAndView.setViewName("protected");
        return modelAndView;
    }
}
