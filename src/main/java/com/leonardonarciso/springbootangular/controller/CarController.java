package com.leonardonarciso.springbootangular.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Collection<Car> listOfCars(){
		return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}

	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") && !car.getName().equals("Triumph Stag")
				&& !car.getName().equals("Ford Pinto") && !car.getName().equals("Yugo GV");
	}
}
