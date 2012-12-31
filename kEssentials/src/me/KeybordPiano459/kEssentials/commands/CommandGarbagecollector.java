package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.helpers.GarbageCollector;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGarbagecollector extends kCommand implements CommandExecutor {
    public CommandGarbagecollector(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("garbagecollector")) {
            GarbageCollector gc = new GarbageCollector();
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.garbagecollector")) {
                        if (gc.getMaxMemory() < 0L) {
                            player.sendMessage(RED + "You may be using CACAO Java. Please switch to another JVM.");
                            player.sendMessage(RED + "Some of these values may be negative.");
                        }
                        player.sendMessage(GREEN + "Used Memory Before: " + gc.getUsedMemoryBefore() + " MB");
                        player.sendMessage(GREEN + "Current Memory: " + gc.getCurrentMemory() + " MB");
                        player.sendMessage(GREEN + "Memory Freed: " + gc.getMemoryFreed() + " MB");
                        player.sendMessage(GREEN + "Processors Available: " + gc.getProcessors());
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/garbagecollector");
                }
            } else {
                Logger log = Logger.getLogger("Minecraft");
                if (args.length == 0) {
                    if (gc.getMaxMemory() < 0L) {
                        log.warning("You may be using CACAO Java. Please switch to another JVM.");
                        log.warning("Some of these values may be negative.");
                        log.info("");
                    }
                    log.log(Level.INFO, "Used Memory Before: {0} MB", gc.getUsedMemoryBefore());
                    log.log(Level.INFO, "Current Memory: {0} MB", gc.getCurrentMemory());
                    log.log(Level.INFO, "Memory Freed: {0} MB", gc.getMemoryFreed());
                    log.log(Level.INFO, "Processors Available: {0}", gc.getProcessors());
                } else {
                    incorrectUsageC("/garbagecollector");
                }
            }
        }
        return false;
    }
}