package me.KeybordPiano459.kEssentials.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class kConfig
{

    kEssentials plugin;

    public kConfig(kEssentials plugin)
    {
        this.plugin = plugin;
        kConfigFile = new File(plugin.getDataFolder(), "config.yml");
        kConfigConfiguration = YamlConfiguration.loadConfiguration(kConfigFile);
    }
    public FileConfiguration kConfigConfiguration;
    public File kConfigFile;

    public void createConfig()
    {
        kConfigFile = new File(plugin.getDataFolder(), "config.yml");
        if (!kConfigFile.exists())
        {
            try
            {
                kConfigFile.createNewFile();
                generateConfig();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void generateConfig()
    {
        try
        {
            File configFile = new File(plugin.getDataFolder(), "config.yml");
            FileWriter w = new FileWriter(configFile);
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                kEssentials                 | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# Should players see the MOTD when they log in?");
            w(w, "motd-on-login: true\n");
            w(w, "\n\n");
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                   kChat                    | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# What color should an op's name be? Set to 'none' for no change");
            w(w, "op-name-color: '&c'\n");
            w(w, "# Should color symbols be allowed in the chat?");
            w(w, "colors-allowed-chat: true\n");
            w(w, "# How far away from the player should messages be \"heard\" from?");
            w(w, "# Set to 0 for infinite (vanilla minecraft)");
            w(w, "chat-radius: 100\n");
            w(w, "\n\n");
            w(w, "##################################################");
            w(w, "# +--------------------------------------------+ #");
            w(w, "# |                  kEconomy                  | #");
            w(w, "# +--------------------------------------------+ #");
            w(w, "##################################################");
            w(w, "");
            w(w, "# This is the amount of money that players start with");
            w(w, "starting-balance: 30\n");
            w(w, "# This is what will be displayed with money ($10)");
            w(w, "currency-symbol: '$'\n");
            w(w, "# Changes in players' money will be logged");
            w(w, "log-economy-data: true");
            w.close();
            reloadConfig();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void w(FileWriter writer, String string) throws IOException
    {
        writer.write(string + "\n");
    }

    public void reloadConfig()
    {
        if (!kConfigFile.exists())
        {
            kConfigFile = new File(plugin.getDataFolder(), "config.yml");
        }
        kConfigConfiguration = YamlConfiguration.loadConfiguration(kConfigFile);

        InputStream defConfigStream = plugin.getResource("config.yml");
        if (defConfigStream != null)
        {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            kConfigConfiguration.setDefaults(defConfig);
        }
    }

    public FileConfiguration getConfig()
    {
        if (kConfigConfiguration == null)
        {
            reloadConfig();
        }
        return kConfigConfiguration;
    }

    public void saveConfig()
    {
        if (kConfigConfiguration == null || kConfigFile == null)
        {
            return;
        }

        try
        {
            kConfigConfiguration.save(kConfigFile);
        }
        catch (IOException e)
        {
            Logger.getLogger("Minecraft").severe("Could not save the config file to the disk!");
        }
    }
}
