package xyz.uhalexz.funii.listeners.fun;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class FBStick implements Listener {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final long COOLDOWN_TIME = 300;

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                break;
            default:
                return;
        }

        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();

        if (cooldowns.containsKey(playerId)) {
            long lastActionTime = cooldowns.get(playerId);
            if (currentTime - lastActionTime < COOLDOWN_TIME) {

                String message = ChatColor.RED + "Please try again in a few seconds!";
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(message));
                return;

            }
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.STICK && item.getItemMeta() != null) {
            ItemMeta meta = item.getItemMeta();

            if (meta.hasDisplayName() && ChatColor.stripColor(meta.getDisplayName()).equals("Fireball Stick")) {
                Fireball fireball = player.launchProjectile(Fireball.class);
                Vector direction = player.getLocation().getDirection();
                fireball.setVelocity(direction.multiply(2));
                fireball.setIsIncendiary(false);

                if (player.isSneaking()) {
                    fireball.setYield(5);
                } else {
                    fireball.setYield(2);
                }

                cooldowns.put(playerId, currentTime);
            }
        } else if (item.getType() == Material.FIRE_CHARGE && item.getItemMeta() != null) {

            event.setCancelled(true);

            Fireball fireball = player.launchProjectile(Fireball.class);
            Vector direction = player.getLocation().getDirection();
            fireball.setVelocity(direction.multiply(2));
            fireball.setIsIncendiary(false);
            fireball.setYield(2);

            cooldowns.put(playerId, currentTime);

        }


    }

}
