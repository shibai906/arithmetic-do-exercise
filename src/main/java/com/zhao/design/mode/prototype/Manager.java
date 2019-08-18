package com.zhao.design.mode.prototype;

import java.util.HashMap;

/**
 *  @program: DesignPatterns
 *  @desription: 产生具体的类，维护多重对象
 *  @author: zhaohuan
 *  @create: 2019-8-18 18:23
 */
public class Manager {

    private HashMap<String,Product> warehouse = new HashMap<>();

    public void registers(String name,Product product) {
        warehouse.put(name,product);
    }
    public Product createObj(String name) {
        Product product = warehouse.get(name);
        return product.createClone();
    }


}
