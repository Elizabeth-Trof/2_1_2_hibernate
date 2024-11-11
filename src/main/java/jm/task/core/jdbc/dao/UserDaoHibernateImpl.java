package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import java.util.ArrayList;
import java.util.List;




public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactory =  Util.getSessionFactory();

    public UserDaoHibernateImpl() {
        }



    @Override
    public void createUsersTable() {

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users (id mediumint not null auto_increment," +
                    " name VARCHAR(50), lastname VARCHAR(50), age tinyint, PRIMARY KEY (id))").executeUpdate();
            transaction.commit();
            System.out.println("Таблица создана");
        } catch (HibernateException e){
            e.printStackTrace();
        if(transaction != null){
            transaction.rollback();
        }}

    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.createNativeQuery("DROP TABLE IF EXISTS Users ");
            transaction.commit();
            System.out.println("Таблица удалена");
        }catch (HibernateException e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }}

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name,lastName,age));
            transaction.commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        }catch (HibernateException e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
    }}

    @Override
    public void removeUserById(long id) {

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
            System.out.println("Пользователь удалена");

        } catch (HibernateException e){

             if(transaction != null){
                 transaction.rollback();
            }
             e.printStackTrace();}

    }

    @Override
    public List<User> getAllUsers() {
            List<User> userList = new ArrayList<>();
            try (Session session = Util.getSessionFactory().openSession()) {
                userList = session.createQuery("from User").getResultList();
            }
            System.out.println(userList);
            return userList;

    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("DELETE FROM mydbtest.users").executeUpdate();
            transaction.commit();
            System.out.println("Таблица очищена");
        } catch (HibernateException e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }

        }

    }}

