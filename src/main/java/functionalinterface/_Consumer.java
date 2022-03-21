package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Represents and operation that accepts a single input argument and returns no result.
public class _Consumer {

    public static void main(String[] args) {
        Customer camilo = new Customer("Camilo","199999");

        // Normal java function
        greetCustomer(camilo);
        greetCustomerV2(camilo,false);

        // Consumer Functional interface
        greetCustomerConsumer.accept(camilo);
        greetCustomerConsumerV2.accept(camilo,false);

    }

    static class Customer {
        private final String customerName;
        private final String customerPhone;

        public Customer(String customerName, String customerPhone) {
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }
    }

    // Functional way
    static void greetCustomer(Customer customer){
        System.out.printf(
                "Hello %s, thanks for registering phone number %s%n",
                customer.customerName, customer.customerPhone
        );
    }

    static void greetCustomerV2(Customer customer, boolean showPhone){
        System.out.println(
                "Hello " + customer.customerName + ", thanks for registering phone number "
                        + (showPhone ? customer.customerPhone : "*************")
        );
    }

    // Functional interface
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.printf(
                    "Hello %s, thanks for registering phone number %s%n",
                    customer.customerName, customer.customerPhone
            );

    // BiConsumer
    static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 = (customer, showPhone) ->
            System.out.println(
              "Hello " + customer.customerName + ", thanks for registering phone number "
                      + (showPhone ? customer.customerPhone : "*************")
            );
}
