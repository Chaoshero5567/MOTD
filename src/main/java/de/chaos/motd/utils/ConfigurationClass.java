package de.chaos.motd.utils;

public class ConfigurationClass {
    public static String WARTUNGPERMISSION = FileManager.getString("Wartung", "WartungPermission").replace("&", "§");
    public static String KICKMESSAGE = FileManager.getString("Wartung", "Kick-Measseage").replace("&", "§");
    public static String WARTUNG1 = FileManager.getString("Wartung", "Wartung-MOTD1").replace("&", "§");
    public static String WARTUNG2 = FileManager.getString("Wartung", "Wartung-MOTD2").replace("&", "§");
    public static Boolean WARTUNG = FileManager.getBoolean("Wartung", "Wartung");

    public static  String MOTD1 = FileManager.getString("Config", "MOTD1").replace("&", "§");
    public static String MOTD2 = FileManager.getString("Config", "MOTD2").replace("&", "§");
}
