package streams;

import imperative.Main;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("camilo", MALE),
                new Person("andres", MALE),
                new Person("pep", MALE),
                new Person("mellow", MALE),
                new Person("Pepita", FEMALE),
                new Person("Transformer",NO_GENDER)
        );

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

//        people.stream()
//                .map(personStringFunction)
//                .mapToInt(length)
//                //.collect(Collectors.toSet())
//                .forEach(println);

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        boolean containsOnlyFemales = people.stream()
                .anyMatch(personPredicate);

        System.out.println(containsOnlyFemales);


    }
    static class Person{
        private final String name;
        private final Main.Gender gender;

        public Person(String name, Main.Gender gender) {
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
    enum Gender {
        MALE, FEMALE, NO_GENDER
    }
}
