package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BetterClearInventory implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("ci")){
			if (p.hasPermission("rcr.ci")){
				p.getInventory().clear();
				p.getInventory().setHelmet(null);
				p.getInventory().setChestplate(null);
				p.getInventory().setLeggings(null);
				p.getInventory().setBoots(null);
				return true;
			} else {
				p.sendMessage(Main.CiTag + Main.Error + Main.noPerm);
				return false;
			}
		}
		return false;
	}

}
