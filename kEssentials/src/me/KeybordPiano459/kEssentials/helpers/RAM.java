package me.KeybordPiano459.kEssentials.helpers;

public class RAM {
    public static double getFreeRAM() {
        return Math.floor(Runtime.getRuntime().freeMemory() / 1024L / 1024L);
    }
    
    public static double getMaxRAM() {
        return Math.floor(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
    }
    
    public static double getUsedRAM() {
        return getMaxRAM() - getFreeRAM();
    }
}