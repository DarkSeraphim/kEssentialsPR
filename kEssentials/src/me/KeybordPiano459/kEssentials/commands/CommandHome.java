package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.config.PlayerConfig;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandHome extends kCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("home")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					FileConfiguration config = PlayerConfig.getPlayerConfig(player.getName());
					World world = Bukkit.getServer().getWorld(config.getString("home.world"));
					double x = config.getInt("home.x");
					double y = config.getInt("home.y");
					double z = config.getInt("home.z");
					float yaw = config.getInt("home.yaw");
					float pitch = config.getInt("home.pitch");
					Location home = new Location(world, x, y, z, yaw, pitch);
					player.teleport(home);
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
