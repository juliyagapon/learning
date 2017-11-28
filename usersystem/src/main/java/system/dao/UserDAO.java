package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import system.dao.interfaces.IUserDao;
import system.dao.reports.UserLoginPassword;
import system.model.User;

import javax.persistence.Query;

import java.util.List;

@Repository
public class UserDAO implements IUserDao{

    private Session session;

    private Transaction transaction;

    public static SessionFactory getSessionFactory(){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        return sessionFactory;
    }

    public Session openSession(){
        session = getSessionFactory().openSession();
        return session;
    }

    public Session openSessionWithTransaction(){
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession(){
        session.close();
    }

    public void closeSessionWithTransaction(){
        transaction.commit();
        session.close();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public List<UserLoginPassword> checkLoginPasswordUser(String login, String password) {
        String query = "select new system.dao.reports.UserLoginPassword(u.login, u.password) " +
                "from User u " +
                "where u.login = :login and u.password = :password";
        Query hibernateQuery = getSession().createQuery(query);
        hibernateQuery.setParameter("login", login);
        hibernateQuery.setParameter("password", password);
        return hibernateQuery.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getSession().createQuery("from User").list();
        return users;
    }

    @Override
    public void saveUser(User user) {
        user.setDateOfUpdate();
        getSession().save(user);
    }

    @Override
    public void deleteUser(User user) {
        getSession().delete(user);
    }

    @Override
    public void updateUser(User user) {
        user.setDateOfUpdate();
        getSession().save(user);
    }
}
