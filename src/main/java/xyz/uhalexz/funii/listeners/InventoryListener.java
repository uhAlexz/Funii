package xyz.uhalexz.funii.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;

        Player viewer = (Player) event.getWhoClicked();
        if (event.getView().getTitle().endsWith("'s Inventory")) {
            Player target = Bukkit.getPlayer(event.getView().getTitle().replace("'s Inventory", "").trim());

            if (target != null) {
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Funii"), () -> {
                    target.updateInventory();
                }, 1L);
            }
        }

    }

}
