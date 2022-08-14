package de.chaos.motd.listener;

import de.chaos.motd.utils.ConfigurationClass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class WartungJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (((Boolean)ConfigurationClass.WARTUNG).booleanValue() == true && !player.hasPermission(ConfigurationClass.WARTUNGPERMISSION)) {
            player.kickPlayer(ConfigurationClass.KICKMESSAGE);
        } return;
    }
}