package xyz.uhalexz.funii.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class DeathListener implements Listener {
    public final HashMap<UUID, Location> deathLocations;

    public DeathListener(HashMap<UUID, Location> deathLocations) {
        this.deathLocations = deathLocations;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location deathLocation = player.getLocation();
        deathLocations.put(player.getUniqueId(), deathLocation);

        TextComponent message = new TextComponent("You died! Use ");
        TextComponent backCommand = new TextComponent("/back");
        backCommand.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/back"));
        backCommand.setColor(ChatColor.GOLD);

        message.addExtra(backCommand);
        message.addExtra(" to return to your death location.");

        player.spigot().sendMessage(message);

    }
}
