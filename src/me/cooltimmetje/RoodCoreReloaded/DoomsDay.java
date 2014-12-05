package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DoomsDay implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("doomsday")) {
			p.sendMessage(Main.NoTag + "BOOM! i guess... :s");
		}
		return true;
	}
}
