package com.zhao.design.mode.prototype;

public class Client {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Triangle triangle = new Triangle();
        triangle.use(7);
        manager.registers("三角形", triangle);
        Rectangle rectangle = new Rectangle();
        rectangle.use(7);
        manager.registers("矩形",rectangle);
        System.out.println(triangle);
        System.out.println(manager.createObj("三角形"));
        System.out.println(rectangle);
        System.out.println(manager.createObj("矩形"));
    }

}
