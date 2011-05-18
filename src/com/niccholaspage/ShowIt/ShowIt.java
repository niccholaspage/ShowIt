package com.niccholaspage.ShowIt;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ShowIt extends JavaPlugin {
	public List<Item> items = new ArrayList<Item>();
	private final PlayerListener playerListener = new PlayerListener(){
		 public void onPlayerPickupItem(PlayerPickupItemEvent event){
			 Block block = event.getItem().getLocation().getBlock();
			 if (block.getType() == Material.GLASS){
				 event.setCancelled(true);
			 }else {
				 items.remove(items);
			 }
		 }
		 public void onPlayerDropItem(PlayerDropItemEvent event){
			 Item item = event.getItemDrop();
			 Block block = item.getLocation().getBlock();
			 if (block.getType() == Material.GLASS){
				 items.add(item);
			 }
		 }
	};
    @Override
	public void onDisable() {
		System.out.println("ShowIt Disabled");
	}
    @Override
	public void onEnable() {
		//Create the pluginmanage pm.
		PluginManager pm = getServer().getPluginManager();
		//Create PlayerCommand listener
	    pm.registerEvent(Event.Type.PLAYER_PICKUP_ITEM, playerListener, Event.Priority.Normal, this);
	    pm.registerEvent(Event.Type.PLAYER_DROP_ITEM, playerListener, Event.Priority.Normal, this);
       //Get the infomation from the yml file.
        PluginDescriptionFile pdfFile = this.getDescription();
        getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable(){
        	public void run(){
        		for (Item item : items){
        			if (item.isDead()){
        				item = item.getLocation().getWorld().dropItem(item.getLocation(), item.getItemStack().clone());
        				item.remove();
        			}
        		}
        	}
        }, 0, 1200);
        //Print that the plugin has been enabled!
        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}
}
