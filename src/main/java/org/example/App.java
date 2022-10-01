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
        Users users5 = new Users("Rotar", "Sashs", 32);

        UsersAddress usersAddress1 = new UsersAddress("Minsk", "Gorkogo", 12);
        UsersAddress usersAddress2 = new UsersAddress("Gomel", "Pyshkina", 3);
        UsersAddress usersAddress3 = new UsersAddress("Brest", "Moskovskaya", 30);
        UsersAddress usersAddress4 = new UsersAddress("Bereza", "Lybarscogo", 30);
        UsersAddress usersAddress5 = new UsersAddress("Bereza", "Lenina", 33);

        WorkWithBase workWithBase = new WorkWithBase();
        //workWithBase.selectUserById(10);
        //workWithBase.addingUsers(users1);
        //workWithBase.userUpdate(15, "Stepan");
        //workWithBase.deleteUser(15);
        //workWithBase.selectAllUsers();
        //workWithBase.deleteAllUsers();
        //workWithBase.addingUsersAddress(users1, usersAddress1);
        //workWithBase.selectUserHouse(30);
    }
}
