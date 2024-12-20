package xyz.uhalexz.funii.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.uhalexz.funii.Funii;

public class FuniiCMD implements CommandExecutor {
    private final Funii plugin;

    public FuniiCMD(Funii plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String action = args[0];

        if (action.equalsIgnoreCase("reload")) {

            plugin.reloadConfig();
            sender.sendMessage(plugin.getConfig().getString("messages.reloadMessage"));

            if (plugin.getConfig().getBoolean("funCommands.stickEnabled")) {
                plugin.getCommand("stick").setExecutor(new Stick(plugin));
            } else {
                plugin.getCommand("stick").setExecutor(new DisabledCMD());
            }

        } else {
            sender.sendMessage(ChatColor.YELLOW + "Funii\n" + ChatColor.RESET + ChatColor.BOLD + "/funii reload" + ChatColor.RESET + " - Reload the whole entire plugin!\n\nDeveloped by " + ChatColor.BLUE + "uhalexz_" + ChatColor.RESET + "!");
        }

        return true;
    }
}
