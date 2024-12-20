package xyz.uhalexz.funii.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.uhalexz.funii.Funii;

public class Fly implements CommandExecutor {
    private Funii plugin = null;
    private String PREFIX = null;

    public Fly(Funii plugin) {
        this.plugin = plugin;
        this.PREFIX = plugin.getConfig().getString("messages.prefix");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage(PREFIX + "Flying is now " + ChatColor.RED + "disabled!");
        } else {
            player.setAllowFlight(true);
            player.sendMessage(PREFIX + "Flying is now " + ChatColor.GREEN + "enabled!");
        }
        return true;

    }
}
