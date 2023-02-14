package pl.migibud.customer;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

@FunctionalInterface
public interface CustomerRegistrationValidator
        extends Function<Customer, Boolean> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.email().contains("@");
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.phoneNumber().startsWith("+0");
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer -> Period.between(customer.dob(), LocalDate.now()).getYears() >= 18;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            boolean result = this.apply(customer);
            return result ? other.apply(customer) : false;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOD_VALID,
        IS_NOT_AN_ADULT
    }


}
