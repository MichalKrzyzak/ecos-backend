package com.ecos.dto;

public class PersonalDataDto {
    private String firstName;
    private String lastName;
    private long peselNumber;
    private int phoneNumber;

    public PersonalDataDto() {
    }

    public PersonalDataDto(String firstName, String lastName, long peselNumber, int phoneNumber) {
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
        return "PersonalDataDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
