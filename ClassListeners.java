package com.mathre190;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;




public class ClassListeners implements Listener {
	@EventHandler
	public void playerTag(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if(e.getDamager() instanceof Tagger){
				Tagger.setTagger(p);
			}
		}
	}
	
}
