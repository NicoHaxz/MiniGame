package plugin.randomplugin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import plugin.randomplugin.Utils.Utils;

import java.util.HashSet;

public class PlayerJoinEvent implements Listener {
    private HashSet<String> playersJoinedBefore = new HashSet<>();

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!playersJoinedBefore.contains(player.getName())) {
            player.sendTitle(Utils.chatcolor("&5&lTutorial"), "§8¡Bienvenido " + player.getName() + " Inicia Tutorial!", 0, 80, 20);
            player.sendMessage(Utils.chatcolor("&4 Para colocar Mobs usa el Comando /spawnmobs"));
            player.sendMessage(Utils.chatcolor("&4 Para colocar Bloques usa el Comando /randomblocks"));
            player.sendMessage(Utils.chatcolor("&4 Para descartar Mobs usa /spawnmobs stick"));
            player.sendMessage(Utils.chatcolor("&a Dev: @NicoHaxz in X"));

            playersJoinedBefore.add(player.getName());
        }
    }
}

