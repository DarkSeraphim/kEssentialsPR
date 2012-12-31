package me.KeybordPiano459.kEssentials.commands;

import java.util.List;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class CommandButcher extends kCommand implements CommandExecutor {
    public CommandButcher(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("butcher")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.butcher")) {
                        int amount = 0;
                        List<Entity> entitylist = player.getNearbyEntities((double)100, (double)100, (double)100);
                        for (Entity entity : entitylist) {
                            if (entity instanceof Monster || entity instanceof Animals) {
                                amount++;
                                entity.remove();
                            }
                        }
                        player.sendMessage(GREEN + "" + amount + " mobs have been killed.");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/butcher");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}
