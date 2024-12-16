package xyz.uhalexz.funii.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    private static final String PREFIX = ChatColor.translateAlternateColorCodes('&', "&eFunii &r» ");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        switch (label.toLowerCase()) {
            case "gmc":
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(PREFIX + "You are now in " + ChatColor.GREEN + "Creative mode!");
                break;
            case "gms":
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(PREFIX + "You are now in " + ChatColor.GREEN + "Survival mode!");
                break;
            case "gma":
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(PREFIX + "You are now in " + ChatColor.GREEN + "Adventure mode!");
                break;
            case "gmsp":
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(PREFIX + "You are now in " + ChatColor.GREEN + "Spectator mode!");
                break;
            case "gm":
                if (args.length < 1) {
                    player.sendMessage(PREFIX + ChatColor.RED + "Usage: /gm <mode>");
                    return true;
                }

                String mode = args[0];
                switch (mode) {
                    case "survival" -> player.setGameMode(GameMode.SURVIVAL);
                    case "creative" -> player.setGameMode(GameMode.CREATIVE);
                    case "adventure" -> player.setGameMode(GameMode.ADVENTURE);
                    case "spectator" -> player.setGameMode(GameMode.SPECTATOR);
                    default -> {
                        player.sendMessage(PREFIX + ChatColor.RED + "Invalid mode!");
                        return true;
                    }
                }
                player.sendMessage(PREFIX + "Gamemode updated!");
                break;
            default:
                player.sendMessage(PREFIX + ChatColor.RED + "Unknown command!");
        }

        return true;
    }

}
