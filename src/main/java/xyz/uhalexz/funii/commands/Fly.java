package xyz.uhalexz.funii.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.uhalexz.funii.Funii;

public class Fly implements CommandExecutor {
    private final Funii plugin;


    public Fly(Funii plugin) {
        this.plugin = plugin;
    }



    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        String PREFIX = plugin.getConfig().getString("messages.prefix");

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
