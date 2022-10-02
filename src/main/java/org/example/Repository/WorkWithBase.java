package org.example.Repository;

import org.example.model.Users;
import org.example.model.UsersAddress;
import org.hibernate.query.Query;
import java.util.List;
import java.util.logging.Logger;

public class WorkWithBase extends SessionBase {

    private static Logger logger = Logger.getLogger("util.WorkWithBase");

    public void selectUserById(int number) {
        try {
            session.beginTransaction();
            Users user = session.get(Users.class, number);
            logger.info("Выбран пользователь с id: " + number);
            System.out.println(user.toString());
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void addingUsers(Users users){
        try {
            session.beginTransaction();
            session.save(users);
            logger.info("Пользователь добавлен в базу данных.");
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void userUpdate(int number, String name){
        try {
            session.beginTransaction();
            Users user = session.get(Users.class, number);
            user.setLastName(name);
            logger.info("Имя пользователя с id: " + number + " изменено.");
            System.out.println(user.toString());
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void deleteUser(int number){
        try {
            session.beginTransaction();
            Users user = session.get(Users.class, number);
            session.delete(user);
            logger.info("Пользователь с id : " + number + " удален.");
            System.out.println(user.toString());
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void selectAllUsers(){
        try {
            session.beginTransaction();
            List<Users> usersList = session.createQuery("FROM Users").getResultList();
            usersList
                    .stream()
                    .forEach(System.out::println);
            logger.info("Показанны все пользователи базы данных.");
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void deleteAllUsers(){
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Users").executeUpdate();
            logger.info("Удаленны все пользователи базы данных.");
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void addingUsersAddress(UsersAddress usersAddress, int number){
        try {
            session.beginTransaction();
            Users users = session.get(Users.class, number);
            users.setUsersAddress(usersAddress);
            logger.info("адресс пользователя добавлены в базу данных.");
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void selectUserHouse(int number){
         try {
            session.beginTransaction();
            Query query = session.createQuery("FROM UsersAddress where house = :paramName");
            query.setParameter("paramName", number);
            List<UsersAddress> users = query.list();
            users
                    .stream()
                    .forEach(System.out::println);
            session.getTransaction().commit();
        } catch (Throwable e){
             session.getTransaction().rollback();
             e.getStackTrace();
         } finally {
             session.close();
             sessionFactory.close();
        }
    }
}
