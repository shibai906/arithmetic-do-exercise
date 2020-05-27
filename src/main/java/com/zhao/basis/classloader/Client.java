package com.zhao.basis.classloader;

import java.net.URL;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-24 23:53
 **/
public class Client {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//        testClassForName();
//        testClassLoader();
        testPuTong();
    }

    public static void testPuTong() {
        TestFunction.fun();
        TestFunction.fun();
    }

    public static void testClassForName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.zhao.basis.classloader.TestFunction");
        System.out.println(clazz);
        TestFunction testFunction = (TestFunction) clazz.newInstance();
        testFunction.test();
    }

    public static void testClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> testClass = loader.loadClass("com.zhao.basis.classloader.TestFunction");
        System.out.println(testClass);
        TestFunction function = (TestFunction) testClass.newInstance();
        function.test();

    }

    /**
     * 引导类加载器，又称启动类加载器，是最顶层的类加载器，主要用来加载Java核心类，
     * 如rt.jar、resources.jar、charsets.jar等，Sun的JVM中，执行java的命令中使用-Xbootclasspath选项或使用
     * - D选项指定sun.boot.class.path系统属性值可以指定附加的类，它不是 java.lang.ClassLoader的子类，而是由JVM自身实现的该类c 语言实现，
     * Java程序访问不到该加载器。通过下面代码可以查看该加载器加载了哪些jar包
     */
    public static void bootstrapClassloader() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }

    /**
     * 扩展类加载器，主要负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar包或者由java.ext.dirs系统属性指定的jar包。
     * 放入这个目录下的jar包对所有AppClassloader都是可见的（后面会知道ExtClassloader是AppClassloader的父加载器)。那么ext都是在那些地方加载类内：
     */
    public static void extClassloader() {

        // 获取加载类
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();

        System.out.println(System.getProperty("java.ext.dirs"));
    }

    /**
     * 系统类加载器，又称应用加载器，本文说的SystemClassloader和APPClassloader是一个东西，
     * 它负责在JVM启动时，加载来自在命令java中的-classpath或者java.class.path系统属性或者 CLASSPATH操作系统属性所指定的JAR类包和类路径。
     * 调用ClassLoader.getSystemClassLoader()可以获取该类加载器。如果没有特别指定，则用户自定义的任何类加载器都将该类加载器作为它的父加载器,
     * 这点通过ClassLoader的无参构造函数可以知道如下：
     */
    public static void appClassLoader() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(System.getProperty("java.class.path"));
    }

}
