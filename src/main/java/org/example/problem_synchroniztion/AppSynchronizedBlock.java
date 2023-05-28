package org.example.problem_synchroniztion;

public class AppSynchronizedBlock {

    //This shows us consistent result of counter1 and counter2
    static int counter1 = 0;
    static int counter2 = 0;

    //Do not direct add synchronized on method declaration it's not best practice.
    static  void increment1() {
        synchronized (AppSynchronizedBlock.class) {
            counter1++;
        }
    }
    //Do not direct add synchronized on method declaration it's not best practice.
    static  void increment2() {
        synchronized (AppSynchronizedBlock.class) {
            counter2++;
        }
    }

    static void process() {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment2();
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


        System.err.println(counter1);
        System.err.println(counter2);
    }

    public static void main(String[] argument) throws InterruptedException {
        process();

    }
}
