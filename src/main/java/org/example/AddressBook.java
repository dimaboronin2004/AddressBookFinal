package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class AddressBook {

    private final List<Person> list = new ArrayList<>(); //List of people as a base of an address book


    public boolean addPerson(Person person) { //Addition of a new person
        if (!list.contains(person)) {
            list.add(person);
            return true;
        }
        else return false;
    }

    public boolean deletePerson(Person person) { //Removing of a person from a book
        boolean flag = list.contains(person);
        list.remove(person);
        return flag;
    }

    public boolean setAddress(Person person, String street, int house, int flat) { //Setting a new address for a person
        if (list.contains(person)) {
            person.set(street, house, flat);
            return true;
        }
        else {
            return false;
        }
    }

    public String getAddress(Person person) { //Receiving an address of a person
        if (list.contains(person)) return person.get();
        else throw new IllegalArgumentException("No such person in a book");
    }

    public ArrayList<String> findByStreet(String street) { //Finding people living on a particular street
        ArrayList<String> output = new ArrayList<>();
        for (Person person: list) {
            if (person.getStreet().equals(street)) {
                output.add(person.getSurname());
            }
        }
        return output;
    }

    public ArrayList<String> findByHouse(String street, int house) { //Finding people living in a particular house
        ArrayList<String> output = new ArrayList<>();
        for (Person person: list) {
            if (person.getStreet().equals(street) && person.getHouse() == house) {
                output.add(person.getSurname());
            }
        }
        return output;
    }
}

