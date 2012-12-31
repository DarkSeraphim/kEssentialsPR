package me.KeybordPiano459.kEconomy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class kEconomy extends JavaPlugin {
    
    private static me.KeybordPiano459.kEssentials.kEssentials plugin;
    private static Plugin kEssentials = Bukkit.getServer().getPluginManager().getPlugin("kEssentials");
    public static double startingBalance = kEssentials.getConfig().getDouble("starting-balance");
    public static String currencySymbol = kEssentials.getConfig().getString("currency-symbol");
    public static boolean logging = kEssentials.getConfig().getBoolean("log-economy-data");
    
    public void onEnable() {
        if (kEssentials()) {
            getLogger().info("kEconomy v1.0 has been enabled!");
        } else {
            getLogger().warning("|----------------------------------------------|");
            getLogger().warning("|       Could not load kEconomy v1.0!!!        |");
            getLogger().warning("|    kEconomy is an add-on for kEssentials.    |");
            getLogger().warning("|      It can't load without it. Download      |");
            getLogger().warning("|     the newest version of kEssentials at     |");
            getLogger().warning(" http://dev.bukkit.org/server-mods/kEssentials/ ");
            getLogger().warning("|----------------------------------------------|");
            this.setEnabled(false);
        }
        
        Logging logging = new Logging(plugin);
        logging.createLog();
        
        getServer().getPluginCommand("money").setExecutor(new CommandMoney(this));
    }
    
    public void onDisable() {
        getLogger().info("kEconomy v1.0 has been disabled.");
    }
    
    public boolean kEssentials() {
        if (getServer().getPluginManager().getPlugin("kEssentials") != null) {
            return true;
        } else {
            return false;
        }
    }
}