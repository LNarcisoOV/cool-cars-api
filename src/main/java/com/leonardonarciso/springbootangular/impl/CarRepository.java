package com.leonardonarciso.springbootangular.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.leonardonarciso.springbootangular.model.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long>{

}
