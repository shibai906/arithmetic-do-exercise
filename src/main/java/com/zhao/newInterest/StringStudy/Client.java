package com.zhao.newInterest.StringStudy;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-19
 * @Time: 上午11:15
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        String charString = new String(new char[]{'A','赵',(char) 65539},0,3);
        charString.length();

        String subString = charString.substring(0,1);

        charString.equals(subString);

        charString.equalsIgnoreCase("abc");

        System.out.println(charString.indexOf(65539));

    }


}
