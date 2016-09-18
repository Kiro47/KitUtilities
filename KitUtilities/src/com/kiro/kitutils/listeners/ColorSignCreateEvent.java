package com.kiro.kitutils.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class ColorSignCreateEvent implements Listener{
	
	@EventHandler

	public void coloredSignCreate(SignChangeEvent e) {
		
		if (!(e.getPlayer().hasPermission("utils.sign.create.colors"))) return;
		
		if (e.getLine(0).equalsIgnoreCase("[colors]")) {
			
			
			e.setLine(0, ChatColor.DARK_BLUE + "["+ ChatColor.AQUA + "C" + ChatColor.WHITE + "o" + ChatColor.BLUE + "l" + ChatColor.GOLD +"o" 
					+ ChatColor.LIGHT_PURPLE + "r" + ChatColor.RED + "s" + ChatColor.DARK_RED +  "]");
			
			e.setLine(1, ChatColor.AQUA + "C" + ChatColor.WHITE + "o" + ChatColor.BLUE + "l" + ChatColor.GOLD +"o" 
					+ ChatColor.LIGHT_PURPLE + "r" + ChatColor.RED + "s");
			
			e.setLine(2, ChatColor.AQUA + "C" + ChatColor.WHITE + "o" + ChatColor.BLUE + "l" + ChatColor.GOLD +"o" 
					+ ChatColor.LIGHT_PURPLE + "r" + ChatColor.RED + "s");
			
			e.setLine(3, ChatColor.AQUA + "C" + ChatColor.WHITE + "o" + ChatColor.BLUE + "l" + ChatColor.GOLD +"o" 
					+ ChatColor.LIGHT_PURPLE + "r" + ChatColor.RED + "s");
			
		}
		else {
			return;
		}
	}
}
