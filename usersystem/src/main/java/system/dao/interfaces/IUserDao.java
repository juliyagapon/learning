package system.dao.interfaces;

import system.dao.reports.UserLoginPassword;
import system.model.User;

import java.io.Serializable;
import java.util.List;

public interface IUserDao extends Serializable{
    public List<UserLoginPassword> checkLoginPasswordUser(String login, String password);
    public List<User> findAllUsers();
    public void saveUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
}
