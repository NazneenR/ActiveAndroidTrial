package com.example.activeandroid.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Owner")
public class Owner extends Model {
  @Column(name = "name")
  public String name;
}
