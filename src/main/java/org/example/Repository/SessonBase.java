package org.example.Repository;

import org.example.model.Users;
import org.example.model.UsersAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

abstract class SessionBase {
    Configuration configuration = new Configuration().addAnnotatedClass(Users.class)
            .addAnnotatedClass(UsersAddress.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

}