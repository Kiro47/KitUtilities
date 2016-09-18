package com.kiro.kitutils.listeners;


import java.util.Arrays;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.kiro.kitutils.KitUtilsMain;

public class ColorSignBuyEvent implements Listener {
	
	public static Economy econ = null;
	
	String invName = ChatColor.YELLOW + "D" + ChatColor.AQUA + "y" + ChatColor.LIGHT_PURPLE + "e" + ChatColor.RED + "s";

	  private boolean setupEconomy() {
		if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
		
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ !=null;
		
	} 
	  
	
	public void bm(String message) {
		Bukkit.getServer().broadcastMessage(message);
	}
	
	public void sdi(String name, int variant, Player player, Event e ) {
		
		((InventoryInteractEvent) e).setCancelled(true);
 		
		EconomyResponse  ec = econ.withdrawPlayer(player, "test 56", 5.0);
		if (ec.transactionSuccess()) {
			player.getInventory().addItem(new ItemStack(Material.INK_SACK, 1, (short) variant));
			player.updateInventory();
			player.sendMessage(ChatColor.GREEN + "Succesfully Bought: 1 " + name + " Dye!");
		}
		else {
			((InventoryInteractEvent) e).setCancelled(true);
			player.sendMessage(ChatColor.RED + "You Cannot Afford This!");
			return;
		}
		
	}
	
	@EventHandler
		public void colorSignBuyEvent(PlayerInteractEvent e){
		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		
		if (!(e.getClickedBlock().getState() instanceof Sign)) return;
		
		Sign si = (Sign) e.getClickedBlock().getState();
		
		if (!(si.getLine(0).equalsIgnoreCase(ChatColor.DARK_BLUE + "["+ ChatColor.AQUA + "C" + ChatColor.WHITE + "o" + ChatColor.BLUE + "l" + 
				ChatColor.GOLD +"o" + ChatColor.LIGHT_PURPLE + "r" + ChatColor.RED + "s" + ChatColor.DARK_RED +  "]"))) return;
				
		if (si.getLine(0).equalsIgnoreCase(ChatColor.DARK_BLUE + "["+ ChatColor.AQUA + "C" + ChatColor.WHITE + "o" + ChatColor.BLUE + "l" + 
		ChatColor.GOLD +"o" + ChatColor.LIGHT_PURPLE + "r" + ChatColor.RED + "s" + ChatColor.DARK_RED +  "]")) {
			e.getPlayer().closeInventory();
			ColorisinvMenu(e.getPlayer());
		} 
	}
	
	@SuppressWarnings("unused")
	private Inventory isinv;
	private ItemStack lg ,wh, cac, pink, gr ,lmg ,db,mag, chest, lb, pu, br, or, red, bla, cyan, yll;
	
	
	public void ColorisinvMenu(Player p) {
		Inventory isinv = Bukkit.getServer().createInventory(null, 45, invName);
		 
		lg = dye(7,"§7Light Gray!");
		wh = dye(15,"§fWhite!");
		cac = dye (2,"§2Cactus Green!");
		pink = dye(9, "§dPink!");
		gr = dye(8, "§ Gray!");
		lmg = dye(10, "§aLime Green!");
		db = dye(4, "§1Dark Blue!");
		mag = dye(13,"§5Magenta!");
		chest = chest();
		lb = dye(12,"§9Light Blue!");
		pu = dye(5,"§5Purple!");
		br = dye(3, ChatColor.BLACK + "Brown!");
		or = dye(14,"§6Orange!");
		red = dye(1, "§4Red!");
		bla = dye(0, ChatColor.BLACK + "Black!");
		cyan = dye(6,"§3Cyan!");
		yll = dye(11,"§eYellow!");
		
		
		isinv.setItem(2 , lg);
		isinv.setItem(4 , wh);
		isinv.setItem(6, cac);
		isinv.setItem(10, pink);
		isinv.setItem(12, gr);
		isinv.setItem(14, lmg);
		isinv.setItem(16, db);
		isinv.setItem(20, mag);
		isinv.setItem(22, chest);
		isinv.setItem(24, lb);
		isinv.setItem(28, pu);
		isinv.setItem(30, br);
		isinv.setItem(32, or);
		isinv.setItem(34, red);
		isinv.setItem(38, bla);
		isinv.setItem(40, cyan);
		isinv.setItem(42, yll);
		
		p.openInventory(isinv);
	}
	
