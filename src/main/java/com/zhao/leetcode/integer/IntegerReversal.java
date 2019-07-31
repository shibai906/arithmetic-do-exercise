package com.zhao.leetcode.integer;


public class IntegerReversal {


    public static void main(String[] args) {

        System.out.println((long)Math.pow(2,31));

        System.out.println(9534236461L > Math.pow(2, 31) - 1);

        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469,0));

    }

    public static int reverse(int x) {
        long max = (long) Math.pow(2, 31);
        if (x == 0 || x > max - 1 || x < -max) {
            return x;
        }
        StringBuilder sb = new StringBuilder();
        long num = x;
        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 10);
            num = num / 10;
        }
        if (flag) {
            long reslut = Long.parseLong(sb.toString());
            if (reslut > max - 1) {
                return 0;
            }
            return (int) reslut;
        }
        long result = Long.parseLong(sb.toString());
        if (result > max) {
            return 0;
        }
        return (int) (0 - result);
    }

    public static int reverse(int x,int z) {
        int dev = 0 ;
        while(x != 0) {
            int pop = x % 10;
            x = x / 10;
            if(dev > Integer.MAX_VALUE / 10 || (dev == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }
            if(dev < -Integer.MAX_VALUE / 10 || (dev == Integer.MAX_VALUE && pop < -8)) {
                return 0;
            }
            dev = dev * 10 + pop;
        }
        return dev;
    }
}


