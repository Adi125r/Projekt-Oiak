public class RunnableGet extends Thread {

    public Thread t;
    private String threadName;



    public void run() {
increment();
    }

    public void increment()
    {

            Main.mutex.lock();
          Main.getLala();
            Main.mutex.unlock();

    }





    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start();
        }
    }

}
