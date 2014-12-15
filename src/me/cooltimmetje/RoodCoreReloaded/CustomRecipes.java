package me.cooltimmetje.RoodCoreReloaded;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomRecipes {

	public static ShapelessRecipe glowstoneDust = 
			new ShapelessRecipe(new ItemStack(Material.GLOWSTONE_DUST, 16))
	.addIngredient(Material.REDSTONE)
	.addIngredient(Material.GOLD_INGOT)
	.addIngredient(Material.GLASS);

	public static ShapedRecipe netherrack = 
			new ShapedRecipe( new ItemStack(Material.NETHERRACK, 4))
	.shape(new String[] { "*% ", "%* ", "   " })
	.setIngredient('%', Material.SPIDER_EYE)
	.setIngredient('*', Material.COBBLESTONE);

	public static ShapedRecipe netherQuarts = 
			new ShapedRecipe( new ItemStack(Material.QUARTZ, 1))
	.shape(new String[] { "   ", "%*%", "   " })
	.setIngredient('%', Material.PAPER)
	.setIngredient('*', Material.NETHERRACK);

	public static ShapedRecipe blazeRod = 
			new ShapedRecipe( new ItemStack(Material.BLAZE_ROD, 1))
	.shape(new String[] { "%%%", "%*%", "%&%" })
	.setIngredient('%', Material.GLOWSTONE_DUST)
	.setIngredient('*', Material.STICK)
	.setIngredient('&', Material.GOLD_INGOT);

	public static ShapedRecipe netherWart = 
			new ShapedRecipe( new ItemStack(Material.NETHER_STALK, 1))
	.shape(new String[] { "%*%", "*&*", "%*%" })
	.setIngredient('%', Material.GLOWSTONE_DUST)
	.setIngredient('*', Material.NETHERRACK)
	.setIngredient('&', Material.PUMPKIN_SEEDS);


	public static ItemStack redBull(){
		ItemStack redBull = new ItemStack(Material.POTION, 1);
		PotionMeta redBullMeta = (PotionMeta) redBull.getItemMeta();
		PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2400, 1);
		PotionEffect haste = new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 1);
		redBullMeta.addCustomEffect(haste, true);
		redBullMeta.addCustomEffect(speed, true);
		redBullMeta.setDisplayName("§a§lBeemster POWERRRRRR");
		ArrayList<String> redBullLore = new ArrayList<String>();
		redBullLore.add("§7Speed II (2:00)");
		redBullLore.add("§7Haste II (2:00)");
		redBullMeta.setLore(redBullLore);
		redBull.setItemMeta(redBullMeta);
		return redBull;
	}

	@SuppressWarnings("deprecation")
	public static ShapedRecipe energyDrink =
	new ShapedRecipe(redBull())
	.shape(new String[]{"*%*","&$&","*%*"})
	.setIngredient('*', Material.SUGAR)
	.setIngredient('%', Material.INK_SACK, 4)
	.setIngredient('&', Material.IRON_INGOT)
	.setIngredient('$', Material.POTION);

	public static ItemStack heroine(){
		ItemStack heroine = new ItemStack(Material.ARROW);
		ItemMeta heroineMeta = heroine.getItemMeta();
		heroineMeta.setDisplayName("§cHeroine");
		ArrayList<String> heroineLore = new ArrayList<String>();
		heroineLore.add("§c§oNausea (0:30)");
		heroineLore.add("§7Speed III (2:00)");
		heroineLore.add(Main.drugWarning);
		heroineLore.add(Main.drugIRL);
		heroineMeta.setLore(heroineLore);
		heroine.setItemMeta(heroineMeta);
		return heroine;
	}

	public static ShapedRecipe heroine =
			new ShapedRecipe(heroine())
	.shape(new String[]{" # ","$%^","   "})
	.setIngredient('#', Material.GLASS)
	.setIngredient('$', Material.SPIDER_EYE)
	.setIngredient('%', Material.ARROW)
	.setIngredient('^', Material.SUGAR);
	
	public static ItemStack cocaine(){
		ItemStack cocaine = new ItemStack(Material.ARROW);
		ItemMeta cocaineMeta = cocaine.getItemMeta();
		cocaineMeta.setDisplayName("§cCocaine");
		ArrayList<String> cocaineLore = new ArrayList<String>();
		cocaineLore.add("§c§oNausea (0:30)");
		cocaineLore.add("§c§oBlindness (0:15)");
		cocaineLore.add("§7Speed II (2:00)");
		cocaineLore.add("§7Haste II (2:00)");
		cocaineLore.add(Main.drugWarning);
		cocaineLore.add(Main.drugIRL);
		cocaineMeta.setLore(cocaineLore);
		cocaine.setItemMeta(cocaineMeta);
		return cocaine;
	}
	
	public static ShapedRecipe cocaine = 
			new ShapedRecipe(cocaine())
	.shape(new String[]{"$%$","%#%","$%$"})
	.setIngredient('#', Material.SPIDER_EYE)
	.setIngredient('%', Material.SUGAR)
	.setIngredient('$', Material.GLOWSTONE_DUST);
}

