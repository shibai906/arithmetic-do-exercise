package com.zhao.newInterest.ifToEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-18
 * @Time: 下午5:42
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        IfTest test = new IfTest();
        System.out.println(test.testString("zhaohuan"));

        System.out.println(EnumTest.getByName("zhaohuan").handle("2399898"));
    }

}
