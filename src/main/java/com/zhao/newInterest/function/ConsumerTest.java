package com.zhao.newInterest.function;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-24
 * @Time: 下午5:03
 * @Description:
 */
public class ConsumerTest {

    public static void main(String[] args) {
        testConsumer();
    }

    public static void testConsumer() {

        // 1、使用consumer接口实现方法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer);

        System.out.println("********************");

        //② 使用lambda表达式，forEach方法需要的就是一个Consumer接口
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer<String> consumer1 = (s) -> System.out.println(s);//lambda表达式返回的就是一个Consumer接口
        stream.forEach(consumer1);
        //更直接的方式
        //stream.forEach((s) -> System.out.println(s));
        System.out.println("********************");

        //③ 使用方法引用，方法引用也是一个consumer
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer consumer2 = System.out::println;
//        stream.forEach(consumer);
        //更直接的方式
        stream.forEach(System.out::println);

//        IntConsumer


    }


}
