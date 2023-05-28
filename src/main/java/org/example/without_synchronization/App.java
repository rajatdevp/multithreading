package org.example.without_synchronization;

public class App {

    //This shows us inconsistent result of counter
    static int counter = 0;

    static void increment() {
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
       //The inconsistency is due to both threads are calling increment method at any given time
       //and the counter value getting increased inconsistency.
       //diagram
    }

}
