package pl.migibud.customer;

import java.time.LocalDate;

record Customer(String name, String email, String phoneNumber, LocalDate dob) {
}
