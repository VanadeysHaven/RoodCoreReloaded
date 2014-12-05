package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{ //Extending JavaPlugin so that Bukkit knows its the main class...

	private static Plugin plugin;

	public void onEnable() {
		plugin = this;
		registerEvents(this, new XPStorage());
		getCommand("tp").setExecutor(new TPCommand());
	}

	public void onDisable() {
		plugin = null;//To stop memory leeks

	}


	//Much eaisier then registering events in 10 diffirent methods
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}

	//To access the plugin variable from other classes
	public static Plugin getPlugin() {
		return plugin;
	}
	
	public static String TPTag = "§8[§cTP§8] §a";
	public static String NoTag = "§e>§6>§4> §a";
	public static String Error = "§c§lERROR §a";
	public static String CodeRood = "§8[§4§lCodeR00D§8] §a";
	public static String XpTag = "§8[§aXP§8] §a";


}

