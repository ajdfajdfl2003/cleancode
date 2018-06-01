package practice.myschedule;

public class RunBeepControl {
    public static void main(String[] args) throws InterruptedException {
        BeeperControl beeperControl = new BeeperControl();

        beeperControl.beepForAnHour();

        System.out.println("Run Beep End !!!");
    }
}
