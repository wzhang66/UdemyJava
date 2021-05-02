package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        FileWriter localFile = null;
//        try {
//            localFile = new FileWriter("location.txt");
//            for(int i = 5; i<10; i++){
//                localFile.write(i+"\n");
//            }
//
//        } catch (IOException e){
//            e.printStackTrace();
//            System.out.println("In catch block");
//        } finally {
//            System.out.println("in finally block");
//            try {
//                if(localFile != null){
//                    localFile.close();// Fail to close the file will lead to resource leak
//                }
//            } catch (IOException e){
//                System.out.println("in finally catch block");
//                e.printStackTrace();
//            }
//
//
//        }
        // File reader
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("location.txt"));
//            scanner.useDelimiter();
            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
                System.out.println(loc);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }
}
