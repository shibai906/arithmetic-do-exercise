package com.zhao.design.mode.builder;

public interface CreateCar {

    void selectColor() ;
    void selectCarDoor() ;
    void selectTires();
    Car createCar();

}
