package me.cooltimmetje.RoodCoreReloaded;

import io.puharesource.mc.titlemanager.api.TitleObject;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinQuitEvent implements Listener {

	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent event){
		Player p = event.getPlayer();
		new TitleObject("§6§lWelcome, " + p.getDisplayName(), TitleObject.TitleType.TITLE).setFadeIn(20).setStay(60).setFadeOut(20).send(p);
	}

}
