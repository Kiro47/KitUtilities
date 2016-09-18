package com.kiro.kitutils.listeners;

import java.util.List;
import java.util.ListIterator;

import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathMessageListener implements Listener{

	
	@EventHandler
	
	public void entityLootDestroy(EntityDeathEvent e){
		if (e.getEntity() instanceof Player){
			
			List <ItemStack> drops = e.getDrops();
			ListIterator<ItemStack> litr = drops.listIterator();
			
			while (litr.hasNext() ) {
				
				ItemStack stack = litr.next();
				Material gs = stack.getType();
				
				if 	(gs.equals(Material.SADDLE)
					|| gs.equals(Material.IRON_BARDING)
					|| gs.equals(Material.GOLD_BARDING)
					||gs.equals(Material.DIAMOND_BARDING)
					||gs.equals(Material.LEATHER))
					
				{
					litr.remove();
				}
				
	
			}
		}
		
		if (e.getEntity() instanceof Horse) {
			
			
			List <ItemStack> drops = e.getDrops();
			ListIterator<ItemStack> litr = drops.listIterator();
			
			
			while (litr.hasNext()) {
		
				ItemStack stack = litr.next();
				Material gs = stack.getType();
				
				if 	(gs.equals(Material.SADDLE)
					|| gs.equals(Material.IRON_BARDING)
					|| gs.equals(Material.GOLD_BARDING)
					||gs.equals(Material.DIAMOND_BARDING)
					||gs.equals(Material.LEATHER))
					
				{
					
				}
				litr.remove();
			}
		}
		else {
			return;
		}
		// Stop players From Moving Saddles and Horse Armor
	}
}
