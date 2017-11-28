import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import system.dao.UserDAO;
import system.model.User;
import system.service.UserService;

public class testDao {
    public static void main(String [] args)
    {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*User user = new User();
        user.setDateOfUpdate();
        user.setFirstName("Katty");
        user.setSecondName("Malco");
        user.setEmail("katty.malco@email.com");
        user.setLogin("katty.malco");
        user.setPassword("12345");*/

        /*UserDAO userDAO = new UserDAO();
        userDAO.saveUser(user, session);*/



        UserService userService = new UserService();
        userService.getAllUsers();

        transaction.commit();
        session.close();
        sessionFactory.close();

    }}
