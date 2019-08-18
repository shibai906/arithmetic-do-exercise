package com.zhao.design.mode.prototype;


/**
 *  @program: DesignPatterns
 *  @desription: 打印矩形
 *  @author: zhaohuan
 *  @create: 2019-8-18 18:27
 */
public class Rectangle implements Product{

    private char mark = '*';

    public Rectangle(char mark) {
        this.mark = mark;
    }

    public Rectangle() {

    }


    @Override
    public void use(int len) {
        for(int i = 0 ; i < len ; i ++) {
            if (i == 0 || i == len -1) {
                for(int k = 0 ; k < len ; k ++) {
                    System.out.print(mark);
                }
            } else {
                System.out.print("*");
                for(int j = 0 ; j < len - 2 ; j ++) {
                    System.out.print(' ');
                }
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
