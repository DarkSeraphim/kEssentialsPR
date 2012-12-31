package me.KeybordPiano459.kEconomy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.event.Listener;

public class Logging implements Listener {
    static kEssentials plugin;
    public Logging(kEssentials plugin) {
        Logging.plugin = plugin;
    }
    
    private static File logFile = null;
    
    public void createLog() {
        if (logFile == null) {
            logFile = new File(plugin.getDataFolder(), "keconomy.log");
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void logToFile(String string) {
        try {
            FileWriter writer = new FileWriter(logFile);
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}