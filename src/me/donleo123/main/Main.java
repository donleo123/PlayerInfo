package me.donleo123.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getLogger().info("-----------------------");
		getLogger().info(getName() + "is Enabled!");
		getLogger().info("-----------------------");
	}
	
	public void onDisable() {
		getLogger().info("-----------------------");
		getLogger().info(getName() + "is Disabled!");
		getLogger().info("-----------------------");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(label.equalsIgnoreCase("playerinfo") && sender.hasPermission("playerinfo.info")) {
            p.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Player's Info " + ChatColor.BLACK + "=-");
			p.sendMessage(ChatColor.YELLOW + "Player name: " + ChatColor.AQUA + p.getName());
			p.sendMessage(ChatColor.YELLOW + "UUID: " + ChatColor.AQUA + p.getUniqueId());
			p.sendMessage("");
			p.sendMessage(ChatColor.BLACK + "-=" + ChatColor.DARK_RED + " Item Info " + ChatColor.BLACK + "=-");
			p.sendMessage(ChatColor.YELLOW + "Current item in hand: " + ChatColor.AQUA + p.getItemInHand().getType());
			p.sendMessage(ChatColor.YELLOW + "Amount: " + ChatColor.AQUA + p.getItemInHand().getAmount());
		}
		return false;
	}
}
