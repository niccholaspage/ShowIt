package com.niccholaspage.ShowIt;

import org.bukkit.Material;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ShowIt extends JavaPlugin {
	private final PlayerListener playerListener = new PlayerListener(){
		 public void onPlayerPickupItem(PlayerPickupItemEvent event){
			 Block block = event.getItem().getLocation().getBlock();
			 if (block.getType() == Material.GLASS){
				 event.setCancelled(true);
			 }
		 }
	};
    @Override
	public void onDisable() {
		//Print "Basic Disabled" on the log.
		System.out.println("ShowIt Disabled");
	}
    @Override
	public void onEnable() {
		//Create the pluginmanage pm.
		PluginManager pm = getServer().getPluginManager();
		//Create PlayerCommand listener
	    pm.registerEvent(Event.Type.PLAYER_PICKUP_ITEM, this.playerListener, Event.Priority.Normal, this);
       //Get the infomation from the yml file.
        PluginDescriptionFile pdfFile = this.getDescription();
        //Print that the plugin has been enabled!
        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}
}
