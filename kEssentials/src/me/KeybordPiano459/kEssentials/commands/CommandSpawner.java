package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandSpawner extends kCommand implements CommandExecutor {
    public CommandSpawner(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawner")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (player.hasPermission("kessentials.spawner")) {
                        try {
                            final EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                            final Block block = player.getTargetBlock(null, 50);
                            Material type = block.getType();
                            if (type == Material.MOB_SPAWNER) {
                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                        @Override
                                        public void run() {
                                            ((CreatureSpawner)block.getState()).setSpawnedType(entity);
                                        }
                                    }, 1);
                                    player.sendMessage(GREEN + "That is now a " + YELLOW + entity.getName().toLowerCase() + GREEN + " spawner.");
                            } else {
                                player.sendMessage(RED + "You need to be looking at a mob spawner.");
                            }
                        } catch (IllegalArgumentException e) {
                            player.sendMessage(RED + "That is not a valid mob type.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/spawner <type>");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}