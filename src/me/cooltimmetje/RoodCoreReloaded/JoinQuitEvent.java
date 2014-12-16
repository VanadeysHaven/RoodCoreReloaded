package me.cooltimmetje.RoodCoreReloaded;

import io.puharesource.mc.titlemanager.api.ActionbarTitleObject;
import io.puharesource.mc.titlemanager.api.TitleObject;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinQuitEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent event){
		Player p = event.getPlayer();
		new TitleObject("§6§lWelcome, §9" + p.getName(), "§6§lTo §c§lThe §4§lTeamR00D §c§lNetwork").setFadeIn(20).setStay(60).setFadeOut(20).send(p);
		
		for (Player pl : Bukkit.getOnlinePlayers()){
			new ActionbarTitleObject(p.getName() + " §ajoined! §b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)").send(pl);
		}
		
		event.setJoinMessage(Main.NoTag + p.getDisplayName() + " §ajoined! §b- §8(§6" + Bukkit.getOnlinePlayers().length + "§8/§6" + Bukkit.getMaxPlayers() + "§8)");
	}

}