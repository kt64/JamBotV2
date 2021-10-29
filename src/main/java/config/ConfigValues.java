package config;

public class ConfigValues {

    public static String DISCORD_TOKEN;

    public static void loadValues(){
        DISCORD_TOKEN = ConfigManager.getKeys("DISCORD_TOKEN");
    }
}
