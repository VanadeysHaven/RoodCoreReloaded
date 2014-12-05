package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

@SuppressWarnings("deprecation")
public class DoomsDay implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("doomsday")) {
			if (p.getName().equals("ThoThoKill")){
				p.sendMessage(Main.NoTag + "PAYBACK BITCH!");
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.CREEPER);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.CREEPER);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.CREEPER);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.CREEPER);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.CREEPER);
			} else {
				p.sendMessage(Main.NoTag + "Bunnies? §lBUNNIES!");
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.RABBIT);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.RABBIT);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.RABBIT);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.RABBIT);
				p.getWorld().spawnCreature(p.getLocation(), CreatureType.RABBIT);
			}
		}
		return true;
	}
}