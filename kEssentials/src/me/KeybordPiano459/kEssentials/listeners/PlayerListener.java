package me.KeybordPiano459.kEssentials.listeners;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author s129977
 */
public class PlayerListener implements Listener
{
    
    private kEssentials plugin;
    
    public PlayerListener(kEssentials plugin)
    {
        this.plugin = plugin;
    }
    
    @EventHandler(priority=EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event)
    {
        // Gets and creates the file (if not existant)
        Player player = event.getPlayer();
        kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
        kplayer.getPlayerConfig().reloadPlayerConfig();
        kplayer.getPlayerConfig().savePlayerConfig();
    }

}
