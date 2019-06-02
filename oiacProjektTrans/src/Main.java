

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main extends Thread{

    static Semaphore semaphore = new Semaphore(1);
    volatile static long value =0;
    volatile static long lala =2000000;
    volatile static long lala2 =1000000;
    public static final Lock mutex = new ReentrantLock();
    private static int NUM_OF_THREADS = 10000;

    public static long getLala() {
        return lala;
    }

    public static void main(String[] args) throws InterruptedException {

        RunnableDemo[] thread = new RunnableDemo[NUM_OF_THREADS];
        RunnableGet[] thread2 = new RunnableGet[NUM_OF_THREADS];
        for(int i=0; i<NUM_OF_THREADS; i++)
        {
            thread[i] = new RunnableDemo(i+"");
        }
        for(int i=0; i<NUM_OF_THREADS; i++)
        {
            thread2[i] = new RunnableGet();
        }

        long startTime = System.nanoTime();
        for(int i=0; i<NUM_OF_THREADS; i++)
        {
            thread[i].start();
        }
        for(int i=0; i<NUM_OF_THREADS; i++)
        {
            thread2[i].start();
        }
        for(int i=0; i<NUM_OF_THREADS; i++)
        {
            thread[i].t.join();
        }
        for(int i=0; i<NUM_OF_THREADS; i++)
        {
            thread2[i].t.join();
        }
        long estimatedTime =  System.nanoTime() - startTime;


        System.out.println((float)estimatedTime/1000000);


    }
}
