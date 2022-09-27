package org.example;

import org.example.Repository.WorkWithBase;
import org.example.model.Users;

public class App {
    public static void main( String[] args ) {
        Users users1 = new Users("Ivanov", "Ivan", 33);
        Users users2 = new Users("Sidorov", "Fedor", 23);
        Users users3 = new Users("Kozlov", "Nick", 40);
        Users users4 = new Users("Petrov", "Stepan", 22);
        WorkWithBase workWithBase = new WorkWithBase();
        workWithBase.selectUserById(1);
        //workWithBase.userUpdate(2, "Love");
        //workWithBase.deleteUser(2);
        //workWithBase.selectAllUsers();
        //workWithBase.deleteAllUsers();
        //workWithBase.addingUsers();


        //workWithBase.addingUsers(users1);
        //workWithBase.addingUsers(users2);
        //workWithBase.addingUsers(users3);
        //workWithBase.addingUsers(users4);
    }
}
