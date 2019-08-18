package com.zhao.design.mode.builder;

public class CarDirector {

    public CreateCar direct(CreateCar createCar) {
        createCar.selectCarDoor();
        createCar.selectColor();
        createCar.selectTires();
        return createCar;
    }

}
