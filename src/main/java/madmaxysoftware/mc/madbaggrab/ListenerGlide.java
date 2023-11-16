package madmaxysoftware.mc.madbaggrab;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class ListenerGlide implements Listener {
    public MadBagGrab plugin;

    public ListenerGlide(MadBagGrab plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player)event.getEntity();
            if (plugin.IsBagRunner(player) && event.isGliding()) {
                event.setCancelled(true);
            }
        }
    }
}
