package practice.myCompletableFuture;

public class MainProcess implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Run main process!!!");
    }
}
