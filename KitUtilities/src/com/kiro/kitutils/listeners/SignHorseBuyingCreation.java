package com.kiro.kitutils.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignHorseBuyingCreation implements Listener{
	
	@EventHandler
	public void horseSignCreate(SignChangeEvent e){
		if (!(e.getPlayer().hasPermission("utils.sign.create.horses"))) return;
		if (e.getLine(0).equalsIgnoreCase("[Horses]")) {
			
		//	if (e.getLine(2).matches("^$[0-9]+")) {
		//	int price = Integer.parseInt(e.getLine(2));
			
			if (e.getLine(1).equalsIgnoreCase("Tier1")) {
				e.setLine(0, "§c[Horses]");
				e.setLine(1, "§9Tier 1");
				e.setLine(2, "§1" + "$20");
			}
			if (e.getLine(1).equalsIgnoreCase("Tier2")) {
				e.setLine(0, "§c[Horses]");
				e.setLine(1, "§9Tier 2");
				e.setLine(2, "§1" + "$40");
			}
			if (e.getLine(1).equalsIgnoreCase("Tier3")) {
				e.setLine(0, "§c[Horses]");
				e.setLine(1, "§9Tier 3");
				e.setLine(2, "§1" + "$60");
			}
			if (e.getLine(1).equalsIgnoreCase("Zombie")) {
				e.setLine(0, "§c[Horses]");
				e.setLine(1, "§9Zombie Tier");
				e.setLine(2, "§1" + "$100");
			}
			if (e.getLine(1).equalsIgnoreCase("Skeleton")) {
				e.setLine(0, "§c[Horses]");
				e.setLine(1, "§fSkeletal Tier");
				e.setLine(2, "§1" + "$120");
			}
				
			}
		/*	else {
				e.getBlock().breakNaturally(new ItemStack(Material.SIGN, 1));
				e.getPlayer().sendMessage(ChatColor.RED + "Invalid Sign");
				e.getPlayer().getInventory().addItem(new ItemStack(Material.SIGN, 1));
			}		
			*/
		 // }
	}
		
	}

