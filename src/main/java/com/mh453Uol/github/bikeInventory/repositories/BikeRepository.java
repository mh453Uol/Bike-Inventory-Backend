package com.mh453Uol.github.bikeInventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mh453Uol.github.bikeInventory.models.Bike;

//JpaRespository provides methods such as getById etc
public interface BikeRepository extends JpaRepository<Bike,Long>{

}
