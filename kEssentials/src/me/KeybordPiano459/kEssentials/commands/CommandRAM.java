package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.helpers.RAM;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRam extends kCommand implements CommandExecutor {
    public CommandRam(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ram")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.ram")) {
                        player.sendMessage(GREEN + "Free RAM: " + RAM.getFreeRAM() + " MB");
                        player.sendMessage(GREEN + "Max RAM: " + RAM.getMaxRAM() + " MB");
                        player.sendMessage(GREEN + "Used RAM: " + RAM.getUsedRAM() + " MB");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/ram");
                }
            } else {
                if (args.length == 0) {
                    Logger log = Logger.getLogger("Minecraft");
                    log.log(Level.INFO, "Free RAM: {0} MB", RAM.getFreeRAM());
                    log.log(Level.INFO, "Max RAM: {0} MB", RAM.getMaxRAM());
                    log.log(Level.INFO, "Used RAM: {0} MB", RAM.getUsedRAM());
                } else {
                    incorrectUsageC("/ram");
                }
            }
        }
        return false;
    }
}