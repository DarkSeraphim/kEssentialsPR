package me.KeybordPiano459.kEssentials.util.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class kHelper
{

    static kEssentials plugin;

    public kHelper(kEssentials plugin)
    {
        kHelper.plugin = plugin;
    }

    public static void getHelpers()
    {
        getHelper(new Back());
    }

    public static void getHelper(Listener listener)
    {
        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
