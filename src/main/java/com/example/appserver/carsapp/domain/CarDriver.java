package com.example.appserver.carsapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


// serializable is for passing data 
@Entity
public class CarDriver implements Serializable {

	@Id
    @ManyToOne
    @JoinColumn
    private Car car;

    @Id
    @ManyToOne
    @JoinColumn
    private Driver driver;
    
    boolean isMain; // is main driver
    
    
    
    // c'tor
    public CarDriver() { // empty c'tor is the default c'tor
    	super();
    }
    
    public CarDriver(Car car, boolean isMain) {
        this.car = car;
        this.isMain=isMain;
    }
    

    


    // Getters and Setters
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public void setDriver(Driver driver) {
		this.driver=driver;
	}
	public boolean isMain() {
		return isMain;
	}
	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}


}
