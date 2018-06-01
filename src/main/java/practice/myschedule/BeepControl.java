package practice.myschedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

class BeeperControl {
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(2);

    public void beepForAnHour() {
        final Runnable beeper = () -> {
//            System.out.println("beep");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("beep");
        };

        ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 0, 1, SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Cancel beep");
            beeperHandle.cancel(false);
        }, 1, SECONDS);
    }
}
