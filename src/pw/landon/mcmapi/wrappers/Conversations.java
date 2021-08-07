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

public class Conversations {
    private Conversations() { }

    public static final Gson gson = new Gson();

    public static String list() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/conversations", token);
        return response.body();
    }

    public static void start(int recipient_id, String title, String message) throws Exception {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("recipient_id", recipient_id);
        data.put("title", title);
        data.put("message", message);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HttpResponse<String> response = HTTPUtils.sendPOSTRequest("https://api.mc-market.org/v1/conversations", token, json.toString());
    }

    public static String listReplies(int conversation_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/conversations/" + conversation_id + "/replies", token);
        return response.body();
    }

    public static void reply(int conversation_id, String message) throws Exception {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HttpResponse<String> response = HTTPUtils.sendPOSTRequest("https://api.mc-market.org/v1/conversations/" + conversation_id + "/replies", token, json.toString());
    }
}
