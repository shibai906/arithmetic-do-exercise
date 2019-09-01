package com.zhao.design.mode.flyweight;

import java.util.HashMap;
import java.util.Map;

public class AddressFactory {

    private static Map<String, Address> pool = new HashMap<>();
    private static AddressFactory factory = new AddressFactory();

    private AddressFactory() {
        Address classmate, relative;
        classmate = new Classmate();
        relative = new Relative();
        pool.put("C",classmate);
        pool.put("R",relative);
    }

    public static AddressFactory getInstance() {
        return factory;
    }

    public Address getAddress(String type) {
        return pool.get(type);
    }
}
