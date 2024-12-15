package threadmanagement;

public class ThreadManager {

    public void executeInThread(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
    }
}
