package me.cooltimmetje.RoodCoreReloaded;

import io.puharesource.mc.titlemanager.api.ActionbarTitleObject;
import io.puharesource.mc.titlemanager.api.TitleObject;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TPCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
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
						if(p.getName().equals("ThoThoKill")){
							for(Player pl : Bukkit.getOnlinePlayers()){
								if(!pl.getName().equals("ThoThoKill")){
									new TitleObject(Main.CodeRood, "§4Herr R00D §ateleported to "+ target.getDisplayName()).setFadeIn(0).setStay(100).setFadeOut(20).send(pl);
								}
							}
						} else {
							new TitleObject(Main.TPTag, p.getDisplayName() + " §ateleported to you.").setFadeIn(20).setStay(60).setFadeOut(20).send(target);
						}
						new ActionbarTitleObject(Main.TPTag + "You have been teleported to: " + target.getDisplayName()).send(p);
						p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
						p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1));
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
				return false;
			}
		} else if (cmd.getName().equalsIgnoreCase("silenttp")){
			if (p.getName().equals("cooltimmetje")){
				if(args.length == 1){
					Player silentTarget = Bukkit.getServer().getPlayer(args[0]);
					if(!(silentTarget == null)){
						Location silentTargetLoc = silentTarget.getLocation();
						p.teleport(silentTargetLoc);
						p.sendMessage(Main.TPTag + "You silently sneaked upon: " + silentTarget.getDisplayName());
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
				p.sendMessage("§cno...");
				return false;
			}
		}
		return true;
	}
}
