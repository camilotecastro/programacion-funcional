package finalsection;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Function<String, String> upperCaseName = String::toUpperCase;
        System.out.println(upperCaseName);

        Function<String, String> toUpperCaseName = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name is empty");
            return name.toUpperCase();
        };
        System.out.println(toUpperCaseName.apply("Camilo"));

        BiFunction<String, Integer, String> updateName = (name, age) -> {
            System.out.println(age);
            return name.toUpperCase();
        };
        System.out.println(updateName.apply("Camilo",24));

    }
}
