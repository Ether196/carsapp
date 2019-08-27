package com.example.appserver.carsapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Driver {

	
		  @Id
		  @GeneratedValue(strategy=GenerationType.AUTO)
		  private long driver_id;
		
		  private String name;

	    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
	    private Set<CarDriver> carDrivers;


	    
	    // c'tors
	    public Driver() { // empty c'tor
			super();
	    }
	    public Driver(String name, Set<CarDriver> carDrivers) {
	    	super();
	        this.name = name;
	        for(CarDriver carDriver : carDrivers) 
			 {
			 carDriver.setDriver(this);
			 }
	     this.carDrivers = carDrivers;
	    }
	    
	    
	    
	    
	    // Getters and Setters
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public long getDriver_id() {
			return driver_id;
		}
		public void setDriver_id(long driver_id) {
			this.driver_id = driver_id;
		}
		public Set<CarDriver> getCarDrivers() {
			return carDrivers;
		}
		public Set<CarDriver> getCarsOfDriver() {
			return carDrivers;
		}
		public void setCarsOfDriver(Set<CarDriver> carsOfDriver) {
			this.carDrivers = carsOfDriver;
		}


	
}
