package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
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
			new ShapedRecipe( new ItemStack(Material.NETHERRACK, 4)).
			shape(new String[] { "*% ", "%* ", "   " })
			.setIngredient('%', Material.SPIDER_EYE)
			.setIngredient('*', Material.COBBLESTONE);

	public static ShapedRecipe netherQuarts = 
			new ShapedRecipe( new ItemStack(Material.QUARTZ, 1)).
			shape(new String[] { "   ", "%*%", "   " })
			.setIngredient('%', Material.PAPER)
			.setIngredient('*', Material.NETHERRACK);

	public static ShapedRecipe blazeRod = 
			new ShapedRecipe( new ItemStack(Material.BLAZE_ROD, 1)).
			shape(new String[] { "%%%", "%*%", "%&%" })
			.setIngredient('%', Material.GLOWSTONE_DUST)
			.setIngredient('*', Material.STICK)
			.setIngredient('&', Material.GOLD_INGOT);

	public static ShapedRecipe netherWart = 
			new ShapedRecipe( new ItemStack(Material.NETHER_STALK, 1)).
			shape(new String[] { "%*%", "*&*", "%*%" })
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
		redBull.setItemMeta(redBullMeta);
		return redBull;
	}
	
	public static ShapedRecipe energyDrink =
			new ShapedRecipe(CustomRecipes.redBull()).
			shape(new String[]{"*%*","&$&","*%*"})
			.setIngredient('*', Material.SUGAR)
			.setIngredient('%', Material.GOLD_INGOT)
			.setIngredient('&', Material.IRON_INGOT)
			.setIngredient('$', Material.POTION);





}
