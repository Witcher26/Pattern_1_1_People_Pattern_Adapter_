package classes;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Неверный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Одно из обязательных полей не установлено");
        }
        Person person = new Person(name, surname);
        person.setAddress(city);
        person.setAge(OptionalInt.of(age));
        return person;
    }
}
