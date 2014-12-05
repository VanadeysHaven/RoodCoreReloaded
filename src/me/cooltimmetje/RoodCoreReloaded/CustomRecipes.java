package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

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
}
