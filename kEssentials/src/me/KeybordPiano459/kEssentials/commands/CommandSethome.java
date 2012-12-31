package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSethome extends kCommand implements CommandExecutor {
    public CommandSethome(kEssentials plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sethome")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.sethome")) {
                        kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
                        Location loc = player.getLocation();
                        kplayer.getPlayerConfig().getConfig().set("home.world", loc.getWorld().getName());
                        kplayer.getPlayerConfig().getConfig().set("home.x", loc.getX());
                        kplayer.getPlayerConfig().getConfig().set("home.y", loc.getY());
                        kplayer.getPlayerConfig().getConfig().set("home.z", loc.getZ());
                        kplayer.getPlayerConfig().getConfig().set("home.yaw", loc.getYaw());
                        kplayer.getPlayerConfig().getConfig().set("home.pitch", loc.getPitch());
                        player.sendMessage(GREEN + "Your home has been set!");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/sethome");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}