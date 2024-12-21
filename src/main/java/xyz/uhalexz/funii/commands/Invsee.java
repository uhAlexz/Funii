package xyz.uhalexz.funii.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import xyz.uhalexz.funii.Funii;

public class Invsee implements CommandExecutor {

    private final Funii plugin;


    public Invsee(Funii plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        String PREFIX = plugin.getConfig().getString("messages.prefix");

        if (args.length < 1) {
            player.sendMessage(PREFIX + "Usage: /invsee <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null || !target.isOnline()) {
            player.sendMessage(PREFIX + "Player doesn't exist.");
            return true;
        }

        player.openInventory(target.getInventory());
        player.sendMessage(PREFIX + "Viewing " + ChatColor.GREEN + target.getName() + "'s" + ChatColor.RESET + " inventory!");
        return true;
    }
}
