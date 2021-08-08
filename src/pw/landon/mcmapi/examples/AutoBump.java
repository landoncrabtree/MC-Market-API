// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.examples;

import pw.landon.mcmapi.wrappers.Threads;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoBump {

    /*
    This example bumps your thread every 24H.
     */

    // Modify this to your thread's ID.
    public final static int THREAD_ID = 265820;

    public static String message = """
        Bumping this thread automagically via the MCM API!
        Pretty cool, eh?""";

    public static void startCron() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable r = () -> {
            try {
                System.out.println ("[" + Instant.now() + "] Autobumping thread.");
                Threads.replyToThread(THREAD_ID, message);
            } catch (Exception e) {
                System.out.println("An exception occurred.");
            }
        };
        executor.scheduleAtFixedRate(r, 0L, 24L, TimeUnit.HOURS);
    }
}
