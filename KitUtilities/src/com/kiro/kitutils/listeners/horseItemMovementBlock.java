package com.kiro.kitutils.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class horseItemMovementBlock implements Listener{
	
	
	@EventHandler
	public void onPlayerMoveHorseVariable(InventoryClickEvent e){
		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		
		if (!(e.getCurrentItem() == null)){
		if (e.getCurrentItem().getType().equals(Material.SADDLE) ||
				e.getCurrentItem().getType().equals(Material.IRON_BARDING) ||
				e.getCurrentItem().getType().equals(Material.GOLD_BARDING) ||
				e.getCurrentItem().getType().equals(Material.DIAMOND_BARDING))
				 {
								e.setCancelled(true);
				 }
		
		}
	}
}
