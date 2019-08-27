package com.example.appserver.carsapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	
	// primary key 
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;
    
    // mapped by is the foreign key in the side of car
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;


    //c'tor
	public Owner() {}
    public Owner(String firstname, String lastname) {
      super();
      this.firstname = firstname;
      this.lastname = lastname;
    }
    
    
    
    public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	

    public long getOwnerid() {
      return ownerid;
    }
    public void setOwnerid(long ownerid) {
      this.ownerid = ownerid;
    }
    public String getFirstname() {
      return firstname;
    }
    public void setFirstname(String firstname) {
      this.firstname = firstname;
    }
    public String getLastname() {
      return lastname;
    }
    public void setLastname(String lastname) {
      this.lastname = lastname;
    } 

}
