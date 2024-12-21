package plugin.randomplugin;

import co.aikar.commands.BukkitCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.randomplugin.Commands.AdminCommands;
import plugin.randomplugin.Commands.Commands;
import plugin.randomplugin.Events.Gamemode;
import plugin.randomplugin.Events.PlayerJoinEvent;
import plugin.randomplugin.Events.StickEvent;

public final class RandomPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new StickEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Gamemode(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        initCommand();
        System.out.println("§cPlugin Iniciado sin errores");
        System.out.println("§aDev: NicoHaxz");

    }
    public void initCommand () {
        final BukkitCommandManager commandManager = new BukkitCommandManager(this);
        commandManager.registerCommand(new AdminCommands());
        commandManager.registerCommand(new Commands());
    }

    @Override
    public void onDisable() {
        System.out.println("§cPlugin Apagado, Buen Juego");

    }
}
