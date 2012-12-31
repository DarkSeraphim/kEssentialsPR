package me.KeybordPiano459.kEssentials.metrics;

import me.KeybordPiano459.kEssentials.metrics.BukkitMetrics.Graph;
import org.bukkit.Bukkit;

public class MetricsGraph {
    public void addAddonsGraph(BukkitMetrics metrics) {
        Graph graph = metrics.createGraph("Addons Used");
        graph.addPlotter(new BukkitMetrics.Plotter("kEconomy") {
            @Override
            public int getValue() {
                if (Bukkit.getServer().getPluginManager().getPlugin("kEconomg") != null) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}
