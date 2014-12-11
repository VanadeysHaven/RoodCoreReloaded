package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwagGear implements CommandExecutor {

	public static ItemStack swagSword(){
		ItemStack swagSword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta swagSwordMeta = swagSword.getItemMeta();
		swagSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		swagSwordMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
		swagSwordMeta.addEnchant(Enchantment.DURABILITY, 2000, true);
		swagSwordMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, true);
		swagSwordMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
		swagSwordMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		swagSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		swagSwordMeta.setDisplayName("§a§lSwagger Sword");
		swagSword.setItemMeta(swagSwordMeta);
		return swagSword;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("swaggergear")) {
			if (p.getName().equals("cooltimmetje")){
				p.sendMessage(Main.NoTag + "p.setSwagLevel(§lover 9000§a);");
				p.getInventory().clear();
				p.getInventory().setItem(0, swagSword());
			} else {
				p.sendMessage(Main.NoTag + "hoper...");
				return false;
			}

		}
		return false;
	}

}
