// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.wrappers;

import com.google.gson.Gson;
import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;
import pw.landon.mcmapi.utilities.HTTPUtils;

import java.net.http.HttpResponse;

public class Resources {
    private Resources() { }

    public static final Gson gson = new Gson();

    public static String listResources() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources", token);
        return response.body();
    }

    public static String listOwnedResources() throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/owned", token);
        return response.body();
    }

    public static String listResourcePurchases(int resource_id) throws Exception {
        Token token = Wrapper.token;
        HttpResponse<String> response = HTTPUtils.sendGETRequest("https://api.mc-market.org/v1/resources/" + resource_id + "/purchases", token);
        return response.body();
    }
}
