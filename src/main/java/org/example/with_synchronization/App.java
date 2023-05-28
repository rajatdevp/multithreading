package org.example.with_synchronization;

public class App {

    //This shows us consistent result of counter
    static int counter = 0;

    //with synchronized keyword we are making sure only one thread can execute at any give time
    static synchronized void increment() {
        counter++;
    }

    static void process() {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });


        thread1.start();
        thread2.start();

        try {
            //join both thread to main thread(in this example)
            //because want finish both thread execution, before main thread completes
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }


        System.err.println(counter);
    }

    public static void main(String[] argument) throws InterruptedException {
        process();
       //diagram
    }

}
