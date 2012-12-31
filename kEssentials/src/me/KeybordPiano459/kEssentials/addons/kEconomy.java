package me.KeybordPiano459.kEssentials.addons;

import org.bukkit.Bukkit;

public class kEconomy
{

    public void setupEconomy()
    {
        if (economyExists())
        {
            // add metrics plotter
        }
    }

    public boolean economyExists()
    {
        if (Bukkit.getServer().getPluginManager().getPlugin("kEconomy") != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
