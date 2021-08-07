// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.wrappers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;
import pw.landon.mcmapi.utilities.HTTPUtils;
import pw.landon.mcmapi.utilities.JSONUtilities;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Members {
    private Members() { }

    public static final Gson gson = new Gson();

    public static String getSelf() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/self", token);
        return response.body();
    }

    public static void modifySelf(String custom_title, String about_me, String signature) throws Exception {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        if (custom_title != null) {
            data.put("custom_title", custom_title);
        }
        if (about_me != null) {
            data.put("about_me", about_me);
        }
        if (signature != null) {
            data.put("signature", signature);
        }
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HttpResponse<String> response = HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/members/self", token, json.toString());
    }

    public static String getUser(int member_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/" + member_id, token);
        return response.body();
    }

    public static String getUsername(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("username").getAsString();
    }

    public static int getID(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("member_id").getAsInt();
    }

    public static long getJoinDate(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("join_date").getAsLong();
    }

    public static long getLastActivityDate(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("last_activity_date").getAsLong();
    }

    public static String getGender(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("gender").getAsString();
    }

    public static String getTimezone(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("timezone").getAsString();
    }

    public static boolean getIsBanned(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("banned").getAsBoolean();
    }

    public static boolean getIsSuspended(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("suspended").getAsBoolean();
    }

    public static boolean getIsRestricted(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("restricted").getAsBoolean();
    }

    public static boolean getIsDisabled(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("disabled").getAsBoolean();
    }

    public static int getPostCount(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("post_count").getAsInt();
    }

    public static int getResourceCount(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("resource_count").getAsInt();
    }

    public static int getPurchaseCount(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("purchase_count").getAsInt();
    }

    public static int getFeedbackPositive(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("feedback_positive").getAsInt();
    }

    public static int getFeedbackNegative(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("feedback_negative").getAsInt();
    }

    public static int getFeedbackNeutral(int member_id) throws Exception {
        String json = Members.getUser(member_id);
        return JSONUtilities.convertStringToJSON(json).get("data").getAsJsonObject().get("feedback_neutral").getAsInt();
    }

    public static String listBans() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/bans", token);
        return response.body();
    }

    public static String listProfilePosts() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/self/profile-posts", token);
        return response.body();
    }

    public static String getProfilePost(int post_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/self/profile-posts/" + post_id, token);
        return response.body();
    }

    public static void editProfilePost(int post_id, String message) throws Exception {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HttpResponse<String> response = HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/members/self/profile-posts/" + post_id, token, json.toString());
    }

    public static void deleteProfilePost(int post_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendDELETERequest("https://api.mc-market.org/v1/members/self/profile-posts/" + post_id, token);
    }
}
