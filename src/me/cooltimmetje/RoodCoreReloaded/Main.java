package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{ //Extending JavaPlugin so that Bukkit knows its the main class...

	private static Plugin plugin;

	public void onEnable() {
		plugin = this;
		registerEvents(this, new XPStorage(), new TransmuteLog(), new TransmuteDirt(), new Drugs());
		getCommand("tp").setExecutor(new TPCommand());
		getCommand("silenttp").setExecutor(new TPCommand());
		getCommand("doomsday").setExecutor(new DoomsDay());
		getCommand("transmute").setExecutor(new Transmute());
		getServer().addRecipe(CustomRecipes.glowstoneDust);
		getServer().addRecipe(CustomRecipes.netherrack);
		getServer().addRecipe(CustomRecipes.netherQuarts);
		getServer().addRecipe(CustomRecipes.blazeRod);
		getServer().addRecipe(CustomRecipes.netherWart);
		getServer().addRecipe(CustomRecipes.energyDrink);
	}

	public void onDisable() {
		plugin = null;//To stop memory leeks
		getServer().resetRecipes();
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
	public static String NoTag = "§e>§6>§c> §a";
	public static String Error = "§c§lERROR §a";
	public static String CodeRood = "§8[§4§lCodeR00D§8] §a";
	public static String XpTag = "§8[§cXP§8] §a";
	public static String TransTag = "§8[§cTransmute§8] §a";
	public static String drugWarning = "§c§lWARNING §6This is a drug, take it on own risk.";
	public static String drugIRL = "§c§lWARNING §6Don't do drugs IRL. §oDrugs are bad, mkay?";


}

