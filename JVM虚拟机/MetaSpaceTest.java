package Jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by l00426746 on 2019/6/28.
 */
public class MetaSpaceTest {

    public static void main(String[] args) throws InterruptedException {
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        //String s3 = "1" + "1";
//        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            Thread.sleep(1);
        }
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(originStr);
        }
        originStr = sb.toString();
//        List<String> list = new ArrayList<>();
        Map<String, Long> map = new ConcurrentHashMap<>();
        long index = 0;
        try {
            while (true) {
                String str = originStr + index;
                str = str.intern();
                map.put(str, index);
                index++;
                System.out.println("map的大小为：" + map.size());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
