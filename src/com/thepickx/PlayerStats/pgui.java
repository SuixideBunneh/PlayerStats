package com.thepickx.PlayerStats;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class pgui  {

	private pvar var;

	public pgui(pvar var) {
		this.var = var;
	}
	
	public void pguiEnable(Player p) {
			/* BEGINNING */
			Inventory pgui = Bukkit.createInventory(null, 54, "Player Stats: " + p.getName());

			/* LORES */
			List<String> nameLore = new ArrayList<>();
			nameLore.add("Name:");
			nameLore.add(var.namee);
			
			List<String> levelLore = new ArrayList<>();
			levelLore.add("Island level:");
			levelLore.add(var.IslandLevel.toString());
			
			List<String> leaderLore = new ArrayList<>();
			leaderLore.add("Team leader:");
			leaderLore.add(var.IslandLeader);
			
			List<String> balanceLore = new ArrayList<>();
			balanceLore.add("Balance:");
			balanceLore.add(Double.toString(var.Balance));
			
			List<String> mobcoinLore = new ArrayList<>();
			mobcoinLore.add("Soul Shards:");
			mobcoinLore.add(Integer.toString(var.MobcoinTotal));
			
			List<String> cosmeticLore = new ArrayList<>();
			cosmeticLore.add("Cosmetic Tokens:");
			cosmeticLore.add(Integer.toString(var.userCoins));
			
			List<String> kdratioLore = new ArrayList<>();
			kdratioLore.add("Kill/death ratio:");
			kdratioLore.add(Float.toString(var.kdratio));
			
			List<String> flytimeLore = new ArrayList<>();
			flytimeLore.add("Fly Time:");
			flytimeLore.add(Integer.toString(var.h2timeFly) + "h" + Integer.toString(var.h3timeFly) + "m"
					+ Integer.toString(var.h1timeFly) + "s");
			
			List<String> xpLore = new ArrayList<>();
			xpLore.add("XP:");
			xpLore.add(Float.toString(var.xpTotal));
			
			List<String> playtimeLore = new ArrayList<>();
			playtimeLore.add("Playtime:");
			playtimeLore.add(Integer.toString(var.p2timePlayed) + "h" + Integer.toString(var.p3timePlayed) + "m"
					+ Integer.toString(var.p1timePlayed) + "s");

			
			/* ITEMSTACKS */
			ItemStack namegui;
			ItemStack level;
			ItemStack leader;
			ItemStack balance;
			ItemStack mobcoin;
			ItemStack cosmetic;
			ItemStack kdratiogui;
			ItemStack flytime;
			ItemStack xp;
			ItemStack playtime;
			ItemMeta nameguiMETA;
			ItemMeta levelMETA;
			ItemMeta leaderMETA;
			ItemMeta balanceMETA;
			ItemMeta mobcoinMETA;
			ItemMeta cosmeticMETA;
			ItemMeta kdratioguiMETA;
			ItemMeta flytimeMETA;
			ItemMeta xpMETA;
			ItemMeta playtimeMETA;

			namegui = new ItemStack(Material.ANVIL);
			nameguiMETA = namegui.getItemMeta();
			nameguiMETA.setDisplayName("ANVIL");
			nameguiMETA.setLore(nameLore);
			
			level = new ItemStack(Material.GRASS_BLOCK);
			levelMETA = level.getItemMeta();
			levelMETA.setDisplayName("GRASS");
			levelMETA.setLore(levelLore);
			
			leader = new ItemStack(Material.DIAMOND_HELMET);
			leaderMETA = leader.getItemMeta();
			leaderMETA.setDisplayName("HELMET");
			leaderMETA.setLore(leaderLore);
			
			balance = new ItemStack(Material.GOLD_INGOT);
			balanceMETA = balance.getItemMeta();
			balanceMETA.setDisplayName("GOLD HINGOT");
			balanceMETA.setLore(balanceLore);
			
			mobcoin = new ItemStack(Material.PRISMARINE_SHARD);
			mobcoinMETA = mobcoin.getItemMeta();
			mobcoinMETA.setDisplayName("Soul Shard");
			mobcoinMETA.setLore(mobcoinLore);
			
			cosmetic = new ItemStack(Material.SUNFLOWER);
			cosmeticMETA = cosmetic.getItemMeta();
			cosmeticMETA.setDisplayName("Cosmetic coin");
			cosmeticMETA.setLore(cosmeticLore);
			
			kdratiogui = new ItemStack(Material.DIAMOND_SWORD);
			kdratioguiMETA = kdratiogui.getItemMeta();
			kdratioguiMETA.setDisplayName("K/D score");
			kdratioguiMETA.setLore(kdratioLore);
			
			flytime = new ItemStack(Material.FEATHER);
			flytimeMETA = flytime.getItemMeta();
			flytimeMETA.setDisplayName("Fly time");
			flytimeMETA.setLore(flytimeLore);
			
			xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
			xpMETA = xp.getItemMeta();
			xpMETA.setDisplayName("XP score");
			xpMETA.setLore(xpLore);
			
			playtime = new ItemStack(Material.CLOCK);
			playtimeMETA = playtime.getItemMeta();
			playtimeMETA.setDisplayName("Playtime meta");
			playtimeMETA.setLore(playtimeLore);

			/* ITEMSETTINGS */

			pgui.setItem(0, namegui);
			pgui.setItem(1, level);
			pgui.setItem(2, leader);
			pgui.setItem(3, balance);
			pgui.setItem(4, mobcoin);
			pgui.setItem(5, cosmetic);
			pgui.setItem(6, kdratiogui);
			pgui.setItem(7, flytime);
			pgui.setItem(8, xp);
			pgui.setItem(9, playtime);

			/* FINAL */
			p.openInventory(pgui);

		}

	
	
}
