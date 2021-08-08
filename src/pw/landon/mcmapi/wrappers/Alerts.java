// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.wrappers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;
import pw.landon.mcmapi.utilities.HTTPUtils;
import pw.landon.mcmapi.utilities.JSONUtilities;

import java.util.HashMap;
import java.util.Map;

public class Alerts {
    private Alerts() { }

    public static final Gson gson = new Gson();

    public static String list() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/alerts", token);
    }

    public static void markAsRead() {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("read", true);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPATCHRequest("https://api.mc-market.org/v1/alerts", token, json.toString());
    }
}
