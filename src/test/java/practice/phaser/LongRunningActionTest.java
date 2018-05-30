package practice.phaser;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static org.junit.Assert.assertEquals;

public class LongRunningActionTest {
    @Test
    public void testOne() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser ph = new Phaser(1);

        executorService.submit(new LongRunningAction("thread-1", ph));
        executorService.submit(new LongRunningAction("thread-4", ph));
        ph.arriveAndAwaitAdvance();

        executorService.submit(new LongRunningAction("thread-2", ph));
        ph.arriveAndAwaitAdvance();

        executorService.submit(new LongRunningAction("thread-3", ph));
        executorService.submit(new LongRunningAction("thread-5", ph));
        ph.arriveAndAwaitAdvance();

        assertEquals(3, ph.getPhase());

        ph.arriveAndDeregister();
    }
}