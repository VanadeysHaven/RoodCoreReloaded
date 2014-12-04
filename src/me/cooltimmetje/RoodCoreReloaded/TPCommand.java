package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Player target = Bukkit.getPlayerExact(args[0]);
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (p.hasPermission("rcr.tp")){
				if(args.length == 1){
					Location targetLoc = target.getLocation();
					p.teleport(targetLoc);
					p.sendMessage(Main.TPTag + "You were teleported to: §c" + target.getDisplayName() + "§a.");
					target.sendMessage(Main.TPTag + "§c" + p.getDisplayName() + "§a teleported to you.");
				} else { 
					p.sendMessage(Main.TPTag + Main.Error + "Please provide the target player.");
				} 
			}
		} else {
			p.sendMessage(Main.TPTag + Main.Error + "You do not have permission!");
			p.sendMessage("§aPermission(s) missing: §8[§brcr.tp§8]");
		}
		return false;
	}
}