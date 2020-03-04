package com.thepickx.PlayerStats;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements CommandExecutor {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	@Override
	public void onEnable() {
		System.out.println(ANSI_GREEN + "Player Stats has been enabled! :)\n" + ANSI_BLUE + "By: 1S8/SuixideBunneh\n"
				+ ANSI_YELLOW + "Version: 1.0");
		setupEconomy();
		getCommand("pstats").setExecutor(new pstatscommand(this));
	}

	@Override
	public void onDisable() {
		System.out.println(ANSI_RED + "Player Stats has been disabled! :) \n" + ANSI_BLUE + "By: 1S8/SuixideBunneh\n"
				+ ANSI_YELLOW + "Version: 1.0");
	}

	static Economy econ = null;

	public boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	@SuppressWarnings("null")
	public double getBalance(Player player) {
		if (econ == null || player == null) {
			return (Double) null;
		}
		return econ.getBalance(player);
	}

}
