package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

// Represents a predicate boolean-valued function of one argument.
public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("573104512032"));
        System.out.println(isPhoneNumberValid("533104512032"));
        System.out.println(isPhoneNumberValid("5731045120321"));
        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("573104512032"));
        System.out.println(isPhoneNumberValidPredicate.test("533104512032"));
        System.out.println(isPhoneNumberValidPredicate.test("5731045120321"));
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("57300000000")
        );
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("570000000000")
        );
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3Predicate).test("570000000000")
        );
    }
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("57") && phoneNumber.length() == 12;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("57") && phoneNumber.length() == 12;

    static Predicate<String> containsNumber3Predicate = phoneNumber ->
            phoneNumber.contains("3");

    // static BiPredicate
}
