package com.lifeng.springbootdemo.basic;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MetaSpaceTest {

    public static void main(String[] args) {
//        testOutMemoryOfMetaSpace();
        testStringInternExceed();
    }

    public static void testOutMemoryOfMetaSpace() {
        // 无限创建堆栈
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("D:\\GoogleDrive\\Coding\\SpringBootTest\\springbootdemo\\src\\main\\java\\com\\lifeng\\springbootdemo\\restful").toURI().toURL();
            URL[] urls = {url};
            // 不断生成新的类
            while (true){
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.lifeng.springbootdemo.ServletInitializer");
                //System.out.println("生成新的类！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testStringInternExceed() {
        String originStr = "这是用于测试的字符串";
//        List<String> list = new ArrayList<>();
        Map<String, Long> map = new ConcurrentHashMap<>();
        long index = 0;
        try {
            while (true) {
                String str = originStr + index;
//                list.add(str.intern());
                map.put(str.intern(), index);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
