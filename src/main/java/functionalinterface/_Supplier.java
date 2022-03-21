package functionalinterface;

import java.util.List;
import java.util.function.Supplier;
//This is a functional
// interface and can therefore be used as the assignment target for a lambda expression or method reference.
public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDbConnectionUrlSupplier.get());
        System.out.println(getDbConenectionUrlsSuppiler.get());
    }
    static String getDBConnectionUrl(){
        return "jdbc://localhost:3560/users";
    }

    static Supplier<String> getDbConnectionUrlSupplier = () ->
            "jdbc://localhost:3560/users";

    static Supplier<List<String>> getDbConenectionUrlsSuppiler = () ->
            List.of("jdbc://localhost:3560/customers",
                    "jdbc://localhost:3560/users");

}
