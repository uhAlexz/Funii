package xyz.uhalexz.funii.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisabledCMD implements CommandExecutor {

    private static final String PREFIX = ChatColor.translateAlternateColorCodes('&', "&eFunii &r» ");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(PREFIX + "This command has been" + ChatColor.RED + "disabled" + ChatColor.RESET + "by an administrator. Please contact one to get it enabled!");
        return true;
    }
}
