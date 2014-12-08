package me.cooltimmetje.RoodCoreReloaded;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Transmute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("transmute")){
			Material transItem = p.getInventory().getItemInHand().getType();
			if(!transItem.equals(null)){
				if(transItem.equals(Material.LOG) || transItem.equals(Material.LOG_2)){
					openLog(p);
					return true;
				} else {
					p.sendMessage(Main.TransTag + Main.Error + "This item cannot be transmuted.");
					p.sendMessage(Main.NoTag + "Supported items: §8[§bOak Wood §8- §bBirch Wood §8- §bSpruce Wood §8- §bJungle Wood §8- §bAcacia Wood §8- §bDark Oak Wood§8]");
					return false;
				}
			} else {
				p.sendMessage(Main.TransTag + Main.Error + "You need to hold a item in your hand to transmutate.");
				return false;
			}
		}
		return false;
	}

	public void openLog(Player p){
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
		transItemLore.add("§7Item name: §b" + pItemHand.getItemMeta().getDisplayName());
		transItemLore.add("§7Amount: §b" + pItemHand.getAmount());
		transItemMeta.setLore(transItemLore);
		transItem.setItemMeta(transItemMeta);
		log.setItem(8, transItem);	
		
		p.openInventory(log);
	}
	
}