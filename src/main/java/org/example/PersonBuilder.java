package org.example;

public class PersonBuilder {
    protected int age;
    protected String name;
    protected String surname;
    protected String address;
    protected boolean settedAge;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        settedAge = true;
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (age < 0) {
            throw new IllegalStateException("Указан некорректный возраст!");
        }
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Не указаны обязательные параметры: имя или фамилия!");
        } else {
            Person person = new Person(name, surname);
            if (settedAge) {
                person.age = age;
            }
            if (address != null) {
                person.address = address;
            }
            return person;
        }
    }
}
