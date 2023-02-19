package org.example;

public final class Person {
    private final String surname; //Characteristics of a person important for address book
    private String street;
    private int house;
    private int flat;

    public Person(String surname, String street, int house, int flat) { //Constructor of class
        this.surname = surname;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String get() { //Receiving an address of a concrete person
        return "" + this.street + ", " + this.house + ", " + this.flat;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouse() {
        return this.house;
    }

    public int getFlat() {
        return this.flat;
    }

    public void set(String street, int house, int flat) { //Setting new address
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setFlat(int flat){
        this.flat = flat;
    }
}
