import classes.Person;
import classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        Person mom = new PersonBuilder()
                .setName("Andrey")
                .setSurname("Ivanov")
                .setAddress("Moscow")
                .setAge(40)
                .build();

        Person son = mom.newChildBuilder()
                .setName("Anton")
                .setAge(15)
                .build();

        System.out.println("У " + mom + " есть сын " + son);

        try {
            new PersonBuilder()
                    .setName("Ivan")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setName("Vova")
                    .setSurname("Vladimorov")
                    .setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

