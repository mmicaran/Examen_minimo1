package edu.upc.eetac.dsa;

import java.util.LinkedList;

public class User {
    String idUser;
    String name;
    String surname;
    LinkedList<Bike> bicis;

    public User(){
        this.bicis = new LinkedList<>();
    }

    public User(String idUser, String name, String surname) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.bicis = new LinkedList<>();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public LinkedList<Bike> getBicis() {
        return bicis;
    }

    public void setBicis(LinkedList<Bike> bicis) {
        this.bicis = bicis;
    }

    public void addBicis(Bike b){
        this.getBicis().add(b);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bicis=" + bicis +
                '}';
    }
}
