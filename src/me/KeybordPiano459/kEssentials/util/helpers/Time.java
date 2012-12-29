package me.KeybordPiano459.kEssentials.util.helpers;

import java.text.SimpleDateFormat;

import org.bukkit.World;

public class Time {
	public static String getDate() {
		Time date = new Time();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(date);
	}
	
	public static String getTime() {
		Time date = new Time();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		return format.format(date);
	}
	
	public static String getServerTime(World world) {
		return String.valueOf(world.getTime());
	}
}