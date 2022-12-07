package com.example.BankingSystem.models.User;

import com.example.BankingSystem.models.User.PlaceType;
import jakarta.persistence.*;

@Embeddable
public class Address {
    private String streetName;
    private String buildingNumber;
    private String floorAndDoor;  //optinal

    @Enumerated(EnumType.STRING)
    private PlaceType placeType;
    private String city;
    private String postalCode;

    public Address() {
    }

    public Address(String streetName, String buildingNumber, String floorAndDoor, PlaceType placeType, String city, String postalCode) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.floorAndDoor = floorAndDoor;
        this.placeType = placeType;
        this.city = city;
        this.postalCode = postalCode;
    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFloorAndDoor() {
        return floorAndDoor;
    }

    public void setFloorAndDoor(String floorAndDoor) {
        this.floorAndDoor = floorAndDoor;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}