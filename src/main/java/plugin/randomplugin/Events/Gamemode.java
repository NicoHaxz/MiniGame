package plugin.randomplugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Gamemode implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        for (Player player1 : Bukkit.getOnlinePlayers()) {
            if (player.getGameMode() == GameMode.SPECTATOR) {
                event.setCancelled(true);
                player1.sendMessage("§cNo puedes moverte mientras estás en modo espectador " + player.getName() + " Tramposo!!!!!");
            }
        }
    }
}
