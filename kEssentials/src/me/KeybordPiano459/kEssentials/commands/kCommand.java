package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class kCommand
{

    public static void getCommands()
    {
        getCommand("back", new CommandBack());
        getCommand("butcher", new CommandButcher());
        getCommand("clearenderchest", new CommandClearenderchest());
        getCommand("clearinventory", new CommandClearinventory());
        getCommand("day", new CommandDay());
        getCommand("enderchest", new CommandEnderchest());
        getCommand("garbagecollector", new CommandGarbagecollector());
        getCommand("getid", new CommandGetid());
        getCommand("hat", new CommandHat());
        getCommand("ignite", new CommandIgnite());
        getCommand("itemname", new CommandItemname());
        getCommand("me", new CommandMe());
        getCommand("myhead", new CommandMyhead());
        getCommand("night", new CommandNight());
        getCommand("online", new CommandOnline());
        getCommand("ping", new CommandPing());
        getCommand("ram", new CommandRAM());
        getCommand("remove", new CommandRemove());
        getCommand("repair", new CommandRepair());
        getCommand("setwalkspeed", new CommandSetwalkspeed());
        getCommand("workbench", new CommandWorkbench());
        //getCommand("worldtime", new CommandWorldtime());
    }

    public static void getCommand(String command, CommandExecutor executor)
    {
        Bukkit.getServer().getPluginCommand(command).setExecutor(executor);
    }
    public static ChatColor DARK_GRAY = ChatColor.DARK_GRAY;
    public static ChatColor GREEN = ChatColor.GREEN;
    public static ChatColor RED = ChatColor.RED;
    public static ChatColor YELLOW = ChatColor.YELLOW;

    public static void consoleError()
    {
        Logger.getLogger("Minecraft").info("This command can't be used from console!");
    }

    public static void incorrectUsage(Player player, String usage)
    {
        player.sendMessage(RED + "Incorrect usage! Type " + usage);
    }

    public static void incorrectUsageC(String usage)
    {
        Logger.getLogger("Minecraft").info("Incorrect usage! Type " + usage);
    }

    public static void noPermissionsMessage(Player player)
    {
        player.sendMessage(RED + "You don't have permission to do that!");
    }
}