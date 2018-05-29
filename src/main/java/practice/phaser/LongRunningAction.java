package practice.phaser;

import java.util.concurrent.Phaser;

public class LongRunningAction implements Runnable {

    private String threadName;
    private Phaser phaser;

    public LongRunningAction(String threadName, Phaser phaser) {
        System.out.println("Run " + threadName);
        this.threadName = threadName;
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
        try {
            System.out.println(this.threadName + " Before sleep: " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(this.threadName + " After sleep: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
        System.out.println(this.threadName + " Phase: " + phaser.getPhase());
    }
}
