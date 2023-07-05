package com.geekaca.iobuffer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        /**
         * 了解Properties类用法
         * 既具有Map结构的key value特点
         * 又具有文件的读写能力
         */
        readProperties();
        writeProperties();
    }


    public static void readProperties() {
        Properties pro = new Properties();
        try (FileReader fr = new FileReader("user.properties");) {
            pro.load(fr);
            String adminstr = pro.getProperty("admin");
            String compandy = pro.getProperty("compandy");
            System.out.println(adminstr + compandy);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeProperties(){
        Properties properties = new Properties();
        properties.setProperty("admin","5656565");
        properties.setProperty("compandy","geekaca");
        try(FileWriter fw = new FileWriter("user.properties",Charset.forName("UTF8"));) {
            properties.store(fw, "这是一条注释");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


