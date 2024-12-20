package xyz.uhalexz.funii;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.uhalexz.funii.commands.*;
import xyz.uhalexz.funii.commands.completers.FCompleter;
import xyz.uhalexz.funii.commands.completers.GMCompleter;
import xyz.uhalexz.funii.listeners.AntiFB;
import xyz.uhalexz.funii.listeners.DeathListener;
import xyz.uhalexz.funii.listeners.fun.FBStick;

import java.util.HashMap;
import java.util.UUID;


public final class Funii extends JavaPlugin {

    private final HashMap<UUID, Location> deathLocations = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");

        getDataFolder();
        saveDefaultConfig();

        getCommand("fly").setExecutor(new Fly(this));
        getCommand("gm").setExecutor(new Gamemode(this));
        getCommand("gmc").setExecutor(new Gamemode(this));
        getCommand("gms").setExecutor(new Gamemode(this));
        getCommand("gma").setExecutor(new Gamemode(this));
        getCommand("gmsp").setExecutor(new Gamemode(this));
        getCommand("back").setExecutor(new Back(this, deathLocations));

        getCommand("funii").setExecutor(new FuniiCMD(this));
        getCommand("funii").setTabCompleter(new FCompleter());

        getCommand("gm").setTabCompleter(new GMCompleter());

        getServer().getPluginManager().registerEvents(new FBStick(), this);
        getServer().getPluginManager().registerEvents(new AntiFB(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(deathLocations), this);

        if (getConfig().getBoolean("funCommands.stickEnabled")) {
            getCommand("stick").setExecutor(new Stick(this));
        } else {
            getCommand("stick").setExecutor(new DisabledCMD());
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
        saveConfig();
    }
}
