package com.kiro.kitutils.listeners;

import org.bukkit.entity.Horse;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class HangingEntityDenier implements Listener{
	
	@EventHandler
	public void entityDenyEvent(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player) {
			return;
		}
		
		if (e.getEntity() instanceof Horse){
			return;
		}
		if (e.getDamager() instanceof Projectile) {
			return;
		}
		
		
		else {
			Player p = (Player) e.getDamager();
			
			
			if (p.getPlayer().hasPermission("utils.protection.bypass")){
				return;
			}
			
	
			else {
			
			e.setCancelled(true);
		}
		}
	}
	
	
	
	@EventHandler
	public void hangingEntityBlocker(HangingBreakByEntityEvent e){
		
		if (!(e.getRemover() instanceof Player)){
			e.setCancelled(true);
		}
		if (e.getRemover().hasPermission("utils.protection.bypass")){
			return;
		}
		else {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void hangingRotation(PlayerInteractEntityEvent e){
		if (!(e.getPlayer() instanceof Player)){
			return;
		}
		if (!(e.getRightClicked() instanceof ItemFrame)) {
			return;
		}
		else {
			if (e.getPlayer().hasPermission("utils.protection.bypass")) {
				return;
			}
			else {
				e.setCancelled(true);
			}
			
		}
	}
}
