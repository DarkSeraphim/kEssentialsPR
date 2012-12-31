package me.KeybordPiano459.kEssentials.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerConfig {

    kEssentials plugin;
    String player;

    public PlayerConfig(kEssentials plugin, String name) {
        this.plugin = plugin;
        this.player = name;
    }
    public FileConfiguration customConfig = null;
    public File customConfigFile = null;

    public boolean hasPlayerConfig(String player) {
        File file = new File(this.plugin.getDataFolder(), "playerdata" + File.separator + player + ".yml");
        return file.isFile() && file.exists();
    }

    public void resetPlayerConfig() {
        if (customConfigFile != null) {
            customConfigFile.delete();
        }

        reloadPlayerConfig();
        this.customConfig.set("muted", false);
        this.customConfig.set("backpack", "54;");
        //getPlayerConfig(player).set("money", kConfig.getConfig().getDouble("starting-balance"));
        savePlayerConfig();
    }

    public void reloadPlayerConfig() {
        if (customConfigFile == null) {
            customConfigFile = new File(plugin.getDataFolder(), "playerdata" + File.separator + player + ".yml");
        }
        customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
        customConfig.options().copyDefaults(true);
        
        InputStream defConfigStream = plugin.getResource("player.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            customConfig.setDefaults(defConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (customConfig == null) {
            reloadPlayerConfig();
        }
        return customConfig;
    }

    public void savePlayerConfig() {
        if (customConfig == null || customConfigFile == null) {
            return;
        }

        try {
            customConfig.save(customConfigFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save {0}''s config to the disk!", player);
        }
    }
}