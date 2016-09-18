package com.kiro.kitutils.listeners;

import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnBlocker implements Listener {

	
	@EventHandler
	
	public void blockEntitySpawn(EntitySpawnEvent e) {
	
		Entity t = e.getEntity();
		
		if (t instanceof Sheep){
			e.setCancelled(true);
		}
		if (t instanceof Wolf){
			e.setCancelled(true);
		}
		if (t instanceof Cow){
			e.setCancelled(true);
		}
		if (t instanceof MushroomCow){
			e.setCancelled(true);
		}
		if (t instanceof Ocelot){
			e.setCancelled(true);
		}
		if (t instanceof Bat){
			e.setCancelled(true);
		}
		if (t instanceof Chicken){
			e.setCancelled(true);
		}
		if (t instanceof Blaze){
			e.setCancelled(true);
		}
		if (t instanceof CaveSpider){
			e.setCancelled(true);
		}
		if (t instanceof Creeper){
			e.setCancelled(true);
		}
		if (t instanceof EnderCrystal){
			e.setCancelled(true);
		}
		if (t instanceof EnderDragon){
			e.setCancelled(true);
		}
		if (t instanceof Enderman){
			e.setCancelled(true);
		}
		if (t instanceof Endermite){
			e.setCancelled(true);
		}
		if (t instanceof Ghast){
			e.setCancelled(true);
		}
		if (t instanceof Giant){
			e.setCancelled(true);
		}
		if (t instanceof Guardian){
			e.setCancelled(true);
		}
		if (t instanceof IronGolem){
			e.setCancelled(true);
		}
		if (t instanceof MagmaCube){
			e.setCancelled(true);
		}
		if (t instanceof Pig){
			e.setCancelled(true);
		}
		if (t instanceof PigZombie){
			e.setCancelled(true);
		}
		if (t instanceof Rabbit){
			e.setCancelled(true);
		}
		if (t instanceof Silverfish){
			e.setCancelled(true);
		}
		if (t instanceof Skeleton){
			e.setCancelled(true);
		}
		if (t instanceof Slime){
			e.setCancelled(true);
		}
		if (t instanceof Snowman){
			e.setCancelled(true);
		}
		if (t instanceof Spider){
			e.setCancelled(true);
		}
		if (t instanceof Squid){
			e.setCancelled(true);
		}
		if (t instanceof Villager){
			e.setCancelled(true);
		}
		if (t instanceof Wither){
			e.setCancelled(true);
		}
		if (t instanceof Witch){
			e.setCancelled(true);
		}
		else {
			return;
		}
	}
	}
