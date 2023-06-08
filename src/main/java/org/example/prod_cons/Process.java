package org.example.prod_cons;

public class Process {

    public void produce() {
        synchronized (this) {
            System.out.println("produce running");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("again produce running");
        }

    }
    public void consume() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            System.out.println("consume running");
            notify();
        }
    }


}
