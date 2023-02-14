package pl.migibud.customer;

import java.time.LocalDate;

import static pl.migibud.customer.CustomerRegistrationValidator.isEmailValid;
import static pl.migibud.customer.CustomerRegistrationValidator.isPhoneNumberValid;

class App {
    public static void main(String[] args) {


        Customer customer = new Customer(
                "Piotr",
                "pmigaj@gmail.com",
                "+48 669678478",
                LocalDate.of(1992, 7, 24)
        );

        System.out.println(customer);

        var result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(customer1 -> {
                    System.out.println("Hello");
                    return false;
                })
                .apply(customer);

        System.out.println(result);

        System.out.println(result);

        Boolean apply = CustomerRegistrationValidator.isAnAdult().apply(customer);
        System.out.println(apply);


        System.out.println("******************************");
        CustomerRegistrationValidator and = isEmailValid().and(isPhoneNumberValid());

    }
}

