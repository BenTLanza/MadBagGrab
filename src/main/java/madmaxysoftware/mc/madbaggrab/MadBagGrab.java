package madmaxysoftware.mc.madbaggrab;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

public final class MadBagGrab extends JavaPlugin {
    public Team bagRunnerTeam = null;

    @Override
    public void onEnable() {
        getLogger().info("MadBagGrab plugin enabled");

        bagRunnerTeam = getServer().getScoreboardManager().getMainScoreboard().getTeam("Bag Runner");
        if (bagRunnerTeam == null) {
            bagRunnerTeam = getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("Bag Runner");
            bagRunnerTeam.prefix(Component.text("[Bag Runner] ").color(NamedTextColor.RED));
        }

        getServer().getCommandMap().register("mbg", new CommandTest("test", this));

        getServer().getPluginManager().registerEvents(new ListenerGlide(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("MadBagGrab plugin disabled");
    }

    public void SetBagRunner(Player player) {
        RemoveBagRunner();
        player.setGliding(false);
        bagRunnerTeam.addEntry(player.getScoreboardEntryName());
    }

    public void RemoveBagRunner() {
        bagRunnerTeam.getEntries().forEach(playerName -> {
            bagRunnerTeam.removeEntry(playerName);
        });
    }

    public boolean IsBagRunner(Player player) {
        for (String playerName : bagRunnerTeam.getEntries())
            if (player.getScoreboardEntryName().equals(playerName))
                return true;
        return false;
    }
}
