package com.geekaca.iobuffer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework1 {
    public static void main(String[] args) {
        /**
         * 文本文件
         * 1.选择流的种类
         *     字符流 带有缓冲的BufferedReader
         * 2.读取思路
         *  A 先把所有内容全部读取出来 然后再进行处理
         *  B 每读取一行 就统计一行 每一行都是一个字符串String 对象
         *
         * 我给你一个字符串 你来取出其中的单词
         *
         * 3.如何记录每一个单词出现的数量
         *  Map结构
         *  单词当作key
         *  数量当作value
         */
        String filePath = "C:\\Users\\kanata\\Documents\\Java单词.txt";
        //放所有找到的所有单词{hello,...}
        List<String> wordList = new ArrayList<>();
        try (FileReader fr = new FileReader(filePath);) {
            //FileReader 是Reader的间接子类
            /**
             * BufferedReader 作为一个高级 缓冲流 本身不具备直接读取文件的能力
             * 需要建立在其他的流之上
             *
             * 比喻: 发快递，
             * 由快递小哥FileReader 在小区到处跑 收集各个顾客要发的快递
             * 在快递点统一处理 统一的集散地 大卡车来收 运到码头 或者装集装箱(BufferedReader) 统一发送
             * 越洋运输
             */
            BufferedReader br = new BufferedReader(fr);
            //读取文件的经典步骤
            String line = null;//接收从文件中读取到的每一行
            //idea 多列编辑 按住alt按键 鼠标竖着拖动 选择一列
            while ((line = br.readLine()) != null){
                String str = "Java Hello main class file";
                Pattern pattern = Pattern.compile("[a-zA-Z]+");
                Matcher matcher = pattern.matcher(line);
                //找到一个符合条件的
                while (matcher.find()) {
                    String word = matcher.group();
//                    System.out.println(matcher.group());
//                    System.out.println("找到单词：" + word);
                    /**
                     * 先找到所有单词
                     * 放入一个集合Arraylist
                     */
                    wordList.add(word);
                }
            }
        }catch (FileNotFoundException e){
            //生成catch子句
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //结束了文件的搜索
        //下面 只负责 从集合中统计所有单词出现的数量
//        wordList.forEach(wd -> System.out.println(wd));
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            /**
             * 如何计数
             * 1。判断word是否已经在map中存在了
             * 如果不存在 就put(word，1)
             * 踩在 就put(word，原本的值+1）
             */
            if (map.containsKey(word)){
                Integer cnt = map.get(word);
                map.put(word,cnt +1);
            } else {
                map.put(word,1);
            }
            System.out.println("单词统计如下" );
            map.forEach((k,v)->{
                System.out.println(k + ":" + v);
            });
        }
    }
    /**
     * //从字符串中查找 单词
     *         String str = "Java Hello main class file";
     *         Pattern pattern = Pattern.compile("[a-zA-Z]+");
     *         Matcher matcher = pattern.matcher(str);
     *         //找到一个符合条件的
     *         while(matcher.find()){
     *             System.out.println(matcher.group());
     *         }
     *
     */

}
