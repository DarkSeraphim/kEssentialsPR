package me.KeybordPiano459.kEssentials.players;

import me.KeybordPiano459.kEssentials.config.PlayerConfig;
import me.KeybordPiano459.kEssentials.kEssentials;

public class kPlayer {

    String name;
    PlayerConfig pc;

    protected kPlayer(kEssentials plugin, String name) {
        this.name = name;
        this.pc = new PlayerConfig(plugin, name);
    }

    public PlayerConfig getPlayerConfig() {
        return this.pc;
    }
}