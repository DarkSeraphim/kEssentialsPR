package me.KeybordPiano459.kEssentials;

import java.io.File;
import java.io.IOException;
import me.KeybordPiano459.kEssentials.commands.*;
import me.KeybordPiano459.kEssentials.config.*;
import me.KeybordPiano459.kEssentials.players.kPlayerManager;
import me.KeybordPiano459.kEssentials.util.*;
import me.KeybordPiano459.kEssentials.util.helpers.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class kEssentials extends JavaPlugin
{

    //private kConfig kConfig;
    public Mute mute;
    private FileConfiguration config;
    private kPlayerManager playerManager;

    @Override
    public void onEnable()
    {
        this.playerManager = new kPlayerManager(this);
        getLogger().info("kEssentials v1.0 has been enabled!");
        kCommand.getCommands();

        File folder = new File("plugins" + File.separator + "kEssentials");
        folder.mkdirs();

        MOTD motd = new MOTD(this);
        motd.createMOTD();

        kConfig theconfig = new kConfig(this);
        theconfig.createConfig();
        config = theconfig.getConfig();
        getConstructorClasses();

        try
        {
            BukkitMetrics metrics = new BukkitMetrics(this);
            metrics.start();
        }
        catch (IOException e)
        {
            // Failed to submit the stats :-(
        }
    }

    public void onDisable()
    {
        getLogger().info("kEssentials v1.0 has been disabled.");
    }

    public void getConstructorClasses()
    {
        registerListener(new Back());
        registerListener(new Backpack(this));
        if (config.getBoolean("motd-on-login"))
        {
            registerListener(new MOTD(this));
        }
        registerListener(new Mute(this));
        registerListener(new CreatePlayerConfigJoin(this));
        kCommand.getCommand("backpack", new CommandBackpack(this));
        kCommand.getCommand("home", new CommandHome(this));
        kCommand.getCommand("kessentials", new CommandKessentials(this));
        kCommand.getCommand("motd", new CommandMotd(this));
        kCommand.getCommand("mute", new CommandMute(this));
        kCommand.getCommand("sethome", new CommandSethome(this));
        kCommand.getCommand("spawner", new CommandSpawner(this));
        kCommand.getCommand("unmute", new CommandUnmute(this));
    }

    public void registerListener(Listener listener)
    {
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
    }

    public kPlayerManager getPlayerManager()
    {
        return this.playerManager;
    }
}