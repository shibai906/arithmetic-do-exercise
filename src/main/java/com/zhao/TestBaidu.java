package com.zhao;

import com.zhao.spring.model.TestBean;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-05-26 19:27
 **/
public class TestBaidu {

    /**
     * student
     * student_id
     * student_name
     *
     * book
     * book_id
     * book_name
     *
     *
     * middle
     * student_id
     * book_id
     * chengji
     *
     *  select book_name from book ;
     *
     * select student.student_name from student  student left join
     *  (select middle.student_id student_id from (select count(1) cou,student_id from middle where chengji > 80 group by student_id) middle where
     *  middle.cou >= (select count(1) from book)) middle on middle.student_id = student.student_id; select count(1) from book;
     *
     *
     * (select count(1) cou,student_id from middle where chengji > 80 group by student_id)
     *
     *
     */




    public static void main(String[] args) {

        TestBaidu testBaidu = new TestBaidu();
        System.out.println(testBaidu.fun(-12221));
        System.out.println(testBaidu.fun(12221));
        System.out.println(testBaidu.fun(-121));
        System.out.println(testBaidu.fun(-1));
        System.out.println(testBaidu.fun(-1221));
        System.out.println(testBaidu.fun(1232222221));
        System.out.println(testBaidu.fun(12321));
        System.out.println(testBaidu.fun(12344321));


    }

    public boolean fun(int num) {

        if(num < 10 && num > -10) {
            return true;
        }
        int times = 0;
        int addNum = num;
        while(addNum != 0) {
            addNum /= 10;
            times ++;
        }
        for(int i = 0 ; i < times / 2 ; i ++) {

            int qian = (int) (num / Math.pow(10 , i ) % 10);
            int hou = (int) (num / Math.pow(10 ,times - i - 1) % 10);
            if(qian != hou) {
                return false;
            }
        }
        return true;
    }


}
