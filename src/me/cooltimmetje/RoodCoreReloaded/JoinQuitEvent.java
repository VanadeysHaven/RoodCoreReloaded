package me.cooltimmetje.RoodCoreReloaded;

import io.puharesource.mc.titlemanager.api.ActionbarTitleObject;
import io.puharesource.mc.titlemanager.api.TabTitleObject;
import io.puharesource.mc.titlemanager.api.TitleObject;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent event){
		Player p = event.getPlayer();
		new TitleObject("§6Welcome, §9" + p.getName(), "§6To §cThe §4#TeamR00D §cNetwork").setFadeIn(20).setStay(60).setFadeOut(20).send(p);
		
		for (Player pl : Bukkit.getOnlinePlayers()){
			new ActionbarTitleObject("§9" + p.getName() + " §ajoined! §b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)").send(pl);
			new TabTitleObject("§aWelcome to §cThe §4#TeamR00D §cNetwork", pl.getDisplayName() +  "§b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8" ).send(pl);
		}
		event.setJoinMessage(Main.NoTag + p.getDisplayName() + " §ajoined! §b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		Player p = event.getPlayer();
		
		for (Player pl : Bukkit.getOnlinePlayers()){
			new ActionbarTitleObject("§9" + p.getName() + " §aleft! §b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)").send(pl);
			int online = Bukkit.getOnlinePlayers().length - 1;
			new TabTitleObject("§aWelcome to §cThe §4#TeamR00D §cNetwork", pl.getDisplayName() +  "§b- §8(§6" + online + "§8/§6" + Bukkit.getMaxPlayers() + "§8" ).send(pl);
		}
		event.setQuitMessage(Main.NoTag + p.getDisplayName() + " §aleft! §b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)");
	}
	
}