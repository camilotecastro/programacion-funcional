package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer
                (
                        "Camilo",
                        "Castro@gmail.com",
                        "571056221691",
                        LocalDate.of(2006,6,7)
                );
//        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
//        customerValidatorService.isValid(customer);
//        System.out.println(new CustomerValidatorService().isValid(customer));

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);
        if (result != SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }
}
