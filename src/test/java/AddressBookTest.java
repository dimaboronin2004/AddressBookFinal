import org.example.AddressBook;
import org.example.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddressBookTest {
    Person Sokolov = new Person("Соколов", "ул. Ленина", 20, 44);
    Person Ivanov = new Person("Иванов" , "ул. Дальняя", 2, 50);
    Person Gusev = new Person("Гусев", "пр. Авиастроителей", 69, 32);
    Person Kozlov = new Person("Козлов", "пер. Пушкина", 8, 11);
    Person Krasnov = new Person("Краснов", "пр. Авиастроителей", 50, 99);
    Person Nikolaev = new Person("Николаев", "пр. Авиастроителей", 50, 41);
    @Test
    void addPersonTest() {
        AddressBook testBook = new AddressBook();
        Assertions.assertTrue(testBook.addPerson(Sokolov));
        Assertions.assertTrue(testBook.addPerson(Gusev));
        Assertions.assertFalse(testBook.addPerson(Gusev));
    }

    @Test
    void deletePersonTest() {
        AddressBook testBook = new AddressBook();
        Assertions.assertTrue(testBook.addPerson(Sokolov));
        Assertions.assertTrue(testBook.addPerson(Gusev));
        Assertions.assertTrue(testBook.deletePerson(Gusev));
        Assertions.assertFalse(testBook.deletePerson(Kozlov));
    }

    @Test
    void setAddressTest() {
        AddressBook testBook = new AddressBook();
        Assertions.assertTrue(testBook.addPerson(Sokolov));
        Assertions.assertTrue(testBook.addPerson(Gusev));
        Assertions.assertTrue(testBook.setAddress(Gusev, "ул. Васи Алексеева", 43, 1));
        Assertions.assertFalse(testBook.setAddress(Kozlov, "ул. Культуры", 38, 66));
    }

    @Test
    void getAddressTest() {
        AddressBook testBook = new AddressBook();
        Assertions.assertTrue(testBook.addPerson(Sokolov));
        Assertions.assertTrue(testBook.addPerson(Gusev));
        Assertions.assertEquals("пр. Авиастроителей, 69, 32", testBook.getAddress(Gusev));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testBook.getAddress(Kozlov);
        });
        Assertions.assertEquals("No such person in a book", exception.getMessage());
    }

    @Test
    void findByStreetTest() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Гусев");
        testList.add("Краснов");
        testList.add("Николаев");

        AddressBook testBook = new AddressBook();
        Assertions.assertTrue(testBook.addPerson(Sokolov));
        Assertions.assertTrue(testBook.addPerson(Gusev));
        Assertions.assertTrue(testBook.addPerson(Kozlov));
        Assertions.assertTrue(testBook.addPerson(Krasnov));
        Assertions.assertTrue(testBook.addPerson(Nikolaev));
        Assertions.assertEquals(testList, testBook.findByStreet("пр. Авиастроителей"));
        Assertions.assertEquals(new ArrayList<String>(), testBook.findByStreet("ул. Андреева"));
    }

    @Test
    void findByHouseTest() {
        ArrayList<String> testList1 = new ArrayList<>();
        testList1.add("Краснов");
        testList1.add("Николаев");

        AddressBook testBook = new AddressBook();
        Assertions.assertTrue(testBook.addPerson(Sokolov));
        Assertions.assertTrue(testBook.addPerson(Gusev));
        Assertions.assertTrue(testBook.addPerson(Kozlov));
        Assertions.assertTrue(testBook.addPerson(Krasnov));
        Assertions.assertTrue(testBook.addPerson(Nikolaev));
        Assertions.assertEquals(testList1, testBook.findByHouse("пр. Авиастроителей" ,50));
        Assertions.assertEquals(new ArrayList<String>(), testBook.findByHouse("пр. Северный", 8));
    }
}
