package pl.migibud.person;

import java.util.function.Function;

public interface PeselValidator extends Function<Person, Boolean> {

    static PeselValidator isSexValid() {
        return person -> {
            switch (person.sex()) {
                case MALE:
                    return person.pesel().charAt(person.pesel().length() - 1) % 2 != 0;
                case FEMALE:
                    return person.pesel().charAt(person.pesel().length() - 1) % 2 == 0;
                default:
                    throw new IllegalArgumentException(String.format("Error occured for the given parameter: %s", person.sex()));
            }
        };
    }
}
