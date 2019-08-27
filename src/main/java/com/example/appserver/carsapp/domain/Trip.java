package com.example.appserver.carsapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long trip_id;
	String name;
	
	// we used set because a car can't appear twice in trip
	@ManyToMany(mappedBy = "trips") // trips is the member variables in car class
	private Set<Car> cars;
	
	// C'tors
	public Trip() { // empty c'tor
		super();
	}
	
	public Trip(String name) {
		super();
		this.name = name;
	}
	
	public Set<Car> getCars() {
		return cars;
	}

	

	
	// Getters and Setters
	public long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}


	
	
}
