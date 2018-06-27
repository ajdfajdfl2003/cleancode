package practice.myCompletableFuture;

public class BidModule {
    public BidModule() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("After sleep, I wake up.");
    }
}
