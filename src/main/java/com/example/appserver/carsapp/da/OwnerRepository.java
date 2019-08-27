package com.example.appserver.carsapp.da;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appserver.carsapp.domain.Owner;
 
// data access for owner
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
