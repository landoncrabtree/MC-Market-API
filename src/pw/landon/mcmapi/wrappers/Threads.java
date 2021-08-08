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

public class Threads {
    private Threads() { }

    public static final Gson gson = new Gson();

    public static String list() {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/threads", token);
    }

    public static String getThread(int thread_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/threads/" + thread_id, token);
    }

    public static String listReplies(int thread_id) {
        Token token = Wrapper.token;
        return HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/threads/" + thread_id + "/replies", token);
    }

    public static void reply(int thread_id, String message) {
        Token token = Wrapper.token;
        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        JsonObject json = JSONUtilities.convertMapToJSON(data);
        HTTPUtils.sendPOSTRequest("https://api.mc-market.org/v1/threads/" + thread_id + "/replies", token, json.toString());
    }
}
