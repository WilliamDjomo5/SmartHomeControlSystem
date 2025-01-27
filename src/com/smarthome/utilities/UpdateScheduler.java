package com.smarthome.utilities;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import com.smarthome.appliances.Appliance;

public class UpdateScheduler {
	
	private static Clock clock = Clock.systemDefaultZone();
	
    /**
     * Allows setting a custom clock for testing purposes.
     * @param customClock the clock to use instead of the system default
     */
    public static void setClock(Clock customClock) {
        clock = customClock;
    }
    
    public static void scheduleAnnualUpdate(Appliance... appliances) {
        Timer timer = new Timer(true);
        LocalDateTime now = LocalDateTime.now(clock);
        LocalDateTime nextUpdate = now.withMonth(1).withDayOfMonth(1).withHour(1).withMinute(0).withSecond(0);
        if (now.isAfter(nextUpdate)) {
            nextUpdate = nextUpdate.plusYears(1);
        }

        long delay = java.time.Duration.between(now, nextUpdate).toMillis();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Annual update in progress. Turning off all appliances...");
                for (Appliance appliance : appliances) {
                    appliance.turnOff();
                }
                System.out.println("Update complete.");
            }
        }, delay);
    }
}