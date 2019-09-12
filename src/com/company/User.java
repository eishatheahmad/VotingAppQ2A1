package com.company;

abstract class User {
    String name;
    int id;

    public User(String userName, int userId) {
        this.name=userName;
        this.id=userId;
    }

    User() {
        this.name=null;
        this.id=0;
    }

    abstract void displayInfo();
    abstract String getName();
    abstract int getId();

}
