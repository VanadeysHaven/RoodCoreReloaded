package me.cooltimmetje.RoodCoreReloaded;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class CustomRecipes {

	public static ShapelessRecipe glowstoneDust = 
			new ShapelessRecipe(new ItemStack(Material.GLOWSTONE, 16))
	.addIngredient(Material.REDSTONE)
	.addIngredient(Material.GOLD_INGOT)
	.addIngredient(Material.GLASS);

}
