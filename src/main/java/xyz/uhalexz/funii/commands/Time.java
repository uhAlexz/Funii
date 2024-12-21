package xyz.uhalexz.funii.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.uhalexz.funii.Funii;

public class Time implements CommandExecutor {

    private final Funii plugin;

    public Time(Funii plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        String PREFIX = plugin.getConfig().getString("messages.prefix");

        World world = player.getWorld();

        switch(label.toLowerCase()) {
            case "day":
                world.setTime(1000);
                break;
            case "noon":
                world.setTime(6000);
                break;
            case "night":
                world.setTime(13000);
                break;
            case "midnight":
                world.setTime(18000);
                break;
            default:
                player.sendMessage(PREFIX + "Unknown command!");
        }

        return true;
    }
}
