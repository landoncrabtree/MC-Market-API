// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.examples;

import com.google.gson.*;
import pw.landon.mcmapi.utilities.JSONUtilities;
import pw.landon.mcmapi.wrappers.Conversations;
import pw.landon.mcmapi.wrappers.Members;
import pw.landon.mcmapi.wrappers.Resources;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ResourcePurchaseDM {

    /*
    This example sends a direct message to users who purchase your resource.
     */

    public final static int RESOURCE_ID = 8675;

    public static String message = """
        Hey there, {username},
        Thank you for purchasing my resource!
        This message is configurable and what not.
        
        It also supports the {username} placeholder.Make sure to review this resource if you enjoy it! :^)""";

    public static void startCron() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println ("[" + Instant.now() + "] Running CRON job.");
                    String json = Resources.listResourcePurchases(RESOURCE_ID);
                    JsonObject root = JSONUtilities.convertStringToJSON(json);
                    JsonArray array = root.getAsJsonArray("data");
                    for (JsonElement purchase : array) {
                        JsonObject obj = purchase.getAsJsonObject();
                        long purchaseDate = obj.get("purchase_date").getAsLong();
                        long now = System.currentTimeMillis() / 1000;
                        int difference = (int) TimeUnit.SECONDS.toMinutes(now - purchaseDate);
                        if (difference < 5) {
                            int purchaser_id = obj.get("purchaser_id").getAsInt();
                            String username = Members.getUsername(purchaser_id);
                            String title = "Thank you for your purchase!";
                            Conversations.start(purchaser_id, message.replace("{username}", username), title);
                            System.out.println("Sent conversation to " + purchaser_id + " (" + username + ").");
                        }
                    }

                } catch (Exception e) {
                    System.out.println("An exception occurred.");
                }
            }
        };
        executor.scheduleAtFixedRate(r, 0L, 5L, TimeUnit.MINUTES);
    }
}
