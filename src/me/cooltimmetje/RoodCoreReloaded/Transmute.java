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
			Material transItem = p.getInventory().getItemInHand().getType();
			if(!transItem.equals(null)){
				if(transItem.equals(Material.LOG) || transItem.equals(Material.LOG_2)){
					TransmuteLog.openLog(p);
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
	
}