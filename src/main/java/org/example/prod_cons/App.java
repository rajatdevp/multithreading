package org.example.prod_cons;

public class App {

    public static void main(String[] dd) {

        Process process =new Process();

        Thread thread1= new Thread(process::produce);

        Thread thread3= new Thread(process::consume);

        thread1.start();
        thread3.start();

    }
}
