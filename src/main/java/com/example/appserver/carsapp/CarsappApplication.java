package com.example.appserver.carsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.appserver.carsapp.da.CarRepository;
import com.example.appserver.carsapp.da.DriverRepository;
import com.example.appserver.carsapp.da.OwnerRepository;
import com.example.appserver.carsapp.da.TripRepository;
import com.example.appserver.carsapp.domain.Car;
import com.example.appserver.carsapp.domain.Driver;
import com.example.appserver.carsapp.domain.Owner;
import com.example.appserver.carsapp.domain.Trip;
import com.example.appserver.carsapp.domain.CarDriver;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.appserver"})
public class CarsappApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CarsappApplication.class);
	
	// הגדרנו אובייקט מסוג ממשק שמממש CRUD 
	 @Autowired 	
	 private CarRepository carRepo;
	 
	 @Autowired
	 private OwnerRepository ownerRepo;
	 
	 @Autowired
	 private TripRepository tripRepo;
	 
	 @Autowired
	 private DriverRepository driverRepo;

	public static void main(String[] args) { 
		SpringApplication.run(CarsappApplication.class, args);
		
		logger.info("Hola");
	} 
	
	  @Bean
      CommandLineRunner runner(){
        return args -> {
        	
        	Owner o1 = new Owner("Ether", "Galaxia");
        	Owner o2 = new Owner("Alpha", "Theta");
        	// change object state
        	o2.setFirstname("Reina");	
        	ownerRepo.save(o1); // persist states in db
        	ownerRepo.save(o2);
        	
        	
        	
        	Trip t1 = new Trip("Canada");
        	Trip t2 = new Trip("Australia");
        	// persist states in data base
        	tripRepo.save(t1); 
        	tripRepo.save(t2);
      
        	
        	Set<Trip> set_Trip_1 = new HashSet<Trip>();
        	set_Trip_1.add(t1); set_Trip_1.add(t2);
        	Set<Trip> set_Trip_2 = new HashSet<Trip>();
        	set_Trip_1.add(t1);  
        	
        	
        	Car c1=new Car ("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000,o2,set_Trip_1);
        	carRepo.save(c1);// save command is found in CRUDrepo
        	// other CRUD repository commands are found in slide 72 in SpringBoot slide
        	Car c2=new Car ("Toyota", "Mustang", "Red", "ADF-1121", 2017, 59000,o1, set_Trip_2);
        	carRepo.save(c2);
        	Car c3=new Car ("Mazda", "Mustang", "Red", "ADF-1121", 2017, 59000,o1, set_Trip_1);
        	carRepo.save(c3);
  
        	
        	
//        	Driver d1 = new Driver("X"); driverRepo.save(d1);
//        	driverRepo.save(d1);
//        	Driver d2 = new Driver("Y"); driverRepo.save(d2);
//        	driverRepo.save(d2);
        	
        	
        	
        	Set<CarDriver> set_cars_driver= new HashSet<CarDriver>();
      	  set_cars_driver.add(new CarDriver(c1, true));
      	  set_cars_driver.add(new CarDriver(c2, true));

      	  driverRepo.save(
          		  new Driver("Sara", set_cars_driver)
          		  );	
        
        	
        };
      } 
}
