package org.example.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_address")
public class UsersAddress implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private int house;

    public UsersAddress(){}

    public UsersAddress(String city, String street, int house) {
        this.users = users;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "UsersAddress{" +
                "users=" + users +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
