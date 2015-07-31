package com.mathre190.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatUtil {

	private static String gameName = "Love Tag";
	public static void broadcast(String msg){
		
		for(Player player: Bukkit.getOnlinePlayers()){
			player.sendMessage(gameName + " " + msg);
		}
	}
}
