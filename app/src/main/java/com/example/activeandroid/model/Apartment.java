package com.example.activeandroid.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Apartment")
public class Apartment extends Model {
  @Column(name = "location")
  public Location location;
  @Column(name = "completeAddress")
  public String completeAddress;
  @Column(name = "owner")
  public Owner owner;
  @Column(name = "rentValue")
  public int rentValue;

  public String getCompleteAddress() {
    return completeAddress;
  }

  public void setCompleteAddress(String completeAddress) {
    this.completeAddress = completeAddress;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public int getRentValue() {
    return rentValue;
  }

  public void setRentValue(int rentValue) {
    this.rentValue = rentValue;
  }
}
