package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Transmute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("transmute")){
			if(!(p.getInventory().firstEmpty() == -1)){
				Material transItem = p.getInventory().getItemInHand().getType();
				if(!transItem.equals(null)){
					if(transItem.equals(Material.LOG) || transItem.equals(Material.LOG_2)){
						TransmuteLog.openLog(p);
						return true;
					} else if(transItem.equals(Material.GRASS) || transItem.equals(Material.DIRT) || transItem.equals(Material.SAND)){
						TransmuteDirt.openDirt(p);
						return true;
					} else {
						p.sendMessage(Main.TransTag + Main.Error + "This item cannot be transmuted.");
						p.sendMessage(Main.NoTag + "Supported items: §7§oList coming SoonTM");
						return false;
					}
				} else {
					p.sendMessage(Main.TransTag + Main.Error + "You need to hold a item in your hand to transmutate.");
					return false;
				}
			} else {
				p.sendMessage(Main.TransTag + Main.Error + "Your inventory is full! You can't transmute with a full inventory. Clear out atleast one slot!");
				return false;
			}
		}
		return false;
	}

}