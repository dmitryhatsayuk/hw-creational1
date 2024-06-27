package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }
// тут я не совсем понял зачем этот перегруженный конструктор в задаче указан в коде,
// чтобы при наличии возраста этим конструктором создавать объект?

//    public Person(String name, String surname, int age) {
//
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }

    @Override
    public int hashCode() {
        int prime = 77;
        return prime * Objects.hash(name, age);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0);
        if (hasAddress()) {
            child.setAddress(this.address);
        }
        return child;
    }
}

