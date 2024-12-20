package xyz.uhalexz.funii.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.uhalexz.funii.Funii;

import java.util.Arrays;

public class Stick implements CommandExecutor {

    private Funii plugin = null;
    private String PREFIX = null;

    public Stick(Funii plugin) {
        this.plugin = plugin;
        this.PREFIX = plugin.getConfig().getString("messages.prefix");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        ItemStack fbStick = new ItemStack(Material.STICK);
        ItemMeta meta = fbStick.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.YELLOW + "Fireball Stick");
            meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setLore(Arrays.asList(ChatColor.GRAY + "Right Click to shoot Fireballs!"));
            fbStick.setItemMeta(meta);
        }

        player.getInventory().addItem(fbStick);
        sender.sendMessage(PREFIX + "Check your inventory for your " + ChatColor.GOLD + "Fireball Stick!");

        return true;
    }
}
