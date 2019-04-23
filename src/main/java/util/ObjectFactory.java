package util;

import java.io.*;
import java.util.*;

/**
 * @description: 对象生产工厂
 */
public class ObjectFactory {
    private static Map<String, Object> map = new HashMap<String, Object>();

    static {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        try {
            prop.load(classloader.getResourceAsStream("yellowstar.properties"));
            Iterator<Map.Entry<Object, Object>> it = prop.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Object, Object> entry = it.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                Object object = Class.forName(value).newInstance();
                map.put(key.toLowerCase().trim(), object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象的方法
     * @param name 对象名
     * @return
     */
    public static Object getObject (String name) {
        name = name.toLowerCase().trim();
        return map.get(name);
    }

}
