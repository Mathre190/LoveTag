package com.mathre190.Threads;

import org.bukkit.Bukkit;

import com.mathre190.Main;
import com.mathre190.Utils.ChatUtil;


public class StartCountdown implements Runnable{
	
	private static int starttime = 10;
	
	@Override
	public void run() {
		while(true){
			if(Bukkit.getOnlinePlayers().size() >=1){
			for(; starttime >= 0; starttime--){
				if(starttime==0){
					Main.start();
				}
				if(starttime %5 == 0 || (starttime <= 10 && starttime > 0)){
					ChatUtil.broadcast("starts in " + starttime);
				}
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
					Bukkit.shutdown();
				}
			}
			}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
				Bukkit.shutdown();
			}
		}
		
	}
	
}
