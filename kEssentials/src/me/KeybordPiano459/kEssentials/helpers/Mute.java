package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Mute implements Listener {
    kEssentials plugin;
    public Mute(kEssentials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (getMute(player)) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You are mute!");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            setMute(player, false);
        }
    }

    public boolean getMute(Player player) {
        kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
        return kplayer.getPlayerConfig().getConfig().getBoolean("muted");
    }

    public void setMute(Player player, Boolean mute) {
        kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
        kplayer.getPlayerConfig().getConfig().set("muted", mute);
        kplayer.getPlayerConfig().savePlayerConfig();
    }
}