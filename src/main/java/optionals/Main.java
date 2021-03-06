package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<IllegalArgumentException> exception = ()
                -> new IllegalArgumentException("Exception");

        Object value = Optional.ofNullable("null")
                        .orElseThrow(exception);

        System.out.println(value);

        Optional.ofNullable("Camilox545@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to: " + email),
                        () -> {
                            System.out.println("Cannot send email");
                        }
                );
    }
}
