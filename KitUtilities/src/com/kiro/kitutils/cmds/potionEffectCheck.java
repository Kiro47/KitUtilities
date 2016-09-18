package com.kiro.kitutils.cmds;

import java.util.Collection;
import java.util.Iterator;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class potionEffectCheck implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

		if (args.length == 0) {
			s.sendMessage(ChatColor.RED + "Please Specify a Player!");
			return true;
		}
		
		
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if (target == null ) {
			s.sendMessage(ChatColor.RED + "This Player Doesn't Appear To Be Online!");
			return true;
		}
		
		if (!(s.hasPermission("utils.cmd.effcheck"))){
			s.sendMessage(ChatColor.RED + "You Don't Have Permission For this!");
		}
		
		else {
			Collection<PotionEffect> eff = target.getActivePotionEffects();
			Iterator<PotionEffect> itr = eff.iterator();
			
			s.sendMessage(ChatColor.GREEN + "Displaying "+ChatColor.AQUA + target.getDisplayName() + ChatColor.GREEN + "'s Potion Effects.");
			
			while (itr.hasNext()) {
				PotionEffect it = itr.next();
				
				PotionEffectType gs = it.getType();
				
				int amp = it.getAmplifier();
				int lvl = amp + 1;
				
				int sec = it.getDuration() / 20;
				
				int hours = sec / 3600;
				int rem = sec % 3600;
				int min =  rem /60;
				int secF = rem % 60;
			
				String time = hours + "H : " + min + "Min : " + secF + "sec";
		
				if (gs.equals(PotionEffectType.ABSORPTION)){
					s.sendMessage(ChatColor.AQUA + "ABSORPTION,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.BLINDNESS)){
					s.sendMessage(ChatColor.AQUA + "BLINDNESS,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.CONFUSION)){
					s.sendMessage(ChatColor.AQUA + "CONFUSION,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.DAMAGE_RESISTANCE)){
					s.sendMessage(ChatColor.AQUA + "PROTECTION,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.FAST_DIGGING)){
					s.sendMessage(ChatColor.AQUA + "HASTE,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.FIRE_RESISTANCE)){
					s.sendMessage(ChatColor.AQUA + "FIRE RESISTANCE,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.HARM)){
					s.sendMessage(ChatColor.AQUA + "HARM,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.HEAL)){
					s.sendMessage(ChatColor.AQUA + "HEAL,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.HEALTH_BOOST)){
					s.sendMessage(ChatColor.AQUA + "HEALTH BOOST,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.HUNGER)){
					s.sendMessage(ChatColor.AQUA + "HUNGER,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.INCREASE_DAMAGE)){
					s.sendMessage(ChatColor.AQUA + "STRENGTH,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.INVISIBILITY)){
					s.sendMessage(ChatColor.AQUA + "INVISIBILITY,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.JUMP)){
					s.sendMessage(ChatColor.AQUA + "JUMP BOOST,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				
				if (gs.equals(PotionEffectType.NIGHT_VISION)){
					s.sendMessage(ChatColor.AQUA + "NIGHT VISION,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.POISON)){
					s.sendMessage(ChatColor.AQUA + "POISON,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.REGENERATION)){
					s.sendMessage(ChatColor.AQUA + "REGENERATION,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.SATURATION)){
					s.sendMessage(ChatColor.AQUA + "SATURATION,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.SLOW)){
					s.sendMessage(ChatColor.AQUA + "SLOWNESS,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.SLOW_DIGGING)){
					s.sendMessage(ChatColor.AQUA + "MINING FATIGE,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.SPEED)){
					s.sendMessage(ChatColor.AQUA + "SPEED,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.WATER_BREATHING)){
					s.sendMessage(ChatColor.AQUA + "WATER BREATHING,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.WEAKNESS)){
					s.sendMessage(ChatColor.AQUA + "WEAKNESS,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				if (gs.equals(PotionEffectType.WITHER)){
					s.sendMessage(ChatColor.AQUA + "WITHERNG,  " + ChatColor.GOLD + "Level: " + lvl + ChatColor.GREEN + "  For: " + time);
				}
				else {
					s.sendMessage(ChatColor.GREEN + "No Other Potion Effects Found!");
			}
			}
			return true;
		}
		return true;
	}
}
