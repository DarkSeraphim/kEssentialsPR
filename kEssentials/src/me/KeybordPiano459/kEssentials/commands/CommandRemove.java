package me.KeybordPiano459.kEssentials.commands;

import java.util.List;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class CommandRemove extends kCommand implements CommandExecutor {
    public CommandRemove(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("remove")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 2) {
                    if (player.hasPermission("kessentials.remove")) {
                        double radius = 0;
                        try {
                            radius = Integer.parseInt(args[1]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(RED + "That is not a valid radius!");
                            return false;
                        }
                        
                        int amount = 0;
                        List<Entity> entities = player.getNearbyEntities(radius, radius, radius);
                        if (args[0].equalsIgnoreCase("all")) {
                            for (Entity entity : entities) {
                                entity.remove();
                                amount++;
                            }
                            player.sendMessage(GREEN + "" + amount + " entities have been removed.");
                        } else if (args[0].equalsIgnoreCase("arrow") || args[0].equalsIgnoreCase("arrows")) {
                            for (Entity entity : entities) {
                                if (entity instanceof Arrow) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("boat") || args[0].equalsIgnoreCase("boats")) {
                            for (Entity entity : entities) {
                                if (entity instanceof Boat) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("item") || args[0].equalsIgnoreCase("items")) {
                            for (Entity entity : entities) {
                                if (entity instanceof Item) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("itemframe") || args[0].equalsIgnoreCase("itemframes")) {
                            for (Entity entity : entities) {
                                if (entity instanceof ItemFrame) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("minecart") || args[0].equalsIgnoreCase("minecarts")) {
                            for (Entity entity : entities) {
                                if (entity instanceof Minecart) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("painting") || args[0].equalsIgnoreCase("paintings")) {
                            for (Entity entity : entities) {
                                if (entity instanceof Painting) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("primedtnt")) {
                            for (Entity entity : entities) {
                                if (entity instanceof TNTPrimed) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else if (args[0].equalsIgnoreCase("xp")) {
                            for (Entity entity : entities) {
                                if (entity instanceof ExperienceOrb) {
                                    entity.remove();
                                    amount++;
                                }
                            }
                            successMessage(amount, args, player);
                        } else {
                            player.sendMessage(RED + "That is not a valid entity type.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/remove <all|arrow|boat|item|minecart|painting|primedtnt|xp> <radius>");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
    
    public void successMessage(int amount, String[] args, Player player) {
        player.sendMessage(GREEN + "" + amount + " " + args[0].toLowerCase() + "s have been removed.");
    }
}