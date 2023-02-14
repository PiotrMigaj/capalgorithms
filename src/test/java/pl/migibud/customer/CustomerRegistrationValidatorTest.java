package pl.migibud.customer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerRegistrationValidatorTest {

    @Test
    void test() {
        //given
        Customer customer = new Customer(
                "Piotr",
                "pmigaj@gmail.com",
                "+0 669699699",
                LocalDate.of(1992, 7, 24)
        );


        //when
        Boolean result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        //then
        assertThat(result).isTrue();
    }

}