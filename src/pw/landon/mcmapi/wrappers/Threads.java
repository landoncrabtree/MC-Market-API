// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.wrappers;

import com.google.gson.Gson;
import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;
import pw.landon.mcmapi.utilities.HTTPUtils;

import java.net.http.HttpResponse;

public class Threads {
    private Threads() { }

    public static final Gson gson = new Gson();

    public static String listSelfThreads() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/threads", token);
        return response.body();
    }

    public static String getThreadInformation(int thread_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/threads/" + thread_id, token);
        return response.body();
    }

    public static String listThreadReplies(int thread_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/threads/" + thread_id + "/replies", token);
        return response.body();
    }
}
