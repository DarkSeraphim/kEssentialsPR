package me.KeybordPiano459.kEssentials.helpers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Warps extends kHelper {
    public Warps(kEssentials plugin) {
        super(plugin);
    }
    
    private FileConfiguration warpsConfig = null;
    private File warpsConfigFile = null;
    
    public void generateWarpsConfig() {
        if (warpsConfigFile != null) {
            warpsConfigFile.delete();
        }
        
        reloadWarpsConfig();
    }
    
    public void reloadWarpsConfig() {
        if (warpsConfigFile == null) {
            warpsConfigFile = new File(plugin.getDataFolder(), "warps.yml");
        }
        warpsConfig = YamlConfiguration.loadConfiguration(warpsConfigFile);
        
        InputStream defConfigStream = plugin.getResource("warps.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            warpsConfig.setDefaults(defConfig);
        }
    }
    
    public FileConfiguration getWarpsConfig() {
        if (warpsConfig == null) {
            reloadWarpsConfig();
        }
        return warpsConfig;
    }
    
    public void saveWarpsConfig() {
        if (warpsConfig == null || warpsConfigFile == null) {
            return;
        }
        
        try {
            warpsConfig.save(warpsConfigFile);
        } catch (IOException e) {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not save the warps config to the disk!");
        }
    }
}