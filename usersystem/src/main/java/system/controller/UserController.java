package system.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers()
    {
         return userService.getAllUsers();
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkUser(@ModelAttribute("userFromServer") User user){
        return userService.checkUserLoginPassword(user.getLogin(), user.getPassword());
    }

    @RequestMapping(value = "/addnewuser", method = RequestMethod.GET)
    public ModelAndView addNewUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userDataFromServer", new User());
        modelAndView.setViewName("add_new_user");
        return modelAndView;
    }
    @RequestMapping(value = "/saveuserdata", method = RequestMethod.POST)
    public @ResponseBody
    String saveUserData(@ModelAttribute("userDataFromServer") User user){
        userService.saveNewUserData(user);
        return "Data was saved";
    }
}
