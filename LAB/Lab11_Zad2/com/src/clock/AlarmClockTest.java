package clock;

import alarm.AlarmActionEventHandler;
import alarm.AlarmEvent;

public class AlarmClockTest {

    private AlarmClock ringer;

    public AlarmClockTest() {

        ringer = new AlarmClock(new RingHandler(), 10);
    }

    public static void main(String[] args) {
        AlarmClockTest test = new AlarmClockTest();
        test.ringer.start();
    }

    private class RingHandler implements AlarmActionEventHandler {

        @Override
        public void alarmActionPerformed(AlarmEvent args) {
            System.out.printf("Rings remaining: %d%n", ringer.getNrings());
        }
    }
}
