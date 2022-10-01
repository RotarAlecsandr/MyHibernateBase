package org.example.Repository;

import org.example.model.Users;
import org.example.model.UsersAddress;
import org.hibernate.query.Query;
import java.util.List;

public class WorkWithBase implements Pdu {

    public void selectUserById(int number) {
        try {
            session.beginTransaction();
            Users user = session.get(Users.class, number);
            System.out.println("Выбран пользователь с id: " + number);
            int age = user.getAge();
            String first = user.getFirstName();
            String last = user.getLastName();

            System.out.print("firstName: " + first);
            System.out.print(", lastName: " + last);
            System.out.println(", age: " + age);
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
            System.out.println("Пользователь добавлен в базу данных.");
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
            System.out.println("Имя пользователя с id: " + number + " изменено.");
            String first = user.getFirstName();
            String last = user.getLastName();
            int age = user.getAge();

            System.out.print("firstName: " + first);
            System.out.print(", lastName: " + last);
            System.out.println(", age: " + age);
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
            System.out.println("Пользователь с id : " + number + " удален.");
            String first = user.getFirstName();
            String last = user.getLastName();
            int age = user.getAge();

            System.out.print(", firstName: " + first);
            System.out.print(", lastName: " + last);
            System.out.println(", age: " + age);
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
            System.out.println("Показанны все пользователи базы данных.");
            usersList
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

    public void deleteAllUsers(){
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Users").executeUpdate();
            System.out.println("Удаленны все пользователи базы данных.");
            session.getTransaction().commit();
        } catch (Throwable e){
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void addingUsersAddress(Users users, UsersAddress usersAddress){
        try {
            session.beginTransaction();
            session.save(users);
            System.out.println("Пользователь и адресс пользователя добавлены в базу данных.");
            users.setUsersAddress(usersAddress);
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
