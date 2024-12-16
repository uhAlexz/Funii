package xyz.uhalexz.funii;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.uhalexz.funii.commands.Fly;
import xyz.uhalexz.funii.commands.FuniiCMD;
import xyz.uhalexz.funii.commands.Gamemode;
import xyz.uhalexz.funii.commands.completers.FCompleter;
import xyz.uhalexz.funii.commands.completers.GMCompleter;
import xyz.uhalexz.funii.listeners.AntiFB;
import xyz.uhalexz.funii.listeners.fun.FBStick;


public final class Funii extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");

        getDataFolder();
        saveDefaultConfig();

        getCommand("fly").setExecutor(new Fly());
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gma").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());

        getCommand("funii").setExecutor(new FuniiCMD(this));
        getCommand("funii").setTabCompleter(new FCompleter());

        getCommand("gm").setTabCompleter(new GMCompleter());

        getServer().getPluginManager().registerEvents(new FBStick(), this);
        getServer().getPluginManager().registerEvents(new AntiFB(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
        saveConfig();
    }
}
