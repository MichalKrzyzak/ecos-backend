package com.ecos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class PersonalDataEntity {
    @Size(max = 25)
    @Column(nullable = false)
    private String firstName;
    @Size(max = 25)
    @Column(nullable = false)
    private String lastName;
    @Size(max = 11)
    @Column(nullable = false)
    private long peselNumber;
    @Size(max = 9)
    @Column(nullable = false)
    private int phoneNumber;

    public PersonalDataEntity() {
    }

    public PersonalDataEntity(@Size(max = 25) String firstName, @Size(max = 25) String lastName, @Size(max = 11) long peselNumber, @Size(max = 9) int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.phoneNumber = phoneNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonalDataEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
