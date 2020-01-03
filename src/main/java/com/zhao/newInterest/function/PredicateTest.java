package com.zhao.newInterest.function;

import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-24
 * @Time: 下午5:32
 * @Description:
 */
public class PredicateTest {

    public static void testPredicate() {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 2) {
                    return true;
                }
                return false;
            }
        };
        predicate = (t) -> t > 2;
        System.out.println(predicate.test(8));
    }

    public static void main(String[] args) {
        testPredicate();
    }

}
