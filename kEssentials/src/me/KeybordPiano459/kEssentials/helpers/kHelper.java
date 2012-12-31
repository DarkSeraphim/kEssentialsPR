package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class kHelper {
    kEssentials plugin;
    public kHelper(kEssentials plugin) {
        this.plugin = plugin;
    }
    
    public void getHelpers()
    {
        getHelper(new Back(plugin));
        getHelper(new Backpack(plugin));
        getHelper(new EnderChest(plugin));
        getHelper(new MOTD(plugin));
        getHelper(new Mute(plugin));
        getHelper(new PlayerListener(plugin));
    }
    
    public void getHelper(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
