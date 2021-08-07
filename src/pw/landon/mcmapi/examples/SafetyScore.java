// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.examples;

import com.google.gson.*;
import pw.landon.mcmapi.utilities.JSONUtilities;
import pw.landon.mcmapi.wrappers.Conversations;
import pw.landon.mcmapi.wrappers.Members;
import pw.landon.mcmapi.wrappers.Resources;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SafetyScore {

    /*
    This example determines a safety score (0-100) of a user, with 100 being trustworthy and 0 being DWC.
     */

    public static String message = """
        Calculating safety score for {username}:
        Positive Feedback: {pos}
        Negative Feedback: {neg}
        Positive Feedback Percentage: {percent}
        
        Date Joined: {joined}
        Total Posts: {posts}
        
        Suspended: {suspended}
        Banned: {banned}
        
        This user's safety score is {safety}.
        This is not to be taken as blind advice.
        You should still take risk prevention measures when dealing with users.
        ALWAYS use a reputable middleman.""";

    public static void calculate(int member_id) throws Exception {
        String username = Members.getUsername(member_id);
        int posFeedback = Members.getFeedbackPositive(member_id);
        int negFeedback = Members.getFeedbackNegative(member_id);
        double posRate = 100 - ((double) negFeedback / (double) posFeedback);
        Date date = new Date(Members.getJoinDate(member_id) * 1000);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("CST"));
        String dateString = format.format(date);
        int joinYear = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)).getYear();
        int posts = Members.getPostCount(member_id);
        boolean suspended = Members.getIsSuspended(member_id);
        boolean banned = Members.getIsBanned(member_id);
        int safetyScore = 0;

        if (posFeedback >= 200) {
            safetyScore += 90;
        } else if (posFeedback >= 150) {
            safetyScore += 70;
        } else if (posFeedback >= 100) {
            safetyScore += 60;
        } else if (posFeedback >= 50) {
            safetyScore += 50;
        } else if (posFeedback >= 10) {
            safetyScore += 20;
        }

        if (posRate <= 80 && posRate >= 70) { // 70-80
            safetyScore -= 10;
        } else if (posRate <= 70 && posRate >= 50) { // 50-70
            safetyScore -= 15;
        } else if (posRate >= 50) { // 0-50
            safetyScore -= 20;
        }

        safetyScore += (LocalDate.now().getYear() - joinYear) * 10;

        if (posts >= 2000) {
            safetyScore += 20;
        } else if (posts >= 1000) {
            safetyScore += 10;
        } else if (posts >= 500) {
            safetyScore += 5;
        }

        if (safetyScore > 100) {
            safetyScore = 100;
        }

        if (safetyScore < 0) {
            safetyScore = 0;
        }

        message = message.replace("{username}", username);
        message = message.replace("{pos}", Integer.toString(posFeedback));
        message = message.replace("{neg}", Integer.toString(negFeedback));
        message = message.replace("{percent}", posRate + "%");
        message = message.replace("{joined}", dateString);
        message = message.replace("{posts}", Integer.toString(posts));
        message = message.replace("{suspended}", String.valueOf(suspended));
        message = message.replace("{banned}", String.valueOf(banned));
        message = message.replace("{safety}", Integer.toString(safetyScore));
        System.out.println(message);
    }
}
