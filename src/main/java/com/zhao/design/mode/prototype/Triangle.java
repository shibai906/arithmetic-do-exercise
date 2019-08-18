package com.zhao.design.mode.prototype;

/**
 *  @program: DesignPatterns
 *  @desription: 打印三角形
 *  @author: zhaohuan
 *  @create: 2019-8-18 18:23
 */
public class Triangle implements Product{
    @Override
    public void use(int len) {
        for(int i = 0 ; i < len ; i ++) {
            for(int j = i ; j < len ; j ++) {
                System.out.print(' ');
            }
            for(int j = 0 ; j < 2*i + 1; j ++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }

    @Override
    public Product createClone() {
        Product product = null;
        try {
            product = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
