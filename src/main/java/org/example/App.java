package org.example;

import org.example.Repository.WorkWithBase;
import org.example.model.Users;
import org.example.model.UsersAddress;

public class App {
    public static void main( String[] args ) {

        Users users1 = new Users("Ivanov", "Ivan", 33);
        Users users2 = new Users("Sidorov", "Fedor", 23);
        Users users3 = new Users("Kozlov", "Nick", 40);
        Users users4 = new Users("Petrov", "Stepan", 22);

        UsersAddress usersAddress1 = new UsersAddress(users1, "Minsk", "Gorkogo", 12);
        UsersAddress usersAddress2 = new UsersAddress(users2, "Gomel", "Pyshkina", 3);
        UsersAddress usersAddress3 = new UsersAddress(users3, "Brest", "Moskovskaya", 30);
        UsersAddress usersAddress4 = new UsersAddress(users4, "Bereza", "Lybarscogo", 30);

        WorkWithBase workWithBase = new WorkWithBase();
        //workWithBase.selectAllUsers();
        //workWithBase.deleteUser(1);
        //workWithBase.selectUserHouse(30);
        //workWithBase.userUpdate(1, "Vanya");
        //workWithBase.addingUsers(users5);
        //workWithBase.selectUserById(1);
        //workWithBase.addingUsersAddress(usersAddress5, 6);
        //workWithBase.deleteAllUsers();
    }
}
