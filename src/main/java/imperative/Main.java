package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("camilo", MALE),
                new Person("andres", MALE),
                new Person("pep", MALE),
                new Person("mellow", MALE),
                new Person("Pepita", FEMALE)
        );
        System.out.println("// Imperative Approach");
        List<Person> females = new ArrayList<>();
        for (Person person: people) {
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female: females) {
            System.out.println(female);
        }
        System.out.println("// Declarative Approach Streams and collections");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                //.collect(Collectors.toList())
                .forEach(System.out::println);
        // Otra opción
        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
    }
    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    public enum Gender {
        MALE, FEMALE, NO_GENDER
    }
}
