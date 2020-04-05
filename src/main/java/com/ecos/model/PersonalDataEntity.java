package com.ecos.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class PersonalDataEntity {
    @NotNull
    @Size(max = 25)
    private String firstName;
    @NotNull
    @Size(max = 25)
    private String lastName;
    @NotNull
    @Size(max = 11)
    private long peselNumber;

    public PersonalDataEntity() {
    }

    public PersonalDataEntity(String firstName, String lastName, long peselNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(long peselNumber) {
        this.peselNumber = peselNumber;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                '}';
    }
}
