package system.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDAO;
import system.dao.reports.UserLoginPassword;
import system.model.User;

import java.util.List;

@Service
public class UserService {

   @Autowired
   private UserDAO userDAO;

    public List<User> getAllUsers(){
        userDAO.openSession();
        List <User> users = userDAO.findAllUsers();
        userDAO.closeSession();
        return users;
    }

    public String checkUserLoginPassword(String login, String password){
        userDAO.openSession();
        List <UserLoginPassword> userLoginPasswords = userDAO.checkLoginPasswordUser(login, password);
        if (!userLoginPasswords.isEmpty()) {
            return "valid";
        }
        return "invalid";
    }

    public void saveNewUserData(User user){
        userDAO.openSessionWithTransaction();
        userDAO.saveUser(user);
        userDAO.closeSessionWithTransaction();
    }

}
