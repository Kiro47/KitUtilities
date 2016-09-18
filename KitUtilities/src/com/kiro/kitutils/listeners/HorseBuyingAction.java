package com.kiro.kitutils.listeners;


import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class HorseBuyingAction implements Listener{
	
	public static Economy econ = null;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	
	
	public void onSignClickHorseBuy(PlayerInteractEvent e){
		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		
		if (e.getClickedBlock().getState() instanceof Sign) {
			
			Sign si = (Sign) e.getClickedBlock().getState();
			
			if (si.getLine(0).equalsIgnoreCase("§c[Horses]")){
				
		/*		if (!(si.getLine(2).matches("^[0-9]+$"))){
					e.getPlayer().sendMessage(ChatColor.RED + "Invalid Sign!");
				}
				else {	*/
					
				Player p = (Player) e.getPlayer();
				PlayerInventory pi = p.getInventory();
			//	int price = Integer.parseInt(si.getLine(2));
			//	EconomyResponse er = econ.withdrawPlayer(p, price);
				
				if (p.getInventory().firstEmpty() == -1) {
					p.sendMessage(ChatColor.RED + "Your Inventory Is Full!");
					return;
				}
				
				if (si.getLine(1).equalsIgnoreCase("§9Tier 1")){
					
					econ = Bukkit.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
					EconomyResponse er = econ.withdrawPlayer(p, 20.0);
					
					
					if (er.transactionSuccess()) {
						
						int amt = 1;
						int horse = EntityType.HORSE.getTypeId();
						ItemStack Tier1Egg = new ItemStack(Material.MONSTER_EGG, amt ,(byte) horse );
						
						ItemMeta em = Tier1Egg.getItemMeta();
						
						em.setDisplayName(ChatColor.GRAY + "Tier 1 Horse Egg!");
						em.addEnchant(Enchantment.WATER_WORKER, 1, true);
						
						List <String> lore = new ArrayList<String>();
						lore.add(ChatColor.GRAY + "Tier 1 Horse");
						lore.add(ChatColor.RED + "Stats:");
						// Add In Stats In Lore
						lore.add(ChatColor.BOLD + "Jump Height :" + ChatColor.GOLD + " 2 Meters.");
						lore.add(ChatColor.BOLD + "Speed :" + ChatColor.GOLD + " Normal");
						lore.add(ChatColor.BOLD + "Health :" + ChatColor.GOLD + " 10");
						lore.add(ChatColor.DARK_RED + "NOTICE: Single Use Item");
						em.setLore(lore);
						Tier1Egg.setItemMeta(em);
						pi.addItem(Tier1Egg);
						p.updateInventory();
						p.sendMessage(ChatColor.GREEN + "You Have Bought A Tier 1 Horse Egg!");
					}
					else {
						p.sendMessage(ChatColor.RED + "You cannot Afford This Noble Steed!!!");
					}
				}
				
				if (si.getLine(1).equalsIgnoreCase("§9Tier 2")){
					EconomyResponse er = econ.withdrawPlayer(p, 40);
					
					if (er.transactionSuccess()) {
						
						int amt = 1;
						int horse = EntityType.HORSE.getTypeId();
						ItemStack Tier2Egg = new ItemStack(Material.MONSTER_EGG, amt , (byte) horse);
						
						ItemMeta em = Tier2Egg.getItemMeta();
						
						em.setDisplayName(ChatColor.GOLD + "Tier 2 Horse Egg!");
						em.addEnchant(Enchantment.OXYGEN, 1, true);
						
						List <String> lore = new ArrayList<String>();
						lore.add(ChatColor.GOLD + "Tier 2 Horse");
						lore.add(ChatColor.RED + "Stats:");
						lore.add(ChatColor.BOLD + "Jump Height :" + ChatColor.GOLD + " 3 Meters.");
						lore.add(ChatColor.BOLD + "Speed :" + ChatColor.GOLD + " Normal");
						lore.add(ChatColor.BOLD + "Health :" + ChatColor.GOLD + " 15");
						// add stats
						lore.add(ChatColor.DARK_RED + "NOTICE: Single Use Item");
						em.setLore(lore);
						Tier2Egg.setItemMeta(em);
						pi.addItem(Tier2Egg);
						p.updateInventory();
						p.sendMessage(ChatColor.GREEN + "You Have Bought A Tier 2 Horse Egg!");
					}
					else {
						p.sendMessage(ChatColor.RED + "You cannot Afford This Noble Steed!!!");
					}
				}
				if (si.getLine(1).equalsIgnoreCase("§9Tier 3")){
					EconomyResponse er = econ.withdrawPlayer(p, 60);
					if (er.transactionSuccess()) {
						
						int amt = 1;
						int horse = EntityType.HORSE.getTypeId();
						ItemStack Tier3Egg = new ItemStack(Material.MONSTER_EGG, amt , (short) horse);
						
						ItemMeta em = Tier3Egg.getItemMeta();
						
						
						em.setDisplayName(ChatColor.AQUA + "Tier 3 Horse Egg!");
						em.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
						
						List <String> lore = new ArrayList<String>();
						lore.add(ChatColor.AQUA + "Tier 3 Horse");
						lore.add(ChatColor.RED + "Stats:");
						// add in stats
						lore.add(ChatColor.BOLD + "Jump Height :" + ChatColor.GOLD + " 4 Meters.");
						lore.add(ChatColor.BOLD + "Speed :" + ChatColor.GOLD + " Normal");
						lore.add(ChatColor.BOLD + "Health :" + ChatColor.GOLD + " 20");
						lore.add(ChatColor.DARK_RED + "NOTICE: Single Use Item");
						em.setLore(lore);
						Tier3Egg.setItemMeta(em);
						pi.addItem(Tier3Egg);
						p.updateInventory();
						p.sendMessage(ChatColor.GREEN + "You Have Bought A Tier 3 Horse Egg!");
					}
					else {
						p.sendMessage(ChatColor.RED + "You cannot Afford This Noble Steed!!!");
					}
				}
				if (si.getLine(1).equalsIgnoreCase("§9Zombie Tier")){
					EconomyResponse er = econ.withdrawPlayer(p, 100);
					if (er.transactionSuccess()) {
						
						int amt = 1;
						int horse = EntityType.HORSE.getTypeId();
						ItemStack ZTierEgg = new ItemStack(Material.MONSTER_EGG, amt , (short) horse);
						
						ItemMeta em = ZTierEgg.getItemMeta();
						
						em.addEnchant(Enchantment.THORNS, 3, true);
						
						em.setDisplayName(ChatColor.DARK_GREEN + "Zombie Tier Horse Egg!");
						List <String> lore = new ArrayList<String>();
						lore.add(ChatColor.DARK_GREEN + "Zombie Tier Horse");
						lore.add(ChatColor.RED + "Stats:");
						// Add Stats
						lore.add(ChatColor.BOLD + "Jump Height :" + ChatColor.GOLD + " 5 Meters.");
						lore.add(ChatColor.BOLD + "Speed :" + ChatColor.GOLD + " Fast");
						lore.add(ChatColor.BOLD + "Health :" + ChatColor.GOLD + " 25");
						lore.add(ChatColor.DARK_RED + "NOTICE: Single Use Item");
						em.setLore(lore);
						ZTierEgg.setItemMeta(em);
						pi.addItem(ZTierEgg);
						p.updateInventory();
						p.sendMessage(ChatColor.GREEN + "You Have Bought A Zombie Tier Horse Egg!");
					}
					else {
						p.sendMessage(ChatColor.RED + "You cannot Afford This Noble Steed!!!");
					}
				}
				if (si.getLine(1).equalsIgnoreCase("§fSkeletal Tier")){
					EconomyResponse er = econ.withdrawPlayer(p, 120);
					if (er.transactionSuccess()) {
						
						int amt = 1;
						int horse = EntityType.HORSE.getTypeId();
						ItemStack STierEgg = new ItemStack(Material.MONSTER_EGG, amt , (short) horse);
						
						ItemMeta em = STierEgg.getItemMeta();
						
						em.setDisplayName(ChatColor.BOLD + "Skeletal Tier Horse Egg!");
						em.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
						
						List <String> lore = new ArrayList<String>();
						lore.add(ChatColor.WHITE + "Skeletal Horse");
						lore.add(ChatColor.RED + "Stats:");
						lore.add(ChatColor.BOLD + "Jump Height :" + ChatColor.GOLD + " 6 Meters.");
						lore.add(ChatColor.BOLD + "Speed :" + ChatColor.GOLD + " Fast");
						lore.add(ChatColor.BOLD + "Health :" + ChatColor.GOLD + " 30");
						lore.add(ChatColor.DARK_RED + "Fireproof");
						// Add Stats
						lore.add(ChatColor.DARK_RED + "NOTICE: Single Use Item");
						em.setLore(lore);
						STierEgg.setItemMeta(em);
						pi.addItem(STierEgg);
						p.updateInventory();
						p.sendMessage(ChatColor.GREEN + "You Have Bought A Skeleton Tier Horse Egg!");
					}
					else {
						p.sendMessage(ChatColor.RED + "You cannot Afford This Noble Steed!!!");
					}
				}
				
				
				}
			}
		}
	
	//	}
}
