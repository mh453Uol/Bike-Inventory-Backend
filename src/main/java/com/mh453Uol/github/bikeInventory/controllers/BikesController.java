package com.mh453Uol.github.bikeInventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mh453Uol.github.bikeInventory.models.Bike;
import com.mh453Uol.github.bikeInventory.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping
	public List<Bike> all(){
		return this.bikeRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Bike bike) {
		this.bikeRepository.save(bike);
	}
	
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id){
		return this.bikeRepository.getOne(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@PathVariable("id") long id, @RequestBody Bike bike) {
		Bike editingBike = this.bikeRepository.getOne(id);
		
		if(editingBike == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		
		editingBike.setName(bike.getName());
		editingBike.setContact(bike.isContact());
		editingBike.setEmail(bike.getEmail());
		editingBike.setModel(bike.getModel());
		editingBike.setPhone(bike.getPhone());
		editingBike.setPurchaseDate(bike.getPurchaseDate());
		editingBike.setPurchasePrice(bike.getPurchasePrice());
		editingBike.setSerialNumber(bike.getSerialNumber());
		
		bike = this.bikeRepository.save(editingBike);
		
		return new ResponseEntity<Bike>(bike, HttpStatus.OK);
	}
	
}
