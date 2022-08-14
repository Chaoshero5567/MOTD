package de.chaos.motd.utils;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {
        private static File folder = new File("plugins/MOTD");

        public static File con = new File("plugins/MOTD", "config.yml");

        public static FileConfiguration configuration = (FileConfiguration) YamlConfiguration.loadConfiguration(con);


        public static String WARTUNGSSECTION = "Wartung";
        public static String CONFIGSECTION = "Config";

        public static void configHandler() {
            if (!folder.exists())
                folder.mkdir();
            if (!con.exists())
                try {
                    con.createNewFile();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        }

        public static void defaultSetter() {
            String WartungMOTD1 = configuration.getString("Wartung:Wartung-MOTD1");
            String WartungMOTD2 = configuration.getString("Wartung:Wartung-MOTD2");
            String WartungPermission = configuration.getString("Wartung:Permission");
            String KickMeasseage = configuration.getString("Wartung:Kick-Measseage");
            Boolean Wartung = configuration.getBoolean("Wartung:Wartung");
            configuration.options().copyDefaults(true);
            if (configuration.getConfigurationSection(WARTUNGSSECTION) == null) {
                configuration.createSection(WARTUNGSSECTION).getDefaultSection();
                {
                    if (Wartung == null) {
                        configuration.getConfigurationSection(WARTUNGSSECTION).addDefault("Wartung", false);
                    }

                    if (configuration.getString("Wartung:Wartung-MOTD1") == null) {
                        configuration.getConfigurationSection(WARTUNGSSECTION).addDefault("Wartung-MOTD1", "DeinServer.de");
                    }
                    if (configuration.getString("Wartung:Wartung-MOTD2") == null) {
                        configuration.getConfigurationSection(WARTUNGSSECTION).addDefault("Wartung-MOTD2", "Bald wieder da!");
                    }
                    if (configuration.getString("Wartung:Permission") == null) {
                        configuration.getConfigurationSection(WARTUNGSSECTION).addDefault("WartungPermission", "motd.Wartung");
                    }
                    if (configuration.getString("Wartung:Kick-Measseage") == null) {
                        configuration.getConfigurationSection(WARTUNGSSECTION).addDefault("Kick-Measseage", "Du kannst während der Wartung nicht joinen");
                    }
                }
            }
            String MOTD1 = configuration.getString("Config:MOTD1");
            String MOTD2 = configuration.getString("Config:MOTD2");

            if (configuration.getConfigurationSection(CONFIGSECTION) == null) {
                configuration.createSection(CONFIGSECTION).getDefaultSection();
                {
                    if (MOTD1 == null) {
                        configuration.getConfigurationSection(CONFIGSECTION).addDefault("MOTD1", "&6Zeile1");
                    }
                    if (MOTD2 == null) {
                        configuration.getConfigurationSection(CONFIGSECTION).addDefault("MOTD2", "&6Zeile2");

                    }
                }
            }
            configuration.options().copyDefaults(true);
            saveCon();
        }

        public static void setString(String section, String key, String value) {
            configuration.getConfigurationSection(section).set(key, value);
            saveCon();
        }

        public static String getString(String section, String key) {
            String CONFIG = configuration.getConfigurationSection(section).getString(key);
            return CONFIG;
        }

        public static void setInt(String section, String key, String value) {
            configuration.getConfigurationSection(section).set(key, value);
            saveCon();
        }

        public static int getInt(String section, String key) {
            int i = configuration.getConfigurationSection(section).getInt(key);
            return i;
        }

        public static void setBoolen(String section, String key, Boolean value) {
        }

        public static boolean getBoolean(String section, String key) {
            boolean bool = configuration.getConfigurationSection(section).getBoolean(key);
            return bool;
        }

        public static void saveCon() {
            try {
                configuration.save(con);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
