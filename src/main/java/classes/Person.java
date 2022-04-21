package classes;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return this.city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age.isEmpty()) {
            System.out.println("Возраст не установлен");
        }
        return age;
    }

    public String getAddress() {
        if (city == null)
            return "Адрес не выставлен";
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void setAge(OptionalInt age) {
        this.age = age;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            int ageTmp = age.getAsInt();
            ageTmp++;
            this.age = OptionalInt.of(ageTmp);
            System.out.println("С днём рождения");
        } else
            System.out.println("Возраст не выставлен");
    }

    @Override
    public String toString() {
        return name + " " + surname + ", возраст: " + age.getAsInt() + ", прописка: " + city + " -";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(city)
                .setAge(0);
    }
}
