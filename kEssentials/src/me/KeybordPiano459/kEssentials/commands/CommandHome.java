package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHome extends kCommand implements CommandExecutor {
    public CommandHome(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("home")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.home")) {
                        kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
                        World world = Bukkit.getServer().getWorld(kplayer.getPlayerConfig().getConfig().getString("home.world"));
                        double x = kplayer.getPlayerConfig().getConfig().getInt("home.x");
                        double y = kplayer.getPlayerConfig().getConfig().getInt("home.y");
                        double z = kplayer.getPlayerConfig().getConfig().getInt("home.z");
                        float yaw = kplayer.getPlayerConfig().getConfig().getInt("home.yaw");
                        float pitch = kplayer.getPlayerConfig().getConfig().getInt("home.pitch");
                        Location home = new Location(world, x, y, z, yaw, pitch);
                        player.teleport(home);
                        player.sendMessage(GREEN + "You have been sent home!");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/home");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}