package com.kiro.kitutils;

import java.lang.reflect.Field;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.kiro.kitutils.cmds.potionEffectCheck;
import com.kiro.kitutils.listeners.ColorSignBuyEvent;
import com.kiro.kitutils.listeners.ColorSignCreateEvent;
import com.kiro.kitutils.listeners.DeathMessageListener;
import com.kiro.kitutils.listeners.EntitySpawnBlocker;
import com.kiro.kitutils.listeners.HangingEntityDenier;
import com.kiro.kitutils.listeners.HorseBuyingAction;
import com.kiro.kitutils.listeners.HorseSpawningEvent;
import com.kiro.kitutils.listeners.SignHorseBuyingCreation;
import com.kiro.kitutils.listeners.horseItemMovementBlock;

public class KitUtilsMain extends JavaPlugin {
	
	public static Plugin  getMain() {
		 return Bukkit.getServer().getPluginManager().getPlugin("KitUtilities");
	}
	
	 public static Economy econ = null;
	
	
	  private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null){
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ !=null;
		
	} 
	
	public void onEnable(){
		
		PluginManager rl = Bukkit.getServer().getPluginManager();
		
		rl.registerEvents(new HangingEntityDenier(), this);
		rl.registerEvents(new EntitySpawnBlocker(), this);
		rl.registerEvents(new SignHorseBuyingCreation(), this);
		rl.registerEvents(new HorseBuyingAction(), this);
		rl.registerEvents(new HorseSpawningEvent(), this);
		rl.registerEvents(new horseItemMovementBlock(), this);
		rl.registerEvents(new DeathMessageListener(), this);
		
		rl.registerEvents(new ColorSignCreateEvent(), this);
		rl.registerEvents(new ColorSignBuyEvent(), this);

		getCommand("effcheck").setExecutor(new potionEffectCheck());
		
		if (!setupEconomy() ) {
			getLogger().severe(String.format("[%s] - Disabled due to no Vault dependcy found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
	    try
	     {
	     Field f = net.minecraft.server.v1_8_R3.Item.class.getDeclaredField("maxStackSize");
	     f.setAccessible(true);
	     f.setInt(net.minecraft.server.v1_8_R3.Item.getById(383), 1);
	     f.setAccessible(false);
	     Bukkit.getServer().getOnlinePlayers().iterator().next().updateInventory();
	     }
	     catch(Exception e)
	     {
	     e.printStackTrace();
	     return;
	     }
	     
	}


}
