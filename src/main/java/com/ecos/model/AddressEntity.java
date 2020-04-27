package com.ecos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class AddressEntity {
    @Size(max = 100)
    @Column(nullable = false)
    private String correspondence_street;
    @Size(max = 100)
    @Column(nullable = false)
    private String correspondence_house_number;
    @Size(max = 100)
    private String correspondence_apartment_number;
    @Size(max = 100)
    @Column(nullable = false)
    private String city;
    @Size(max = 100)
    @Column(nullable = false)
    private String voivodeship;
    @Size(max = 7)
    @Column(nullable = false)
    private String zipCode;

    public AddressEntity() {
    }

    public AddressEntity(String correspondence_street, String correspondence_house_number, String correspondence_apartment_number, String city, String voivodeship, String zipCode) {
        this.correspondence_street = correspondence_street;
        this.correspondence_house_number = correspondence_house_number;
        this.correspondence_apartment_number = correspondence_apartment_number;
        this.city = city;
        this.voivodeship = voivodeship;
        this.zipCode = zipCode;
    }

    public String getCorrespondence_street() {
        return correspondence_street;
    }

    public void setCorrespondence_street(String correspondence_street) {
        this.correspondence_street = correspondence_street;
    }

    public String getCorrespondence_house_number() {
        return correspondence_house_number;
    }

    public void setCorrespondence_house_number(String correspondence_house_number) {
        this.correspondence_house_number = correspondence_house_number;
    }

    public String getAddressLine3() {
        return correspondence_apartment_number;
    }

    public void setAddressLine3(String addressLine3) {
        this.correspondence_apartment_number = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + correspondence_street + '\'' +
                ", addressLine2='" + correspondence_house_number + '\'' +
                ", addressLine3='" + correspondence_apartment_number + '\'' +
                ", city='" + city + '\'' +
                ", voivodeship='" + voivodeship + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
