package org.example.without_synchronization;

public class App {

    static  int counter =0;

    static void increment(){
        counter ++;
    }

    static void process(){

        Thread thread1= new Thread( ()->{
          for (int i=0;i<1000;i++){
              increment();
          }
        });

        Thread thread2= new Thread( ()->{
            for (int i=0;i<1000;i++){
                increment();
            }
        });


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.getMessage();
        }


        System.err.println(counter);
    }

    public static void main(String[] argument) throws InterruptedException {
        process();


    }

}
