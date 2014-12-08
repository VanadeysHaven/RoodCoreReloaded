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

public class TransmuteLog implements Listener {

	public static void openLog(Player p){
		ItemStack pItemHand = p.getInventory().getItemInHand();
		Inventory log = Bukkit.createInventory(null, 9, "§9Transmute §8» §9Log");

		ItemStack oakLog = new ItemStack(Material.LOG, 1, (byte)0);
		log.setItem(0, oakLog);
		ItemStack spruceLog = new ItemStack(Material.LOG, 1, (byte)1);
		log.setItem(1, spruceLog);
		ItemStack birchLog = new ItemStack(Material.LOG, 1, (byte)2);
		log.setItem(2, birchLog);
		ItemStack jungleLog = new ItemStack(Material.LOG, 1, (byte)3);
		log.setItem(3, jungleLog);
		ItemStack acaciaLog = new ItemStack(Material.LOG_2, 1, (byte)0);
		log.setItem(4, acaciaLog);
		ItemStack darkOakLog = new ItemStack(Material.LOG_2, 1, (byte)1);
		log.setItem(5, darkOakLog);

		ItemStack transItem = new ItemStack(pItemHand.getType(), pItemHand.getAmount(), (short)pItemHand.getDurability());
		ItemMeta transItemMeta = transItem.getItemMeta();
		transItemMeta.setDisplayName("§a§lTRANSMUTING:");
		ArrayList<String> transItemLore = new ArrayList<String>();
		transItemLore.add("§7Amount: §b" + pItemHand.getAmount());
		transItemMeta.setLore(transItemLore);
		transItem.setItemMeta(transItemMeta);
		log.setItem(8, transItem);	

		p.openInventory(log);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("transmute » log"))
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
		case LOG:
			p.getInventory().addItem(new ItemStack(Material.LOG, pItemHand.getAmount(), (short)event.getCurrentItem().getDurability()));
			p.getInventory().remove(new ItemStack(pItemHand.getType(), pItemHand.getAmount(), (short)pItemHand.getDurability()));
			p.closeInventory();
			break;
		case LOG_2:
			p.getInventory().addItem(new ItemStack(Material.LOG_2, pItemHand.getAmount(), (short)event.getCurrentItem().getDurability()));
			p.getInventory().remove(new ItemStack(pItemHand.getType(), pItemHand.getAmount(), (short)pItemHand.getDurability()));
			p.closeInventory();
		default:
			break;
		}

	}

}
