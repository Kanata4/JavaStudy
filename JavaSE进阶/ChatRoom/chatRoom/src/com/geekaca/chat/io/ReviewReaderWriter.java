package com.geekaca.chat.io;

import java.io.*;

public class ReviewReaderWriter {
    public static void main(String[] args) {
        /**
         * 字符缓冲流
         */
        File file = new File("C:\\Users\\kanata\\Documents\\dataOut.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file));){
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
