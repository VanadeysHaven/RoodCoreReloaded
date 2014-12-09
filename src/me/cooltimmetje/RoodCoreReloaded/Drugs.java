package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Drugs implements Listener {

	@EventHandler
	public void onItemInteract(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(p.getItemInHand().getType() == Material.ARROW){
			if(event.getAction() == Action.RIGHT_CLICK_AIR){
				if(p.getItemInHand().hasItemMeta() == true){
					event.setCancelled(true);
					if(!p.hasPotionEffect(PotionEffectType.SPEED)){
						if(!p.hasPotionEffect(PotionEffectType.CONFUSION)){
							p.sendMessage(Main.NoTag + "You feel a bit confused, but also very powerfull.");
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 2));
							p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 0));
							p.getInventory().removeItem(new ItemStack(CustomRecipes.heroine()));
							return;
						} else {
							p.sendMessage(Main.NoTag + "§bYou think by yourself: §a§oI'd better not take another shot, I'm sure it will harm me.");
							return;
						}
					} else {
						p.sendMessage(Main.NoTag + "§bYou think by yourself: §a§oI'd better not take another shot, I'm sure it will harm me.");
						return;
					}
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
	}
}


