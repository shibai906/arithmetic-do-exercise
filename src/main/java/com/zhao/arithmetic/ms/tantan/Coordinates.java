package com.zhao.arithmetic.ms.tantan;

import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-23 17:04
 * @description 坐标题，找出最近的坐标
 **/
public class Coordinates {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            LockSupport.park();
            try {
                Thread.sleep(1000);
                System.out.println("哈哈哈" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();


        Thread thread1 = new Thread(() -> {

            try {
                Thread.sleep(5000);
                System.out.println("------" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread);
        });
        thread1.start();




    }


    public List<Zuobiao> getJinZuobiao(List<Zuobiao> zuobiaos, int x , int y, int num) {

        if(zuobiaos == null) {
            return null;
        }
        if(num > zuobiaos.size()) {
            return zuobiaos;
        }

        Set<Zuobiao> set = new TreeSet<>(new Comparator<Zuobiao>() {
            @Override
            public int compare(Zuobiao o1, Zuobiao o2) {
                int compare = (o1.x - x) * (o1.x - x) + (o1.y - y) * (o1.y - y) - (o2.x - x) * (o2.x - x) + (o2.y - y) * (o2.y - y);
                if(compare == 0) {
                    compare = o1.x - o2.x;
                    if(compare == 0) {
                        compare = o1.y - o2.y;
                    }
                }
                return compare;
            }
        });
        set.addAll(zuobiaos);

        List<Zuobiao> result = new ArrayList<>();

        zuobiaos.clear();
        zuobiaos.addAll(set);

        for(int i = 0 ; i < num ; i ++) {
            result.add(zuobiaos.get(i));
        }
        return result;
    }


    static class Zuobiao{
        int x ;
        int y ;
    }

}
