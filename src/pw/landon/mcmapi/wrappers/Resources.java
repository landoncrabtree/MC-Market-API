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

public class Resources {
    private Resources() { }

    public static final Gson gson = new Gson();

    public static String list() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources", token);
    }

    public static String listOwned() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/owned", token);
    }

    public static String getResource(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id, token);
    }

    public static void modifyResource(int resource_id, String title, String tag_line, String description) {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("title", title);
        data.put("tag_line", tag_line);
        data.put("description", description);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/resources/" + resource_id, token, json.toString());
    }

    public static String getDownloads(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/downloads", token);
    }

    public static String getDownloadsByMember(int resource_id, int member_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/downloads/members/" + member_id, token);
    }

    public static String getDownloadsByVersion(int resource_id, int version_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/downloads/versions/" + version_id, token);
    }

    public static String getLicenses(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/licenses", token);
    }

    public static void issueLicense(int resource_id, int purchaser_id, long start_date, long end_date, boolean active, String site_url) {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("purchaser_id", purchaser_id);
        data.put("start_date", start_date);
        data.put("end_date", end_date);
        data.put("active", active);
        data.put("site_url", site_url);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPOSTRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/licenses", token, json.toString());
    }

    public static String getLicenseByID(int resource_id, int license_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/licenses/" + license_id, token);
    }

    public static void modifyLicense(int resource_id, int license_id, long start_date, long end_date, boolean active) {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("start_date", start_date);
        data.put("end_date", end_date);
        data.put("active", active);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/licenses/" + license_id, token, json.toString());
    }

    public static String validateLicensePrivate(int resource_id, int purchaser_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/licenses/validate/" + purchaser_id, token);
    }

    public static String validateLicenseShared(int resource_id, int purchaser_id, int nonce, long timestamp) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/licenses/validate/" + purchaser_id + "?nonce=" + nonce + "&?timestamp=" + timestamp, token);
    }

    public static String getPurchases(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/purchases", token);
    }

    public static String getPurchaseByID(int resource_id, int purchase_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/purchases/" + purchase_id, token);
    }

    public static String getReviews(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/reviews", token);
    }

    public static String getReviewByMember(int resource_id, int member_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/reviews/members/" + member_id, token);
    }

    public static void respondToReview(int resource_id, int review_id, String message) {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/reviews/" + review_id, token, json.toString());
    }

    public static String getUpdates(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/updates", token);
    }

    public static String getLatestUpdate(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/updates/latest", token);
    }

    public static String getUpdateByID(int resource_id, int update_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/updates/" + update_id, token);
    }

    public static String getVersions(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/versions", token);
    }

    public static String getLatestVersion(int resource_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/versions/latest", token);
    }

    public static String getVersionByID(int resource_id, int version_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/versions/" + version_id, token);
    }

    public static Integer getLatestVersionID(int resource_id) {
        String json = Resources.getLatestVersion(resource_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        return result.get("data").getAsJsonObject().get("version_id") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("version_id").getAsInt() : null;
    }

    public static String getLatestVersionName(int resource_id) {
        String json = Resources.getLatestVersion(resource_id);
        JsonObject result = JSONUtilities.convertStringToJSON(json);
        return result.get("data").getAsJsonObject().get("name") != JsonNull.INSTANCE ? result.get("data").getAsJsonObject().get("name").getAsString() : null;
    }


}
