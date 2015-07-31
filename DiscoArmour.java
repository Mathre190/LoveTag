package com.mathre190;



import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class DiscoArmour {

	public static ItemStack getColoredArmour(Material m, Color c){
		ItemStack i = new ItemStack(m,1);
		LeatherArmorMeta lam = (LeatherArmorMeta) i.getItemMeta();
		lam.setColor(c);
		i.setItemMeta(lam);
		return i;
	}
}
