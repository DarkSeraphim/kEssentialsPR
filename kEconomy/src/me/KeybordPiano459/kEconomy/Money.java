package me.KeybordPiano459.kEconomy;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.configuration.file.FileConfiguration;

public class Money {
    
    private boolean logging = kEconomy.logging;
    private String name;
    private kEssentials kessentials;
    private FileConfiguration pconfig = kessentials.getPlayerManager().getPlayer(name).getPlayerConfig().getConfig();
    
    public Double getMoney(String player) {
        name = player;
        return pconfig.getDouble("money");
    }
    
    public void setMoney(String player, double amount) {
        name = player;
        pconfig.set("money", amount);
    }
    
    public void addMoney(String player, double amount) {
        double was = pconfig.getDouble("money");
        double now = was + amount;
        pconfig.set("money", now);
    }
    
    public void subtractMoney(String player, double amount) {
        if (hasMoney(player)) {
            double was = getMoney(player);
            double now = was - amount;
            pconfig.set("money", now);
        } else {
            setMoney(player, 0);
        }
    }
    
    public boolean hasMoney(String player) {
        if (getMoney(player) > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean hasAccount(String player) {
        if (pconfig != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void createAccount(String player) {
        if (!hasAccount(player)) {
            pconfig.set("money", kEconomy.startingBalance);
        }
    }
    
    public void removeMoney(String player) {
        if (hasAccount(player)) {
            setMoney(player, 0);
        } else {
            System.out.println(player + " doesn't have an account!");
        }
    }
}