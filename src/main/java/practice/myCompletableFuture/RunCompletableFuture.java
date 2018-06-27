package practice.myCompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<BidModule> cf = CompletableFuture.completedFuture(new BidModule());

    }
}
