package com.leonardonarciso.springbootangular.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardonarciso.springbootangular.impl.CarRepository;
import com.leonardonarciso.springbootangular.model.Car;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Car> listOfCars() {
		return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}

	private boolean isCool(Car car) {
		return !car.getName().equalsIgnoreCase("AMC Gremlin") && !car.getName().equalsIgnoreCase("Triumph Stag")
				&& !car.getName().equalsIgnoreCase("Ford Pinto") && !car.getName().equalsIgnoreCase("Yugo GV");
	}
}
