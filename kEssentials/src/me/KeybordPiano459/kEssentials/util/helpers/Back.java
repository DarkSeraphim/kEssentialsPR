package me.KeybordPiano459.kEssentials.util.helpers;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Back implements Listener
{

    public static HashMap<Player, Location> backloc = new HashMap<Player, Location>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        Location loc = player.getLocation();
        backloc.put(player, loc);
        if (player.hasPermission("kessentials.back"))
        {
            player.sendMessage(ChatColor.DARK_GRAY + "Type /back to go to where you died.");
        }
    }

    public static Location getBackLocation(Player player)
    {
        if (backloc.get(player) == null)
        {
            return null;
        }
        else
        {
            return backloc.get(player);
        }
    }
}
