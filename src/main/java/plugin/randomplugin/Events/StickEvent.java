package plugin.randomplugin.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StickEvent implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity clickedEntity = event.getRightClicked();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.STICK && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasCustomModelData() && meta.getCustomModelData() == 1) {
                Location entityLocation = clickedEntity.getLocation();
                clickedEntity.remove();

                Block block = entityLocation.getBlock();
                block.setType(Material.OAK_SIGN);
                if (block.getState() instanceof Sign) {
                    Sign sign = (Sign) block.getState();
                    sign.setLine(0, "§cMOB");
                    sign.setLine(1, "§eDESCARTADO");
                    sign.update();
                }

                player.sendMessage("§a¡Entidad descartada y cartel colocado en su posición!");
            }
        }
    }
}

