package me.donleo123.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		getLogger().info("-----------------------");
		getLogger().info(getName() + " is Enabled!");
		getLogger().info("-----------------------");
	}

	public void onDisable() {
		getLogger().info("-----------------------");
		getLogger().info(getName() + " is Disabled!");
		getLogger().info("-----------------------");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("playerinfo") && sender.hasPermission("playerinfo.other")) {

				if (args.length == 0) {
					sender.sendMessage("§cIncorrect Player Name!");
					return false;
				} else {
					Player pl = Bukkit.getPlayer(args[0]);

					if (pl == null) {
						sender.sendMessage("§cPlayer is not online.");

						return false;
					}

					String uuid = p.getUniqueId().toString();
					String language = me.smessie.MultiLanguage.bukkit.AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);

					// ENGELS

					if (language.equalsIgnoreCase("EN")) {
						sender.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Player's Info "+ ChatColor.BLACK + "=-");
						sender.sendMessage(ChatColor.YELLOW + "Player's Name: " + ChatColor.AQUA + pl.getName());
						sender.sendMessage(ChatColor.YELLOW + "UUID: " + ChatColor.AQUA + pl.getUniqueId());
						sender.sendMessage("");
						sender.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Item Info " + ChatColor.BLACK + "=-");
						sender.sendMessage(ChatColor.YELLOW + "Item in hand: " + ChatColor.AQUA + pl.getItemInHand().getType());
						sender.sendMessage(ChatColor.YELLOW + "Amount: " + ChatColor.AQUA + pl.getItemInHand().getAmount());
					}

					// NEDERLANDS

					if (language.equalsIgnoreCase("NL")) {
						sender.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Player's Info "
								+ ChatColor.BLACK + "=-");
						sender.sendMessage(ChatColor.YELLOW + "Speler naam: " + ChatColor.AQUA + pl.getName());
						sender.sendMessage(ChatColor.YELLOW + "UUID: " + ChatColor.AQUA + pl.getUniqueId());
						sender.sendMessage("");
						sender.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Item Info " + ChatColor.BLACK + "=-");
						sender.sendMessage(ChatColor.YELLOW + "Item in hand: " + ChatColor.AQUA + pl.getItemInHand().getType());
						sender.sendMessage(ChatColor.YELLOW + "Hoeveelheid: " + ChatColor.AQUA + pl.getItemInHand().getAmount());
					}
					// ENGELS
				}

			}

		}

		if (label.equalsIgnoreCase("playerinfo-me") && sender.hasPermission("playerinfo.me")) {

			Player p = (Player) sender;
			String uuid = p.getUniqueId().toString();
			String language = me.smessie.MultiLanguage.bukkit.AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);

			// NEDERLANDS

			if (language.equalsIgnoreCase("NL")) {
				sender.sendMessage(
						ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Player's Info " + ChatColor.BLACK + "=-");
				sender.sendMessage(ChatColor.YELLOW + "Speler naam: " + ChatColor.AQUA + p.getName());
				sender.sendMessage(ChatColor.YELLOW + "UUID: " + ChatColor.AQUA + p.getUniqueId());
				sender.sendMessage("");
				sender.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Item Info " + ChatColor.BLACK + "=-");
				sender.sendMessage(ChatColor.YELLOW + "Item in hand: " + ChatColor.AQUA + p.getItemInHand().getType());
				sender.sendMessage(ChatColor.YELLOW + "Hoeveelheid: " + ChatColor.AQUA + p.getItemInHand().getAmount());
			}

			// ENGELS

			if (language.equalsIgnoreCase("EN")) {
				sender.sendMessage(
						ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Player's Info " + ChatColor.BLACK + "=-");
				sender.sendMessage(ChatColor.YELLOW + "Your Name: " + ChatColor.AQUA + p.getName());
				sender.sendMessage(ChatColor.YELLOW + "UUID: " + ChatColor.AQUA + p.getUniqueId());
				sender.sendMessage("");
				sender.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Item Info " + ChatColor.BLACK + "=-");
				sender.sendMessage(ChatColor.YELLOW + "Item in hand: " + ChatColor.AQUA + p.getItemInHand().getType());
				sender.sendMessage(ChatColor.YELLOW + "Amount: " + ChatColor.AQUA + p.getItemInHand().getAmount());
			}

		}
		return false;
	}

}