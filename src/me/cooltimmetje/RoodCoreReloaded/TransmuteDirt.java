package me.cooltimmetje.RoodCoreReloaded;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TransmuteDirt implements Listener {

	public static void openDirt(Player p){
		ItemStack pItemHand = p.getInventory().getItemInHand();
		Inventory dirt = Bukkit.createInventory(null, 9, "§9Transmute §8» §9Dirt");

		ItemStack dirtIS = new ItemStack(Material.DIRT);
		dirt.setItem(0, dirtIS);
		ItemStack grass = new ItemStack(Material.GRASS);
		dirt.setItem(1, grass);
		ItemStack sand = new ItemStack(Material.SAND);
		dirt.setItem(2, sand);
		
		ItemStack transItem = new ItemStack(pItemHand.getType(), pItemHand.getAmount(), (short)pItemHand.getDurability());
		ItemMeta transItemMeta = transItem.getItemMeta();
		transItemMeta.setDisplayName("§a§lTRANSMUTING:");
		ArrayList<String> transItemLore = new ArrayList<String>();
		transItemLore.add("§7Amount: §b" + pItemHand.getAmount());
		transItemMeta.setLore(transItemLore);
		transItem.setItemMeta(transItemMeta);
		dirt.setItem(8, transItem);	

		p.openInventory(dirt);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("transmute » dirt"))
			return;
		Player p = (Player) event.getWhoClicked();
		ItemStack pItemHand = p.getInventory().getItemInHand();
		event.setCancelled(true);

		if(event.getCurrentItem().hasItemMeta()){
			return;
		}
		
		if (event.getInventory().getName().equals(p.getInventory().getName())){
			return;
		}

		switch (event.getCurrentItem().getType()){
		case DIRT:
			p.getInventory().addItem(new ItemStack(Material.DIRT, pItemHand.getAmount()));
			p.getInventory().removeItem(new ItemStack(pItemHand.getType(), pItemHand.getAmount()));
			p.closeInventory();
			break;
		case GRASS:
			p.getInventory().addItem(new ItemStack(Material.GRASS, pItemHand.getAmount()));
			p.getInventory().removeItem(new ItemStack(pItemHand.getType(), pItemHand.getAmount()));
			p.closeInventory();
			break;
		case SAND:
			p.getInventory().addItem(new ItemStack(Material.SAND, pItemHand.getAmount()));
			p.getInventory().removeItem(new ItemStack(pItemHand.getType(), pItemHand.getAmount()));
			p.closeInventory();
			break;
		default:
			break;
		}

	}
	
}
