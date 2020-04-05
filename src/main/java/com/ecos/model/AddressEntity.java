package com.ecos.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class AddressEntity {
    @NotNull
    @Size(max = 100)
    private String addressLine1;
    @NotNull
    @Size(max = 100)
    private String addressLine2;
    @Size(max = 100)
    private String addressLine3;
    @NotNull
    @Size(max = 100)
    private String city;
    @NotNull
    @Size(max = 100)
    private String voivodeship;
    @NotNull
    @Size(max = 7)
    private String zipCode;

    public AddressEntity() {
    }

    public AddressEntity(String addressLine1, String addressLine2, String addressLine3, String city, String voivodeship, String zipCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.voivodeship = voivodeship;
        this.zipCode = zipCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
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
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", city='" + city + '\'' +
                ", voivodeship='" + voivodeship + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
