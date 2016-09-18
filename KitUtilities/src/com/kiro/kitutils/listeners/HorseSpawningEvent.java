package com.kiro.kitutils.listeners;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HorseSpawningEvent implements Listener {
	
	/*
	@EventHandler
	public void blockSpawnEggSpawn(CreatureSpawnEvent e) {
		
		if (e.getSpawnReason() == SpawnReason.SPAWNER_EGG){
			e.setCancelled(true);
		}
		
		else {
			return;
		}
	}
*/
	
	@EventHandler 
	public void spawnCustomHorseInteractionEvent(PlayerInteractEvent e){

	Player p = (Player) e.getPlayer();
	
	if (e.getItem() == null) return;
	
	if (e.getClickedBlock() == null) return;
	
	if (e.getAction() == Action.LEFT_CLICK_AIR) return;
	if (e.getAction() == Action.LEFT_CLICK_BLOCK) return;
	
	if (!(e.getClickedBlock().getState() instanceof Sign)){

	
	if (e.getItem().getType() == Material.MONSTER_EGG) {
		
		
		e.setCancelled(true);
		
		if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GRAY + "Tier 1 Horse Egg!")){
			
		Entity entity = e.getClickedBlock().getLocation().getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0, 1, 0), EntityType.HORSE);
		Horse horse1 = (Horse) entity;
		
		horse1.setTamed(true);
		horse1.setCustomNameVisible(true);
		horse1.setCustomName(p.getDisplayName() + ChatColor.GRAY + "'s Tier 1 Horse");
		horse1.setMaxHealth(20.0);
		horse1.setHealth(20.0);
		horse1.setJumpStrength(0.7);
		horse1.setOwner(e.getPlayer());
		horse1.setRemoveWhenFarAway(false);
		horse1.setStyle(Style.NONE);
		horse1.setVariant(Variant.HORSE);
		horse1.setPassenger(p);
		horse1.setColor(Color.BROWN);
		horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse1.setAdult();
		if (p.getItemInHand().getAmount() > 1) {
					p.getInventory().remove(new ItemStack(e.getPlayer().getItemInHand().getType() , 1));
					p.updateInventory();
		}
		else {
			p.getInventory().setItemInHand(new ItemStack(Material.AIR, 0));
			p.updateInventory();
		}
		}

		if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Tier 2 Horse Egg!")){
			
		Entity entity = e.getClickedBlock().getLocation().getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0, 1, 0), EntityType.HORSE);
		Horse horse1 = (Horse) entity;
		
		horse1.setTamed(true);
		horse1.setCustomNameVisible(true);
		horse1.setCustomName(p.getDisplayName() + ChatColor.GOLD + "'s Tier 2 Horse");
		horse1.setMaxHealth(30.0);
		horse1.setHealth(30.0);
		horse1.setJumpStrength(0.8);
		horse1.setOwner(e.getPlayer());
		horse1.setRemoveWhenFarAway(false);
		horse1.setStyle(Style.WHITEFIELD);
		horse1.setVariant(Variant.HORSE);
		horse1.setPassenger(p);
		horse1.setColor(Color.CREAMY);
		horse1.getInventory().setArmor(new ItemStack(Material.IRON_BARDING));
		horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse1.setAdult();
		if (p.getItemInHand().getAmount() > 1) {
			p.getInventory().remove(new ItemStack(e.getPlayer().getItemInHand().getType() , 1));
			p.updateInventory();
}
else {
	p.getInventory().setItemInHand(new ItemStack(Material.AIR, 0));
	p.updateInventory();
}
		}

		if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Tier 3 Horse Egg!")){
			
		Entity entity = e.getClickedBlock().getLocation().getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0, 1, 0), EntityType.HORSE);
		Horse horse1 = (Horse) entity;
		
		horse1.setTamed(true);
		horse1.setCustomNameVisible(true);
		horse1.setCustomName(p.getDisplayName() + ChatColor.AQUA + "'s Tier 3  Horse");
		horse1.setMaxHealth(40.0);
		horse1.setHealth(40.0);
		horse1.setJumpStrength(0.9);
		horse1.setOwner(e.getPlayer());
		horse1.setRemoveWhenFarAway(false);
		horse1.setStyle(Style.NONE);
		horse1.setVariant(Variant.HORSE);
		horse1.setPassenger(p);
		horse1.setColor(Color.WHITE);
		horse1.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));
		horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse1.setAdult();
		if (p.getItemInHand().getAmount() > 1) {
			p.getInventory().remove(new ItemStack(e.getPlayer().getItemInHand().getType() , 1));
			p.updateInventory();
}
else {
	p.getInventory().setItemInHand(new ItemStack(Material.AIR, 0));
	p.updateInventory();
}
		}

		if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.DARK_GREEN + "Zombie Tier Horse Egg!")){
			
		Entity entity = e.getClickedBlock().getLocation().getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0, 1, 0), EntityType.HORSE);
		Horse horse1 = (Horse) entity;
		
		horse1.setTamed(true);
		horse1.setCustomNameVisible(true);
		horse1.setCustomName(p.getDisplayName() + ChatColor.DARK_GREEN + "'s Zombie Horse");
		horse1.setMaxHealth(50.0);
		horse1.setHealth(50.0);
		horse1.setJumpStrength(1.0);
		horse1.setOwner(e.getPlayer());
		horse1.setRemoveWhenFarAway(false);
		horse1.setVariant(Variant.UNDEAD_HORSE);
		horse1.setPassenger(p);
		horse1.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));
		horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse1.setAdult();
		horse1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true));
		if (p.getItemInHand().getAmount() > 1) {
			p.getInventory().remove(new ItemStack(e.getPlayer().getItemInHand().getType() , 1));
			p.updateInventory();
}
else {
	p.getInventory().setItemInHand(new ItemStack(Material.AIR, 0));
	p.updateInventory();
}
		}

		if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.BOLD + "Skeletal Tier Horse Egg!")){
			
		Entity entity = e.getClickedBlock().getLocation().getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0, 1, 0), EntityType.HORSE);
		Horse horse1 = (Horse) entity;
		
		horse1.setTamed(true);
		horse1.setCustomNameVisible(true);
		horse1.setCustomName(p.getDisplayName() + ChatColor.WHITE + "'s Skeletal Horse");
		horse1.setMaxHealth(60.0);
		horse1.setHealth(60.0);
		horse1.setJumpStrength(1.1);
		horse1.setOwner(e.getPlayer());
		horse1.setRemoveWhenFarAway(false);;
		horse1.setVariant(Variant.SKELETON_HORSE);
		horse1.setPassenger(p);
		
		// Custom Horse Armor
		
		ItemStack hsarmor = new ItemStack(Material.DIAMOND_BARDING, 1 );
		
		ItemMeta am = hsarmor.getItemMeta();
		
		am.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
		am.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);
		am.setDisplayName(ChatColor.GOLD + "Skeletal Armor");
		
		List<String> amlore = new ArrayList<String>();
		amlore.add(ChatColor.DARK_RED + "Did You Really Think Flames Would Hurt?");
		amlore.add(ChatColor.DARK_RED + "Hah, Mere Mortals.");
		 
		am.setLore(amlore);
		hsarmor.setItemMeta(am);
		horse1.getInventory().setArmor(new ItemStack(hsarmor));
		
		// Custom Horse Armor
		horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse1.setAdult();
		horse1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000000, 0, true));
		horse1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000000, 0, true));
		if (p.getItemInHand().getAmount() > 1) {
			p.getInventory().remove(new ItemStack(e.getPlayer().getItemInHand().getType() , 1));
			p.updateInventory();
}
else {
	p.getInventory().setItemInHand(new ItemStack(Material.AIR, 0));
	p.updateInventory();
}
		}
		else if (e.getItem().getItemMeta().getDisplayName().contains("Spawn Horse")){
			e.setCancelled(true);
			return;
		}
	}
	else {
		return;
	}
	}
	}
	
