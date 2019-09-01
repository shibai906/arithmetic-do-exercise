import com.zhao.TestJava;

public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
        System.out.println(path);
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> cl = classLoader.loadClass("D:\\webapp\\arithmetic-do-exercise\\target\\test-classes\\TestJava");
        TestJava testJava = (TestJava)cl.newInstance();
        testJava.function();

    }

}
