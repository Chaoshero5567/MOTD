package de.chaos.motd.listener;

import de.chaos.motd.utils.ConfigurationClass;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTDListener implements Listener {
    @EventHandler
    public void onServerListPinging(ServerListPingEvent event) {
        if (((Boolean)ConfigurationClass.WARTUNG).booleanValue() == true) {
            event.setMotd(ConfigurationClass.WARTUNG1 + "\n" + ConfigurationClass.WARTUNG2);
        } else {
            event.setMotd(ConfigurationClass.MOTD1 + "\n" + ConfigurationClass.MOTD2);
        }
    }
}
