package de.chaos.motd;

import de.chaos.motd.commands.MOTDCommand;
import de.chaos.motd.listener.MOTDListener;
import de.chaos.motd.listener.WartungJoinListener;
import de.chaos.motd.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MOTD extends JavaPlugin {

    public static MOTD plugin;
    public static FileManager fileManager;

    @Override
    public void onEnable() {
        plugin = this;
        fileManager = new FileManager();
        fileManager.configHandler();
        fileManager.defaultSetter();
         init();
    }

    public void init() {
        Bukkit.getPluginManager().registerEvents(new MOTDListener(), this);
        Bukkit.getPluginManager().registerEvents(new WartungJoinListener(), this);
        getCommand("motd").setExecutor(new MOTDCommand());
    }

    @Override
    public void onDisable() {
    }

    public static MOTD getPlugin() {
        return plugin;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }
}