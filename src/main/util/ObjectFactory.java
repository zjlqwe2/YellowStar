package util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 对象生产工厂
 */
public class ObjectFactory {
    private static Map<String, Object> map = new HashMap<String, Object>();

    static {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/yellowstar.properties"));
            String str = br.readLine();
            while (str != null) {
                // 分割配置文件的每行
                String[] arr = str.split("=");
                // 根据获取到类实例出对象
                Object o2 = Class.forName(arr[1]).newInstance();
                map.put(arr[0].toLowerCase().trim(), o2);
                str = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
