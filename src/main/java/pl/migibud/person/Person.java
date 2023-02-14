package pl.migibud.person;

import java.time.LocalDate;

enum Sex {
    MALE, FEMALE
}

record Person(String pesel, Sex sex, LocalDate dob) {
}
