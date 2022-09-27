package org.example.Repository;

import org.example.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class WorkWithBase {
    public void selectUserById(int number){
        Configuration configuration = new Configuration().addAnnotatedClass(Users.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

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
        } catch (Exception e){
            e.getStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void addingUsers(Users users){
        Configuration configuration = new Configuration().addAnnotatedClass(Users.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(users);
            System.out.println("Пользователь добавлен в базу данных.");
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void userUpdate(int number, String name){
        Configuration configuration = new Configuration().addAnnotatedClass(Users.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

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
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void deleteUser(int number){
        Configuration configuration = new Configuration().addAnnotatedClass(Users.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

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
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void selectAllUsers(){
        Configuration configuration = new Configuration().addAnnotatedClass(Users.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Users> usersList = session.createQuery("FROM Users").getResultList();
            System.out.println("Показанны все пользователи базы данных.");
            for(Users users : usersList)
            System.out.println(users);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void deleteAllUsers(){
        Configuration configuration = new Configuration().addAnnotatedClass(Users.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Users").executeUpdate();
            System.out.println("Удаленны все пользователи базы данных.");
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
