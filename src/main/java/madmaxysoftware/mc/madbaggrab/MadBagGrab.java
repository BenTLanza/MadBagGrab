package madmaxysoftware.mc.madbaggrab;

import org.bukkit.plugin.java.JavaPlugin;

public final class MadBagGrab extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("MadBagGrab plugin enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MadBagGrab plugin disabled");
    }
}
