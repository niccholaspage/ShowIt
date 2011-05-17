package com.niccholaspage.ShowIt;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ShowItPlayerListener extends PlayerListener{
	 public void onPlayerPickupItem(PlayerPickupItemEvent event){
		 Block block = event.getItem().getLocation().getBlock();
		 if (block.getType() == Material.GLASS){
			 event.setCancelled(true);
		 }
	 }
	  
}