/*	@EventHandler
	public void spawnCustomHorseOnEntityInteraction(PlayerInteractAtEntityEvent e) {
		Player p = (Player) e.getPlayer();
		
		if (e.getRightClicked() == null) return;
		
		if (e.getPlayer().getItemInHand().getType() == Material.MONSTER_EGG ) {
			e.setCancelled(true);
			
			

			e.setCancelled(true);
			
			
			
			if (p.getItemInHand().getItemMeta().getDisplayName() == ChatColor.GRAY + "Tier 1 Horse Egg!"){
				
			Entity entity = e.getRightClicked().getLocation().getWorld().spawnEntity(e.getRightClicked().getLocation(), EntityType.HORSE);
			Horse horse1 = (Horse) entity;
			
			horse1.setTamed(true);
			horse1.setCustomNameVisible(true);
			horse1.setCustomName(p.getDisplayName() + ChatColor.GRAY + "'s Tier 1 Horse");
			horse1.setHealth(20);
			horse1.setMaxHealth(20);
			horse1.setJumpStrength(0.4);
			horse1.setOwner(e.getPlayer());
			horse1.setRemoveWhenFarAway(false);
			horse1.setStyle(Style.NONE);
			horse1.setVariant(Variant.HORSE);
			horse1.setPassenger(p);
			horse1.setColor(Color.BROWN);
			horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse1.addPotionEffect( new PotionEffect(PotionEffectType.SLOW, 20000, 1, true)); 
				
			}

			if(p.getItemInHand().getItemMeta().getDisplayName() == ChatColor.GOLD + "Tier 2 Horse Egg!"){
				
				Entity entity = e.getRightClicked().getLocation().getWorld().spawnEntity(e.getRightClicked().getLocation(), EntityType.HORSE);
			Horse horse1 = (Horse) entity;
			
			horse1.setTamed(true);
			horse1.setCustomNameVisible(true);
			horse1.setCustomName(p.getDisplayName() + ChatColor.GOLD + "'s Tier 2 Horse");
			horse1.setHealth(30);
			horse1.setMaxHealth(30);
			horse1.setJumpStrength(0.6);
			horse1.setOwner(e.getPlayer());
			horse1.setRemoveWhenFarAway(false);
			horse1.setStyle(Style.WHITEFIELD);
			horse1.setVariant(Variant.HORSE);
			horse1.setPassenger(p);
			horse1.setColor(Color.CREAMY);
			horse1.getInventory().setArmor(new ItemStack(Material.IRON_BARDING));
			horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse1.addPotionEffect( new PotionEffect(PotionEffectType.SLOW, 20000, 0, true)); 
			}

			if (p.getItemInHand().getItemMeta().getDisplayName() == ChatColor.AQUA + "Tier 3 Horse Egg!"){
				
				Entity entity = e.getRightClicked().getLocation().getWorld().spawnEntity(e.getRightClicked().getLocation(), EntityType.HORSE);
			Horse horse1 = (Horse) entity;
			
			horse1.setTamed(true);
			horse1.setCustomNameVisible(true);
			horse1.setCustomName(p.getDisplayName() + ChatColor.AQUA + "'s Tier 3  Horse");
			horse1.setHealth(40);
			horse1.setMaxHealth(40);
			horse1.setJumpStrength(0.7);
			horse1.setOwner(e.getPlayer());
			horse1.setRemoveWhenFarAway(false);
			horse1.setStyle(Style.NONE);
			horse1.setVariant(Variant.HORSE);
			horse1.setPassenger(p);
			horse1.setColor(Color.WHITE);
			horse1.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));
			horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			horse1.addPotionEffect( new PotionEffect(PotionEffectType.SLOW, 20000, 0, true)); 
			}

			if (p.getItemInHand().getItemMeta().getDisplayName() == ChatColor.DARK_GREEN + "Zombie Tier Horse Egg!"){
				
				Entity entity = e.getRightClicked().getLocation().getWorld().spawnEntity(e.getRightClicked().getLocation(), EntityType.HORSE);
			Horse horse1 = (Horse) entity;
			
			horse1.setTamed(true);
			horse1.setCustomNameVisible(true);
			horse1.setCustomName(p.getDisplayName() + ChatColor.DARK_GREEN + "'s Zombie Horse");
			horse1.setHealth(50);
			horse1.setMaxHealth(50);
			horse1.setJumpStrength(0.8);
			horse1.setOwner(e.getPlayer());
			horse1.setRemoveWhenFarAway(false);
			horse1.setVariant(Variant.UNDEAD_HORSE);
			horse1.setPassenger(p);
			horse1.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));
			horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			}

			if (p.getItemInHand().getItemMeta().getDisplayName() == ChatColor.WHITE + "Skeletal Tier Horse Egg!"){
				
				Entity entity = e.getRightClicked().getLocation().getWorld().spawnEntity(e.getRightClicked().getLocation(), EntityType.HORSE);
			Horse horse1 = (Horse) entity;
			
			horse1.setTamed(true);
			horse1.setCustomNameVisible(true);
			horse1.setCustomName(p.getDisplayName() + ChatColor.WHITE + "'s Skeletal Horse");
			horse1.setHealth(60);
			horse1.setMaxHealth(60);
			horse1.setJumpStrength(0.9);
			horse1.setOwner(e.getPlayer());
			horse1.setRemoveWhenFarAway(false);;
			horse1.setVariant(Variant.SKELETON_HORSE);
			horse1.setPassenger(p);
			horse1.getInventory().setArmor(new ItemStack(Material.DIAMOND_BARDING));
			horse1.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			}
		}
			
		} */
	}
