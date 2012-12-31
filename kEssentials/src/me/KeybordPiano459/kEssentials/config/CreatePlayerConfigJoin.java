package me.KeybordPiano459.kEssentials.config;

import me.KeybordPiano459.kEssentials.kEssentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CreatePlayerConfigJoin implements Listener
{

    kEssentials plugin;

    public CreatePlayerConfigJoin(kEssentials plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        final Player player = event.getPlayer();

        /*File playerConfig = new File(plugin.getDataFolder() + "playerdata" + File.separator + player.getName() + ".yml");
         if (!player.hasPlayedBefore() || !playerConfig.exists()) 
         {
         PlayerConfig PlayerConfig = new PlayerConfig(plugin);
         PlayerConfig.generatePlayerConfig(player.getName());
         }*/
    }
}