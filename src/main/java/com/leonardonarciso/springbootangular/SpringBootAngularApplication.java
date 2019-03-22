package com.leonardonarciso.springbootangular;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leonardonarciso.springbootangular.impl.CarRepository;
import com.leonardonarciso.springbootangular.model.Car;

@SpringBootApplication
public class SpringBootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository rep){
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV")
			.forEach(name -> {
				Car car = new Car();
				car.setName(name);
				rep.save(car);
			});
			rep.findAll().forEach(System.out::println);
		};
	}
}
