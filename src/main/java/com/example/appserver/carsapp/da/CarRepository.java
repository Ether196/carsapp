package com.example.appserver.carsapp.da;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.PagingAndSortingRepository;
// import org.springframework.data.repository.CrudRepository;
import com.example.appserver.carsapp.domain.Car;


// the interface of data access. execute CRUD commands by this repo, 
// הדמייה של שורת נתונים
// data access = repository
// CrudRepository is a part of JPA (HIBERNATE),
// PagingAndSortingRepository
// JpaRepository 
// כבר קיים 
// כדי לחבר מסד הנתונים לשרת
public interface CarRepository extends JpaRepository<Car, Long> {
	
	
	  // Fetch cars by brand
	  List<Car> findByBrand(String brand);

	  // Fetch cars by color
	  List<Car> findByColor(String color);

	  // Fetch cars by year
	  List<Car> findByYear(int year);
	  
	  // Fetch cars by register number
	  List<Car> findByRegisterNumber(int registerNumber);
	  
	  // Fetch cars by brand and model
	  List<Car> findByBrandAndModel(String brand, String model);

	  // Fetch cars by brand or color
	  List<Car> findByBrandOrColor(String brand, String color); 
	  
	  // Fetch cars by brand and sort by year
	  List<Car> findByBrandOrderByYearAsc(String brand);
	  
	  
	  
	  // SQL format
	  @Query("select c from Car c where c.brand = ?1")
	  List<Car> findByBrand2(String brand);  
	  @Query("select c from Car c where c.brand like %?1") //?1 in first place in method find this brand
	  List<Car> findByBrandEndsWith(String brand);
	  

	  
	  // native SQL queries
	  @Query(value = "SELECT * FROM CAR WHERE Car.brand = ?1",       nativeQuery = true)
	  List<Car> findByBrand3(String brand);

	  
}
