package util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyUtil {
    private static Properties prop=new Properties();
    static {
        try {
            prop.load(MyUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        String classpath=prop.getProperty(key);
        Object result=null;
        try {
            Class clazz=Class.forName(classpath);
            Method method=clazz.getMethod("getInstance");
            result=method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(get("USER_DAO"));
    }

}
