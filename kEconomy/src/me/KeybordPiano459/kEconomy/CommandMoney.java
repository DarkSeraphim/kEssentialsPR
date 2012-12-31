package me.KeybordPiano459.kEconomy;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMoney implements CommandExecutor {
    kEconomy plugin;
    public CommandMoney(kEconomy plugin) {
        this.plugin = plugin;
    }
    
    ChatColor DARK_GREEN = ChatColor.DARK_GREEN;
    ChatColor GREEN = ChatColor.GREEN;
    ChatColor RED = ChatColor.RED;
    ChatColor RESET = ChatColor.RESET;
    private Money money;
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("money")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("keconomy.money.view")) {
                        player.sendMessage(GREEN + "You currently have " + kEconomy.currencySymbol + money.getMoney(player.getName()));
                    }
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("give")) {
                        if (player.hasPermission("keconomy.money.give")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [give] [name] [amount]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage("----- [" + DARK_GREEN + "kEconomy" + RESET + "] -----");
                        if(player.hasPermission("keconomy.money.view")){player.sendMessage(GREEN + "/money - Check Your Current Balance");}
                        if(player.hasPermission("keconomy.money.give")){player.sendMessage(GREEN+"/money [give] [player] [amount] - Give a Player Money");}
                        player.sendMessage(GREEN + "/money [help] - View this Screen");
                        if(player.hasPermission("keconomy.money.pay")){player.sendMessage(GREEN + "/money [pay] [player] [amount] - Pay Someone Money");}
                        if(player.hasPermission("keconomy.money.take")){player.sendMessage(GREEN+"/money [take] [player] [amount] - Take Money From a Player");}
                        if(player.hasPermission("keconomy.money.view.others")){player.sendMessage(GREEN + "/money [view] [player] - View Another Player's Balance");}
                    } else if (args[0].equalsIgnoreCase("pay")) {
                        if (player.hasPermission("keconomy.money.pay")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [pay] [player] [amount]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("take")) {
                        if (player.hasPermission("keconomy.money.take")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [take] [player] [amount]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("view")) {
                        if (player.hasPermission("keconomy.money.view.others")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [view] [player]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else {
                        player.sendMessage(RED + "Incorrect usage!");
                        player.sendMessage(GREEN + "/money [help]");
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("give")) {
                        if (player.hasPermission("keconomy.money.give")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [give] [player] [amount]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("pay")) {
                        if (player.hasPermission("keconomy.money.pay")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [pay] [player] [amount]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("take")) {
                        if (player.hasPermission("keconomy.money.take")) {
                            player.sendMessage(RED + "Incorrect usage!");
                            player.sendMessage(GREEN + "/money [take] [player] [amount]");
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("view")) {
                        if (player.hasPermission("keconomy.money.view.others")) {
                            if (sender.getServer().getPlayer(args[1]) != null) {
                                Player targetplayer = sender.getServer().getPlayer(args[1]);
                                double amount = money.getMoney(targetplayer.getName());
                                player.sendMessage(GREEN + targetplayer.getName() + " has " + kEconomy.currencySymbol + amount);
                            } else {
                                player.sendMessage(RED + args[1] + " doesn't have a kEconomy balance.");
                            }
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else {
                        player.sendMessage(RED + "Incorrect usage!");
                        player.sendMessage(GREEN + "/money [help]");
                    }
                } else if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("give")) {
                        if (player.hasPermission("keconomy.money.give")) {
                            Player targetplayer = sender.getServer().getPlayer(args[1]);
                            if (money.hasAccount(args[1])) {
                                money.addMoney(targetplayer.getName(), Double.valueOf(args[2]));
                                if (targetplayer.getName().equals(player.getName())) {
                                    player.sendMessage(GREEN + "You have given yourself $" + args[2]);
                                } else {
                                    player.sendMessage(GREEN + "You have given " + targetplayer.getName() + " $" + args[2]);
                                    if (sender.getServer().getPlayer(args[1]) != null) {
                                        targetplayer.sendMessage(GREEN + player.getName() + " has given you $" + args[2]);
                                    }
                                }
                            } else {
                                player.sendMessage(RED + args[1] + " doesn't have a kEconomy balance.");
                            }
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("pay")) {
                        if (player.hasPermission("keconomy.money.pay")) {
                            Player targetplayer = sender.getServer().getPlayer(args[1]);
                            if (money.hasAccount(args[1])) {
                                money.subtractMoney(player.getName(), Double.valueOf(args[2]));
                                money.addMoney(targetplayer.getName(), Double.valueOf(args[2]));
                                player.sendMessage(GREEN + "You have paid " + targetplayer.getName() + " $" + args[2]);
                                if (sender.getServer().getPlayer(args[1]) != null) {
                                    targetplayer.sendMessage(GREEN + "You have recieved $" + args[2] + " from " + player.getName());
                                }
                            } else {
                                player.sendMessage(RED + args[1] + " doesn't have a kEconomy balance.");
                            }
                        } else {
                            player.sendMessage(RED + "You don't have permission!");
                            player.sendMessage(GREEN + "/money [help]");
                        }
                    } else if (args[0].equalsIgnoreCase("take")) {
                        if (player.hasPermission("keconomy.money.take")) {
                            Player targetplayer = sender.getServer().getPlayer(args[1]);
                            if (money.hasAccount(args[1])) {
                                money.subtractMoney(targetplayer.getName(), Double.valueOf(args[2]));
                                player.sendMessage(GREEN + "You have taken $" + args[2] + " from " + targetplayer.getName());
                                if (sender.getServer().getPlayer(args[1]) != null) {
                                    targetplayer.sendMessage(GREEN + player.getName() + " has taken $" + args[2] + " from you.");
                                }
                            } else {
                                player.sendMessage(RED + args[1] + " doesn't have a kEconomy balance.");
                            }
                        }
                    } else {
                        player.sendMessage(RED + "Incorrect usage!");
                        player.sendMessage(GREEN + "/money [help]");
                    }
                } else {
                    player.sendMessage(RED + "Incorrect usage!");
                    player.sendMessage(GREEN + "/money [help]");
                }
            } else {
                Logger log = Logger.getLogger("Minecraft");
                if (args.length == 0) {
                    log.info("----- [kEconomy] -----");
                    log.info("money [help] - View this Screen");
                    log.info("money [give] [player] [amount]");
                    log.info("money [take] [player] [amount]");
                    log.info("money [view] [player]");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("give")) {
                        log.info("Incorrect usage!");
                        log.info("money [give] [player] [amount]");
                    } else if (args[0].equalsIgnoreCase("help")) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "money");
                    } else if (args[0].equalsIgnoreCase("take")) {
                        log.info("Incorrect usage!");
                        log.info("money [take] [player] [amount]");
                    } else if (args[0].equalsIgnoreCase("view")) {
                        log.info("Incorrect usage!");
                        log.info("money [view] [player]");
                    } else {
                        log.info("Incorrect usage!");
                        log.info("money [help]");
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("give")) {
                        log.info("Incorrect usage!");
                        log.info("money [give] [player] [amount]");
                    } else if (args[0].equalsIgnoreCase("take")) {
                        log.info("Incorrect usage!");
                        log.info("money [take] [player] [amount]");
                    } else if (args[0].equalsIgnoreCase("view")) {
                        if (sender.getServer().getPlayer(args[1]) != null) {
                            Player targetplayer = sender.getServer().getPlayer(args[1]);
                            double amount = money.getMoney(targetplayer.getName());
                            log.log(Level.INFO, "[kEconomy] {0} has ${1}", new Object[]{targetplayer.getName(), amount});
                        } else {
                            log.log(Level.INFO, "[kEconomy] {0} doesn''t have a kEconomy balance.", args[1]);
                        }
                    } else {
                        log.info("Incorrect usage!");
                        log.info("money [help]");
                    }
                } else if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("give")) {
                        Player targetplayer = sender.getServer().getPlayer(args[1]);
                        if (money.hasAccount(args[1])) {
                            money.addMoney(targetplayer.getName(), Double.valueOf(args[2]));
                            log.log(Level.INFO, "[kEconomy] You have given {0} ${1}", new Object[]{args[1], args[2]});
                            if (sender.getServer().getPlayer(targetplayer.getName()) != null) {
                                targetplayer.sendMessage(GREEN + "You have been given $" + args[2] + " from console.");
                            }
                        } else {
                            log.log(Level.INFO, "[kEconomy] {0} does not have a kEconomy balance.", args[1]);
                        }
                    } else if (args[0].equalsIgnoreCase("take")) {
                        Player targetplayer = sender.getServer().getPlayer(args[1]);
                        if (money.hasAccount(args[1])) {
                            money.subtractMoney(targetplayer.getName(), Double.valueOf(args[2]));
                            log.log(Level.INFO, "[kEconomy] You have taken ${0} from {1}", new Object[]{args[2], args[1]});
                            if (sender.getServer().getPlayer(targetplayer.getName()) != null) {
                                targetplayer.sendMessage(GREEN + "Console has taken $" + args[2] + " from you.");
                            }
                        } else {
                            log.log(Level.INFO, "[kEconomy] {0} does not have a kEconomy balance.", args[1]);
                        }
                    } else {
                        log.info("Incorrect usage!");
                        log.info("money [help]");
                    }
                } else {
                    log.info("Incorrect usage!");
                    log.info("money [help]");
                }
            }
        }
        return false;
    }
}