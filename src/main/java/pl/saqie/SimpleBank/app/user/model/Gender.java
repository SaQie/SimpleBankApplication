package pl.saqie.SimpleBank.app.user.model;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("Mężczyzna"),
    FEMALE("Kobieta"),
    OTHER("Inna");

    private String description;

    Gender(String description) {
        this.description = description;
    }

}
