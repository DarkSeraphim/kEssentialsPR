package me.KeybordPiano459.kEssentials.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnderChest implements Listener {
    static kEssentials plugin;
    public EnderChest(kEssentials plugin) {
        EnderChest.plugin = plugin;
    }
    
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        HumanEntity player = event.getPlayer();
        Inventory ninv = Bukkit.createInventory(player, 27, player.getName() + "'s EnderChest");
        if (event.getInventory() == ninv) {
            ItemStack[] contents = ninv.getContents();
            Inventory inv = player.getEnderChest();
            inv.setContents(contents);
        }
    }
}