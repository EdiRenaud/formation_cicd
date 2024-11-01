package com.githubactions.app.controllers;

import com.githubactions.app.models.Car;
import com.githubactions.app.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping("/car")
    public ResponseEntity<Void> addCar(@RequestBody Car carRequest, UriComponentsBuilder ucb)
    {
        Car car = this.service.save(carRequest);
        URI locationOfNewCar = ucb.path("api/car/{id}")
                .buildAndExpand(car.getId())
                .toUri();

        return ResponseEntity.created(locationOfNewCar).build();
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Long id)
    {
        var car = this.service.findById(id);
        return ResponseEntity.ok(car);
    }

}
