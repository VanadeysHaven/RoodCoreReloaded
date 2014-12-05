package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if(p.hasPermission("rcr.tp")){
				if(args.length == 1){
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if(!(target == null)){
						Location targetLoc = target.getLocation();
						p.teleport(targetLoc);
						p.sendMessage(Main.TPTag + "You have been teleported to: " + target.getDisplayName());
						target.sendMessage(Main.TPTag + p.getDisplayName() + " §ateleported to you.");
						if(p.getName().equals("ThoThoKill")){
							Bukkit.broadcastMessage(Main.CodeRood + "§4§lHerr R00D §ateleported to " + target.getDisplayName() + " §a.");
						}
						p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
						p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1));
						p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20, 1));
						p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 1));
						target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
						target.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1));
						return true;
					} else {
						p.sendMessage(Main.TPTag + Main.Error + "Invalid player.");
						return false;
					}
				} else {
					p.sendMessage(Main.TPTag + Main.Error + "Please provide a playername.");
					return false;
				}
			} else {
				p.sendMessage(Main.TPTag + Main.Error + "You do not have access to this command.");
				p.sendMessage(Main.NoTag + "Permission(s) missing: §8[§brcr.tp§8]");
				return false;
			}
		}
		return true;
	}
}
