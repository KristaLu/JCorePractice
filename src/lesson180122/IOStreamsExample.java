package lesson180122;

// утилита, копирующая файл

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class IOStreamsExample {
    public static void main(String[] args) throws Exception {
        try(InputStream is = new FileInputStream("test/lesson180112/FibonacciTest.java");
            OutputStream os = new FileOutputStream("Output.txt")){
            copyStream(is,os);
            copyStream2(is,os);
        }
        System.out.println("Completed");

        // копирование ивдео из интеренета:
//        URL url = new URL("");
//        URLConnection urlc = url.openConnection();
//        try(InputStream is = urlc.getInputStream();
//            OutputStream os = new FileOutputStream("")){
//            copyStream2(is,os);
//        }
        // todo закрыть urlconnection
    }

    public static void copyStream(InputStream input, OutputStream output){
        long time = System.currentTimeMillis();
        try {
            int read;
            while ((read=input.read())!=-1){
                output.write(read);
                read=input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }

    // оборачивается в Buffer... паттерн декоратор
    public static void copyStream2(InputStream input, OutputStream output){
        long time = System.currentTimeMillis();
        try {
            byte[] buffer = new byte[4096];
            BufferedInputStream bis = new BufferedInputStream(input);
            BufferedOutputStream bos = new BufferedOutputStream(output);
            int len = 0;

            while ((len = bis.read(buffer))!=-1){
                bos.write(buffer, 0, len);
            }
            bos.flush(); // для того, чтобы последние байты добавились
        } catch (IOException e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}

