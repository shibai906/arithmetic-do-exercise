package com.zhao.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CarveUpRedPacket {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            List<Integer> moneys = math(1000, 6);
            long num = 0 ;
            if (moneys != null) {
                for (int bigDecimal : moneys) {
                    num += bigDecimal;
                    System.out.print(bigDecimal + "元    ");
                }
                System.out.print("   总额：" + num + "元 ");
                System.out.println();
            }
        }
    }

    /**
     * 计算每人获得红包金额;最小每人0.01元
     * @param money 红包总额
     * @param number 人数
     * @return
     */
    public static List<Integer> math(int money, int number) {
        if (money < number) {
            return null;
        }
        Random random = new Random();
        // 随机数总额
        double count = 0;
        // 每人获得随机点数
        int[] arrRandom = new int[number];
        // 每人获得钱数
        List<Integer> arrMoney = new ArrayList<Integer>(number);
        // 循环人数 随机点
        for (int i = 0; i < arrRandom.length; i++) {
            int r = random.nextInt((number) * 99) + 1;
            count += r;
            arrRandom[i] = r;
        }
        // 计算每人拆红包获得金额
        int c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // 每人获得随机数相加 计算每人占百分比
            Double x = new Double(arrRandom[i] / count);
            // 每人通过百分比获得金额
            int m = (int) Math.floor(x * money);
            // 如果获得 0 金额，则设置最小值 1分钱
            if (m == 0) {
                m = 1;
            }
            // 计算获得总额
            c += m;
            // 如果不是最后一个人则正常计算
            if (i < arrRandom.length - 1) {
                arrMoney.add(c);
            } else {
                // 如果是最后一个人，则把剩余的钱数给最后一个人
                arrMoney.add(money - c + m);
            }
        }
        // 随机打乱每人获得金额
        Collections.shuffle(arrMoney);
        return arrMoney;
    }


}
