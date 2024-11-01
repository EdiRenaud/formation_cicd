package com.githubactions.app.services;

import com.githubactions.app.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public Car save(Car carRequest)
    {
        int nombreAleatoire = 1 + (int)(Math.random() * ((1000 - 1) + 1));

        var car = Car.builder()
            .id((long)nombreAleatoire)
            .couleur(carRequest.getCouleur())
            .marque(carRequest.getMarque())
            .modele(carRequest.getModele())
            .numero_serie(carRequest.getNumero_serie())
            .build();

        this.cars.add(car);

        return car;
    }


    public Car findById(Long id) throws IllegalArgumentException
    {
        var data =  this.cars.stream().filter(car -> car.getId().equals(id)).findFirst();
        if (data.isEmpty())
            throw new IllegalArgumentException("No result found !");

        return data.get();
    }

    public List<Car> getCars()
    {
        return this.cars;
    }
}
