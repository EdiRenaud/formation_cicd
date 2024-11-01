package com.githubactions.app.services;

import com.githubactions.app.models.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {

    @Autowired
    public CarService service;


    @Test
    public void save()
    {
        //Arrange
        Car car1 = new Car(null,"123456","Peugeot", "301", "Gris");
        Car car2 = new Car(null,"7891011","Nissan", "Qashqai", "Bleu");

        //Act
        this.service.save(car1);
        this.service.save(car2);

        //Assert
        Assertions.assertEquals(2, this.service.getCars().size());
    }


    @Test
    public void findById()
    {
        var exception = assertThrows(IllegalArgumentException.class, () -> this.service.findById(2L));
        assertEquals("No result found !", exception.getMessage());

        var car = Car.builder().id(2L).numero_serie("123456").marque("Mercedes").modele("CLA").couleur("Rouge").build();
        assertEquals("123456",car.getNumero_serie());
    }
}