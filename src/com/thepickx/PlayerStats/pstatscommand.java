package com.thepickx.PlayerStats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.bgsoftware.superiorskyblock.api.SuperiorSkyblockAPI;

public class pstatscommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;

	public pstatscommand(Main plugin) {
		this.plugin = plugin;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		/* To create a new instance of the PlayerStatistics. */
		Player player = (Player) sender;
		PlayerStatistics statistic = new PlayerStatistics(player.getUniqueId());
		new SuperiorSkyblockAPI();
		/* The you can call statistic.getBalance etc... */

		if (cmd.getName().equalsIgnoreCase("pstats")) {
			if (args.length == 0) {
				if (statistic.hasIsland() == null) {
					sender.sendMessage("Showing player stats for " + statistic.getDisplayName()
							+ ":\n- Island level: No island found!\n- Team leader: No island found!\n- Balance: $"
							+ statistic.getBalanceFormatted() + "\n- Soul Shards: " + statistic.getMobcoinBalance()
							+ "\n- Cosmetic Coins: " + statistic.getCosmeticToken() + " coins\n- Kill/death ratio: "
							+ statistic.getKillTotal() + "/" + statistic.getDeathTotal() + " = "
							+ statistic.getKillDeathRatio() + " K/d\n- Fly Time: " + statistic.Fly_in_Hour() + "h "
							+ statistic.Fly_in_Minutes() + "m " + statistic.Fly_in_Second() + "s \n- XP: "
							+ statistic.getExperience() + "\n- Playtime: " + statistic.Playtime_in_Hour() + "h "
							+ statistic.Playtime_in_Minutes() + "m " + statistic.Playtime_in_Second() + "s");
					return true;
				} else {

					sender.sendMessage("Showing player stats for " + statistic.getDisplayName() + ":\n- Island level: "
							+ statistic.getIslandLevel() + "\n- Team leader: " + statistic.getIslandLeader()
							+ "\n- Balance: $" + statistic.getBalanceFormatted() + "\n- Soul Shards: "
							+ statistic.getMobcoinBalance() + "\n- Cosmetic Coins: " + statistic.getCosmeticToken()
							+ " coins\n- Kill/death ratio: " + statistic.getKillTotal() + "/"
							+ +statistic.getDeathTotal() + " = " + statistic.getKillDeathRatio() + " K/d\n- Fly Time: "
							+ statistic.Fly_in_Hour() + "h " + statistic.Fly_in_Minutes() + "m "
							+ statistic.Fly_in_Second() + "s \n- XP: " + statistic.getExperience() + "\n- Playtime: "
							+ statistic.Playtime_in_Hour() + "h " + statistic.Playtime_in_Minutes() + "m "
							+ statistic.Playtime_in_Second() + "s");
					return true;
				}
			}
			String target = args[0];
			if (Bukkit.getPlayerExact(target) != null) {
				OtherStatistics targetP = new OtherStatistics(Bukkit.getPlayer(target).getUniqueId());

				if (args.length == 1) {
					if (targetP.hasIsland() == null) {
						sender.sendMessage("Showing player stats for " + targetP.getDisplayName()
								+ ":\n- Island level: No island found!\n- Team leader: No island found!\n- Balance: $"
								+ targetP.getBalanceFormatted() + "\n- Soul Shards: " + targetP.getMobcoinBalance()
								+ "\n- Cosmetic Coins: " + targetP.getCosmeticToken() + " coins\n- Kill/death ratio: "
								+ targetP.getKillTotal() + "/" + targetP.getDeathTotal() + " = "
								+ targetP.getKillDeathRatio() + " K/d\n- Fly Time: " + targetP.Fly_in_Hour() + "h "
								+ targetP.Fly_in_Minutes() + "m " + targetP.Fly_in_Second() + "s \n- XP: "
								+ targetP.getExperience() + "\n- Playtime: " + targetP.Playtime_in_Hour() + "h "
								+ targetP.Fly_in_Minutes() + "m " + targetP.Fly_in_Second() + "s");
						return true;
					} else {
						sender.sendMessage("Showing player stats for " + targetP.getDisplayName()
								+ ":\n- Island level: " + targetP.getIslandLevel() + "\n- Team leader: "
								+ targetP.getIslandLeader() + "\n- Balance: $" + targetP.getBalanceFormatted()
								+ "\n- Soul Shards: " + targetP.getMobcoinBalance() + "\n- Cosmetic Coins: "
								+ targetP.getCosmeticToken() + " coins\n- Kill/death ratio: " + targetP.getKillTotal()
								+ "/" + targetP.getDeathTotal() + " = " + targetP.getKillDeathRatio()
								+ " K/d\n- Fly Time: " + targetP.Fly_in_Hour() + "h " + targetP.Fly_in_Minutes() + "m "
								+ targetP.Fly_in_Second() + "s \n- XP: " + targetP.getExperience() + "\n- Playtime: "
								+ targetP.Playtime_in_Hour() + "h " + targetP.Fly_in_Minutes() + "m "
								+ targetP.Fly_in_Second() + "s");
						return true;
					}
				} else if (args.length >= 2) {
					sender.sendMessage(
							"Wrong argument!\nExample:\n/pstats - To show your stats.\n/pstats <player> - To show other player stats.");
					return false;

				}
			} else {

				sender.sendMessage(
						"There is no such player in town, boi!\nExample:\n/pstats - To show your stats.\n/pstats <player> - To show other player stats.");
			}

		}
		return false;

	}
}