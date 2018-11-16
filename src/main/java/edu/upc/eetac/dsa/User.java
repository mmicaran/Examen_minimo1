package edu.upc.eetac.dsa;

public class User {
    String idUser;
    String name;
    String surname;

    public User(){

    }

    public User(String idUser, String name, String surname) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
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

    @Override
    public String toString() {
        return "User[" +
                "idUser='" + idUser + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ']';
    }
}
