package com.mathre190;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.mathre190.Threads.StartCountdown;

public class Main extends JavaPlugin{

	public void onEnable(){
		getLogger().info("Plugin has Started (Tag)");
		getServer().getPluginManager().registerEvents(new ClassListeners(), this);
		
	}
	public static void start(){
			setPlayers();
			
		}
	public static void setPlayers(){
		List<Player> player = (List) Bukkit.getServer().getOnlinePlayers();
		if(!player.isEmpty()){
			Tagger.setTagger(player.get(0));
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("starttag")){
				new Thread(new StartCountdown()).start();
				Bukkit.getScheduler().scheduleSyncRepeatingTask(this,new Runnable(){
					public void run(){
						if(Tagger.getTagger() != null)
						ParticleEffect.HEART.display(0, 0, 0, 0, 3, Tagger.getTagger().getLocation().add(0,2,0),(List) getServer().getOnlinePlayers());
					}
				}, 0, 10);
				Bukkit.getScheduler().scheduleSyncRepeatingTask(this,new Runnable(){
					Random r = new Random();
					Color c;
					public void run(){
						
						if(Tagger.getTagger() != null){
						c = Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255));
						Tagger.getTagger().getInventory().setHelmet(DiscoArmour.getColoredArmour(Material.LEATHER_HELMET, c));
						Tagger.getTagger().getInventory().setChestplate(DiscoArmour.getColoredArmour(Material.LEATHER_CHESTPLATE, c));
						Tagger.getTagger().getInventory().setLeggings(DiscoArmour.getColoredArmour(Material.LEATHER_LEGGINGS, c));
						Tagger.getTagger().getInventory().setBoots(DiscoArmour.getColoredArmour(Material.LEATHER_BOOTS, c));
						}
					}
				}, 0, 1);
			}
		}
		
	return false;
	}
}
