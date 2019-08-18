package com.zhao.design.mode.builder;

public class CreateCarImpl implements CreateCar {

    Car car ;

    public CreateCarImpl() {
        car = new Car();
    }

    @Override
    public void selectColor() {
        car.setColor("颜色");
    }

    @Override
    public void selectCarDoor() {
        car.setCarDoor(2);
    }

    @Override
    public void selectTires() {
        car.setTires(4);
    }

    @Override
    public Car createCar() {
        return car;
    }
}
