package com.example.activeandroid.repository;

import com.activeandroid.query.Select;
import com.activeandroid.util.SQLiteUtils;
import com.example.activeandroid.model.Apartment;
import com.example.activeandroid.model.Location;
import com.example.activeandroid.model.Owner;

import java.util.List;


public class Repository {
  public void addApartmentWithRent(final int rentValue) {
    Location location = new Location();
    location.name = "Hermes Heritage";
    location.save();

    Owner owner = new Owner();
    owner.name = "Nazneen R";
    owner.save();

    Apartment apartment = new Apartment();
    apartment.location = location;
    apartment.rentValue = rentValue;
    apartment.owner = owner;
    apartment.completeAddress = "Opp. Binaruis Building, Pune-411006 ";

    apartment.save();
  }

  public void updateFirstApartmentInTheList() {
    Apartment apartment = Apartment.load(Apartment.class, 1);
    apartment.rentValue = 8000;
    apartment.save();
  }

  public List<Apartment> fetchApartmentsBasedOnRentValue(int rentValue) {
    return new Select()
        .from(Apartment.class)
        .where("rentValue = ?", rentValue)
        .execute();
  }

  public List<Apartment> fetchApartmentsBasedOnName(String locationName) {
    List<Location> locations = new Select()
        .from(Location.class)
        .where("name = ?", locationName)
        .execute();

    return new Select()
        .from(Apartment.class)
        .where("location = ?", locations.get(0).getId())
        .execute();
  }

  public List<Apartment> executeComplexQuery() {
    return SQLiteUtils.rawQuery(Apartment.class, "SELECT * from Apartment where rentValue between ? and ?",
        new String[]{"7700", "9900"});
  }
}