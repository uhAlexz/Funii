package xyz.uhalexz.funii.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AntiFB implements Listener {
    @EventHandler
    public void onFireballDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() == EntityType.FIREBALL && event.getEntity() instanceof Player) {
            Entity damager = event.getDamager();
            Player player = (Player) event.getEntity();

            if (damager instanceof Projectile fireball) {
                if (fireball.getShooter() == player) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
