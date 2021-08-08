// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.examples;

import org.bukkit.plugin.java.JavaPlugin;
import pw.landon.mcmapi.objects.Resource;

public class SpigotVersionChecker extends JavaPlugin {

    /*
    This example checks a plugin's version to see if it's outdated or not.
     */

    public final static String CURRENT_VER = "%%__VERSION__%%";

    @Override
    public void onEnable() {
        Resource resource = new Resource(8436);
        int latest = resource.versionID;
        if (Integer.parseInt(CURRENT_VER) == latest) {
            System.out.println("You are running the latest version!");
        } else {
            System.out.println("You are running an outdated version!");
            System.out.println("The latest version is " + resource.versionName);
        }
    }
}
