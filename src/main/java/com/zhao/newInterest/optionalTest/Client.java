package com.zhao.newInterest.optionalTest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-24
 * @Time: 下午2:15
 * @Description:
 */
public class Client {

    public static JSONObject assembleJson() {
        JSONObject result = new JSONObject();

        JSONObject one = new JSONObject();
        one.put("one","一层");
        JSONObject two = new JSONObject();
        two.put("two","二层");
        JSONObject three = new JSONObject();
        three.put("three","三层");
        JSONObject four = new JSONObject();
        four.put("four","四层");
        one.put("twoLevel",two);
        two.put("threeLevel",three);
        three.put("fourLeve",four);
        result.put("result",one);
        return result;
    }

    public static TestModel getTestModel() {
        TestModel testModel = new TestModel();
        testModel.setAge(25);
        testModel.setName("赵欢");
        testModel.setPassword("密码是什么你妹");
        return testModel;
    }

    public static void testFilter() {
        Optional<JSONObject> optional = Optional.ofNullable(assembleJson());
        optional.filter(json -> "赵欢".equals(json.getString("one"))).map(json -> json.getJSONObject("twoLevel"));
    }

    /**
     * map()方法的参数为Function（函数式接口）对象，map()方法将Optional中的包装对象用Function函数进行运算，并包装成新的Optional对象（包装对象的类型可能改变）。
     * 入参Function函数的返回值类型为Optional<U>类型，而不是U类型，这样flatMap()能将一个二维的Optional对象映射成一个一维的对象
     */
    public static void testFlatMap() {
        Optional<TestModel> testModel = Optional.ofNullable(getTestModel());
        Optional<String> testOptional = testModel.flatMap(u -> Optional.ofNullable(u.getPassword()));
    }

    /**
     * orElseGet()方法与orElse()方法类似，区别在于orElseGet()方法的入参为一个Supplier对象，用Supplier对象的get()方法的返回值作为默认值
     */
    public static void testOrElseGet() {
        Optional<JSONObject> optional = Optional.ofNullable(assembleJson());
        System.out.println(optional.filter(json -> "赵欢".equals(json.getString("one"))).map(json -> json.getJSONObject("twoLevel")).orElseGet(null));
        optional.filter(json -> "赵欢".equals(json.getString("one"))).map(json -> json.getJSONObject("twoLevel")).orElse(null);
    }

    public static void testOrElseThrow() {
        Optional<JSONObject> optional = Optional.ofNullable(assembleJson());
        optional.orElseThrow(() -> new RuntimeException("我错了"));
    }

    public static void testNullMap() {
        Optional<JSONObject> optional = Optional.empty();
        String str = optional.map(json -> "你好").orElse("你好");
        System.out.println(str);
    }

    public static void main(String[] args) {
        testOrElseThrow();
        Optional<JSONObject> optional = Optional.ofNullable(assembleJson());
        String name = "zhaohuan";
        optional.ifPresent(json -> json.getJSONObject("twoLevel"));


    }


}
