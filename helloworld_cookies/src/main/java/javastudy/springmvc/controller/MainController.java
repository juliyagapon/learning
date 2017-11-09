package javastudy.springmvc.controller;

import javastudy.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    //First method in the application
    //We get here after the app is started. (look on the annotation parameters)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(HttpServletResponse response){
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
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user, HttpServletResponse response){

        Cookie cookie = new Cookie("userName", user.getName());
        response.addCookie(cookie);

        cookie = new Cookie("userPassword", user.getPassword());
        response.addCookie(cookie);

        ModelAndView modelAndView = new ModelAndView();

        //name of view
        modelAndView.setViewName("secondPage");
        //write into attribute - userJSP
        modelAndView.addObject("userJSP", user);

        return modelAndView; //go to a view that were discribe before
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++){
            cookies[i].setValue(null);
            response.addCookie(cookies[i]);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
