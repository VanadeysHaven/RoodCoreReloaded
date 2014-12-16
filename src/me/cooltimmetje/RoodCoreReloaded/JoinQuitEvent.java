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
		new TitleObject("§6§lWelcome, " + p.getDisplayName(), TitleObject.TitleType.TITLE).setFadeIn(1).setStay(3).setFadeOut(1).send(p);
	}

}
