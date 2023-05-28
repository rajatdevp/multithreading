package org.example.problem_synchroniztion;

public class App {

    //This shows us consistent result of counter
    static int counter1 = 0;
    static int counter2 = 0;

    //with synchronized keyword we are making sure only one thread can execute at any give time
    static synchronized void increment1() {
        counter1++;
    }
    static synchronized void increment2() {
        counter2++;
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
        //diagram
    }
}
