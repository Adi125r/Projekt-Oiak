import org.deuce.Atomic;
import org.deuce.transaction.AbortTransactionException;

public class RunnableDemo extends Thread {

    public Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
    }

    public void run() {

        increment();
        decrement();
    }

    public void increment()
    {

            Main.mutex.lock();

                Main.value++;
                Main.lala--;

            Main.mutex.unlock();

    }

    public void decrement()
    {
        boolean endIt = true;

        while (endIt)
        {
            Main.mutex.lock();
            if(Main.lala2<=0)
                endIt=false;

            if (endIt==true){
                Main.value--;
                Main.lala2--;
            }
            Main.mutex.unlock();
        }

    }

    public void start () {
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }
    }

}
