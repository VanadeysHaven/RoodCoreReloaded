package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class XPStorage implements Listener {

	@EventHandler
	public void onItemInteract(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(p.getItemInHand().getType() == Material.GLASS_BOTTLE){
			if(event.getAction() == Action.RIGHT_CLICK_AIR){
				if(event.getPlayer().isSneaking() == true){
					event.setCancelled(true);
					if(p.getLevel() >= 1){
						p.getInventory().removeItem(new ItemStack(Material.GLASS_BOTTLE, 1));
						p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 1));
						p.sendMessage(Main.XpTag + "You putted a level in to the bottle.");
						p.setLevel(p.getLevel() - 1);
					} else {
						p.sendMessage(Main.XpTag + Main.Error + "You need atleast 1 level to store it.");
						return;
					}
				} else {
					return;
				}
			} else {
				return;
			}
		} else if (p.getItemInHand().getType() == Material.EXP_BOTTLE) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR){
				event.setCancelled(true);
				p.getInventory().removeItem(new ItemStack(Material.EXP_BOTTLE, 1));
				p.getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE, 1));
				p.sendMessage(Main.XpTag + "You took a level out of the bottle.");
				p.setLevel(p.getLevel() + 1);
			} else {
				return;
			}

		}

	}
}
