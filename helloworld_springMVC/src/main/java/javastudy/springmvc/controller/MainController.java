package javastudy.springmvc.controller;

import javastudy.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    //First method in the application
    //We get here after the app is started. (look on the annotation parameters)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*after on index.jsp's form is confirmed
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">
    we are getting here
    */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user){
        ModelAndView modelAndView = new ModelAndView();

        //name of view
        modelAndView.setViewName("secondPage");

        //write into attribute - userJSP
        modelAndView.addObject("userJSP", user);

        return modelAndView; //go to a view that were discribe before
    }

}
