package com.niccholaspage.ShowIt;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ShowItPlayerListener extends PlayerListener{
	 public static ShowIt plugin;
	 public ShowItPlayerListener(ShowIt instance) {
		 plugin = instance;
	 }
	 public void onPlayerPickupItem(PlayerPickupItemEvent event){
		 Block block = event.getItem().getLocation().getBlock();
		 if (block.getType() == Material.GLASS){
			 event.setCancelled(true);
		 }
	 }
	  
}
