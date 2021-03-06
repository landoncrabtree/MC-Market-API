// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi;

import pw.landon.mcmapi.utilities.HTTPUtils;

public class Wrapper {
    private Wrapper() { }
    public static Token token = null;
    public static boolean init = false;

    public static boolean init(Token token) throws Exception {
        // Attempt to initialise the API by checking the API token and seeing if it
        // returns 'success' or 'error.' Return this value as a boolean.
        String url = "https://api.mc-market.org/v1/health";
        String response = HTTPUtils.sendGETRequest(url, token);
        if (response == null) {
            return init;
        }
        init = !response.contains("{\"result\":\"error\"");
        return init;
    }
}
