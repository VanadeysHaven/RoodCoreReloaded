package me.cooltimmetje.RoodCoreReloaded;

import io.puharesource.mc.titlemanager.api.TabTitleObject;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{ //Extending JavaPlugin so that Bukkit knows its the main class...
	private static Plugin plugin;

	public void onEnable() {
		plugin = this;
		
		getLogger().info("[RCR] Registering Events...");
		registerEvents(this, new XPStorage(), new TransmuteLog(), new TransmuteDirt(), new Drugs(), new JoinQuitEvent());
		
		getLogger().info("[RCR] Registering Commands...");
		getCommand("tp").setExecutor(new TPCommand());
		getCommand("silenttp").setExecutor(new TPCommand());
		getCommand("doomsday").setExecutor(new DoomsDay());
		getCommand("transmute").setExecutor(new Transmute());
		getCommand("swaggergear").setExecutor(new SwagGear());
		getCommand("ci").setExecutor(new BetterClearInventory());
		
		getLogger().info("[RCR] Adding recipes...");
		getServer().addRecipe(CustomRecipes.glowstoneDust);
		getServer().addRecipe(CustomRecipes.netherrack);
		getServer().addRecipe(CustomRecipes.netherQuarts);
		getServer().addRecipe(CustomRecipes.blazeRod);
		getServer().addRecipe(CustomRecipes.netherWart);
		getServer().addRecipe(CustomRecipes.energyDrink);
		getServer().addRecipe(CustomRecipes.heroine);
		getServer().addRecipe(CustomRecipes.cocaine);
		
		getLogger().info("[RCR] Hooking into APIs...");
		if (getServer().getPluginManager().getPlugin("TitleManager") != null && getServer().getPluginManager().getPlugin("TitleManager").isEnabled())
		    getLogger().info("[RCR] Successfully hooked into TitleManager!");
		  else {
		    getLogger().warning("[RCR] Failed to hook into TitleManager, disabling plugin!");
		    getPluginLoader().disablePlugin(this);
		  }
		
		getLogger().info("[RCR] Setting up tab list.");
		setTablist();

		getLogger().info("[RCR] Plugin enabled!");
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
	public static String CodeRood = "§8[§4CodeR00D§8] §a";
	public static String XpTag = "§8[§cXP§8] §a";
	public static String CiTag = "§8[§cClear Inventory§8] §a";
	public static String TransTag = "§8[§cTransmute§8] §a";
	public static String drugWarning = "§c§lWARNING §6This is a drug, take it on own risk.";
	public static String drugIRL = "§6Don't do drugs IRL. §oDrugs are bad, mkay?";
	public static String drugHarm = "§bYou think by yourself: §a§oI'd better not take another shot, I'm sure it will harm me.";
	public static String noPerm = "You do not have access to this command.";
	public static String tabHead = "§aWelcome to §cThe §4#TeamR00D §cNetwork";
	
	
	@SuppressWarnings("deprecation")
	public static void setTablist(){
		for (Player pl : Bukkit.getOnlinePlayers()){
			new TabTitleObject(tabHead, pl.getDisplayName() +  " §b- §8(§6" +  Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)" ).send(pl);
		}
	}

}

