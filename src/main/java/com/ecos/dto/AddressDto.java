package com.ecos.dto;

public class AddressDto {
    private String correspondence_street;
    private String correspondence_house_number;
    private String correspondence_apartment_number;
    private String city;
    private String voivodeship;
    private String zipCode;

    public AddressDto() {
    }

    public AddressDto(String correspondence_street, String correspondence_house_number, String correspondence_apartment_number, String city, String voivodeship, String zipCode) {
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

    public String getCorrespondence_apartment_number() {
        return correspondence_apartment_number;
    }

    public void setCorrespondence_apartment_number(String correspondence_apartment_number) {
        this.correspondence_apartment_number = correspondence_apartment_number;
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

}
