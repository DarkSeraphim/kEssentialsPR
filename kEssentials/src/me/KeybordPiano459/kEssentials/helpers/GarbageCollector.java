package me.KeybordPiano459.kEssentials.helpers;

public class GarbageCollector {
    public long getMaxMemory() {
        return Runtime.getRuntime().maxMemory() / 1048576L;
    }
    
    public long getOldMemory() {
        return Runtime.getRuntime().freeMemory() / 1048576L;
    }
    
    public long getNewMemory() {
        return Runtime.getRuntime().freeMemory() / 1048576L;
    }
    
    public long getUsedMemoryBefore() {
        return getMaxMemory() - getOldMemory();
    }
    
    public long getCurrentMemory() {
        return getMaxMemory() - getNewMemory();
    }
    
    public long getMemoryFreed() {
        return getNewMemory() - getOldMemory();
    }
    
    public int getProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}