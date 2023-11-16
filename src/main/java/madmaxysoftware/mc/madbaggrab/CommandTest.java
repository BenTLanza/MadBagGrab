package madmaxysoftware.mc.madbaggrab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandTest extends Command {
    private MadBagGrab plugin;

    protected CommandTest(@NotNull String name, MadBagGrab plugin) {
        super(name);
        this.plugin = plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            plugin.SetBagRunner((Player)commandSender);
            return true;
        } else {
            return false;
        }
    }
}
