package com.zhao.design.mode.builder;

public class CarMain {

    public static void main(String[] args) {
        CarDirector director = new CarDirector();
        CreateCar createCar = director.direct(new CreateCarImpl());
    }

}
