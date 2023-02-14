package pl.migibud.person;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PeselValidatorTest {

    @Test
    void isSexValid() {
        //given
        Person person = new Person(
                "92072413417",
                Sex.MALE,
                LocalDate.of(1992, 7, 24)
        );
        //when
        Boolean apply = PeselValidator.isSexValid().apply(person);

        //then
        System.out.println(apply);
        assertThat(apply).isEqualTo(true);
    }

}