package com.mathre190;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Tagger {
	private static Player tagger;
	public static void setTagger(Player p){
		if(tagger != null)
		tagger.getInventory().clear();
		
		p.sendMessage(ChatColor.BOLD +"You are it! Go tag another player!");
		tagger = p;
	}
	public static Player getTagger(){
		return tagger;
	}
}
