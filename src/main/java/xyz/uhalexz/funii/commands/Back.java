package xyz.uhalexz.funii.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import xyz.uhalexz.funii.Funii;

import java.util.HashMap;
import java.util.UUID;

public class Back implements CommandExecutor {

    private Funii plugin = null;
    private HashMap<UUID, Location> deathLocations = null;
    private String PREFIX = null;

    public Back(Funii plugin, HashMap<UUID, Location> deathLocations) {
        this.plugin = plugin;
        this.deathLocations = deathLocations;
        this.PREFIX = plugin.getConfig().getString("messages.prefix");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        UUID playerId = player.getUniqueId();

        if (deathLocations.containsKey(playerId)) {
            Location backLocation = deathLocations.get(playerId);
            player.teleport(backLocation);
            player.sendMessage(PREFIX + "You have been teleported to your last death location!");
            deathLocations.remove(playerId);
        } else {
            player.sendMessage(PREFIX + "You don't have a saved location to go back to.");
        }

        return true;
    }
}
