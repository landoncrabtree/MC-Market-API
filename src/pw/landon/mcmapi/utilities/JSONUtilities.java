// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class JSONUtilities {
    private JSONUtilities() { }

    public static final Gson gson = new Gson();

    public static JsonObject convertStringToJSON(String string) {
        JsonElement json = JsonParser.parseString(string);
        return json.getAsJsonObject();
    }

    public static JsonObject convertMapToJSON(Map<String, Object> map) {
        return gson.toJsonTree(map).getAsJsonObject();
    }

}