	private ItemStack dye(int variant, String title) {
		ItemStack dyeVariant = new ItemStack(Material.INK_SACK , 1 , (short) variant);
		ItemMeta lgmeta = dyeVariant.getItemMeta();
		lgmeta.setDisplayName(title);
		lgmeta.setLore(Arrays.asList(ChatColor.GOLD + "$" + ChatColor.AQUA + "5"));
		dyeVariant.setItemMeta(lgmeta);
		return dyeVariant;
	}
	private ItemStack chest() {
		ItemStack cht = new ItemStack(Material.CHEST);
		ItemMeta cm = cht.getItemMeta();
		cm.setDisplayName(ChatColor.AQUA + "Thanks "  + ChatColor.LIGHT_PURPLE + " For " + ChatColor.RED + " Shopping!");
		cm.setLore(Arrays.asList(ChatColor.GOLD + "Closes Inventory!"));
		cht.setItemMeta(cm);
		return cht;
		
	}
	
	@EventHandler
	public void onDyeBuyClick(InventoryClickEvent e) {
		if (e.getClickedInventory() == null) return;
		
	 if (!e.getClickedInventory().getName().equalsIgnoreCase(invName)) return;
	 
	final Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem().getItemMeta() == null) return;
		
		String gdc = e.getCurrentItem().getItemMeta().getDisplayName();
		
	 if ((!(e.getClick().equals(ClickType.LEFT)))) {
		 e.setCancelled(true);
		 return;
	 }
	 if (setupEconomy()) {
	 	if (gdc.contains("Light Gray")){
	 	sdi("Light Gray", 7, p , e);
	 	return;
	 	}
	 	if (gdc.contains("White")) {
	 		sdi("White", 15, p, e);
	 		return;
	 	}
		if (gdc.contains("Cactus Green")) {
	 		sdi("Cactus Green", 2, p, e);
	 		return;
	 	}
		if (gdc.contains("Pink")) {
	 		sdi("Pink", 9, p, e);
	 		return;
	 	}
		if (gdc.contains("Gray")) {
	 		sdi("Gray", 8, p, e);
	 		return;
	 	}
		if (gdc.contains("Lime Green")) {
	 		sdi("Lime Green", 10, p, e);
	 		return;
	 	}
		if (gdc.contains("Dark Blue")) {
	 		sdi("Dark Blue", 4, p, e);
	 		return;
	 	}
		if (gdc.contains("Magenta")) {
	 		sdi("Magenta", 13, p, e);
	 		return;
	 	}
		if (gdc.contains("Thanks")) {
			e.setCancelled(true);
	 		KitUtilsMain.getMain().getServer().getScheduler().scheduleSyncDelayedTask(KitUtilsMain.getMain(), new Runnable() {
	 			public void run() {
	 				p.closeInventory();
	 			}
	 		}, 1L);
	 		return;
	 	}
		if (gdc.contains("Light Blue")) {
	 		sdi("Light Blue", 12, p, e);
	 		return;
	 	}
		if (gdc.contains("Purple")) {
	 		sdi("Purple", 5, p, e);
	 		return;
	 	}
		if (gdc.contains("Brown")) {
	 		sdi("Brown", 3, p, e);
	 		return;
	 	}
		if (gdc.contains("Orange")) {
	 		sdi("Orange", 14, p, e);
	 		return;
	 	}
		if (gdc.contains("Red")) {
	 		sdi("Red", 1, p, e);
	 		return;
	 	}
		if (gdc.contains("Black")) {
	 		sdi("Black", 0, p, e);
	 		return;
	 	}
		if (gdc.contains("Cyan")) {
	 		sdi("Cyan", 6, p, e);
	 		return;
	 	}
		if (gdc.contains("Yellow")) {
	 		sdi("Yellow", 11, p, e);
	 		return;
	 	}
	 }
	 else {
		 bm("economy fail 173, Message Kiro Immediatly");
	 }
		}
		
}
