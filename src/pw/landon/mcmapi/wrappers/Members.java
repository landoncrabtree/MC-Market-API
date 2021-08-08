// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.wrappers;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;
import pw.landon.mcmapi.utilities.HTTPUtils;
import pw.landon.mcmapi.utilities.JSONUtilities;

import java.util.HashMap;
import java.util.Map;

public class Members {
    private Members() { }

    public static final Gson gson = new Gson();

    public static String self() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/self", token);
    }

    public static void modifySelf(String custom_title, String about_me, String signature) {
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
        HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/members/self", token, json.toString());
    }

    public static String getUser(int member_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/" + member_id, token);
    }

    public static String getUsername(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("username") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("username").getAsString() : null;
    }

    public static Integer getID(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("member_id") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("member_id").getAsInt() : null;
    }

    public static Long getJoinDate(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("join_date") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("join_date").getAsLong() : null;
    }

    public static Long getLastActivityDate(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("last_activity_date") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("last_activity_date").getAsLong() : null;
    }

    public static String getGender(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("gender") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("gender").getAsString() : null;
    }

    public static String getTimezone(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("timezone") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("timezone").getAsString() : null;
    }

    public static Boolean getIsBanned(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("banned") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("banned").getAsBoolean() : null;
    }

    public static Boolean getIsSuspended(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("suspended") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("suspended").getAsBoolean() : null;
    }

    public static Boolean getIsRestricted(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("restricted") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("restricted").getAsBoolean() : null;
    }

    public static Boolean getIsDisabled(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("disabled") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("disabled").getAsBoolean() : null;
    }

    public static Integer getPostCount(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("post_count") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("post_count").getAsInt() : null;
    }

    public static Integer getResourceCount(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("resource_count") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("resource_count").getAsInt() : null;
    }

    public static Integer getPurchaseCount(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("purchase_count") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("purchase_count").getAsInt() : null;
    }

    public static Integer getFeedbackPositive(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("feedback_positive") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("feedback_positive").getAsInt() : null;
    }

    public static Integer getFeedbackNegative(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("feedback_negative") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("feedback_negative").getAsInt() : null;
    }

    public static Integer getFeedbackNeutral(int member_id) {
        String json = Members.getUser(member_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        if (result.get("data") == null) {
            return null;
        }
        return result.get("data").getAsJsonObject().get("feedback_neutral") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("feedback_neutral").getAsInt() : null;
    }

    public static String listBans() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/bans", token);
    }

    public static String listProfilePosts() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/self/profile-posts", token);
    }

    public static String getProfilePost(int post_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/members/self/profile-posts/" + post_id, token);
    }

    public static void editProfilePost(int post_id, String message) {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/members/self/profile-posts/" + post_id, token, json.toString());
    }

    public static void deleteProfilePost(int post_id) {
        Token token = Wrapper.token;
        HTTPUtils.sendDELETERequest("https://api.mc-market.org/v1/members/self/profile-posts/" + post_id, token);
    }
}
