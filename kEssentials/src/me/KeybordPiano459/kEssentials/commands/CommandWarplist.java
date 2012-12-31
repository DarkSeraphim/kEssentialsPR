package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Warps;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandWarplist extends kCommand implements CommandExecutor {
    public CommandWarplist(kEssentials plugin) {
        super(plugin);
    }
    
    private Warps warps = new Warps(plugin);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warplist")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.warplist")) {
                        int amount = 0;
                        player.sendMessage("----- [" + GREEN + "Warps" + RESET + "] -----");
                        for (String warp : warps.getWarpsConfig().getConfigurationSection("warps.").getKeys(false)) {
                            amount++;
                            player.sendMessage(amount + ". " + GREEN + warp);
                        }
                        player.sendMessage("----- [" + GREEN + "Warps" + RESET + "] -----");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/warplist");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}