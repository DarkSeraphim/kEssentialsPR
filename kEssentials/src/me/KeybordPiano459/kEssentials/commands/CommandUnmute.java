package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUnmute extends kCommand implements CommandExecutor {
    public CommandUnmute(kEssentials plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("unmute")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (player.hasPermission("kessentials.unmute")) {
                        Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                        if (plugin.getPlayerManager().playerExists(args[0])) {
                            plugin.mute.setMute(player, false);
                            player.sendMessage(GREEN + "You have un-muted " + args[0] + "!");
                            if (tplayer != null) {
                                tplayer.sendMessage(DARK_GRAY + "You have been un-muted!");
                            }
                        } else {
                            player.sendMessage(RED + args[0] + " has never played on this server.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/unmute <player>");
                }
            } else {
                if (args.length == 1) {
                    Player player = Bukkit.getServer().getPlayer(args[0]);
                    plugin.mute.setMute(player, true);
                    Logger.getLogger("Minecraft").log(Level.INFO, "You have un-muted {0}", args[0]);
                    if (player != null) {
                        player.sendMessage(DARK_GRAY + "You have been un-muted!");
                    }
                } else {
                    incorrectUsageC("/unmute <player>");
                }
            }
        }
        return false;
    }
}