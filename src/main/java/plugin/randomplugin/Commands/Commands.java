package plugin.randomplugin.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


@CommandAlias("SpawnMob")
public class Commands extends BaseCommand {
    @Subcommand("spawnmob")
    @Description("Genera un mob sin IA en la posición del jugador.")
    @CommandPermission("randomblock.spawnmob")
    public void onSpawnMob(Player player, @Default("ZOMBIE") EntityType mobType) {
        if (!mobType.isAlive()) {
            player.sendMessage("§cEl tipo de entidad proporcionado no es válido para un mob vivo.");
            return;
        }
        World world = player.getWorld();
        Location playerLocation = player.getLocation();
        LivingEntity mob = (LivingEntity) world.spawnEntity(playerLocation, mobType);
        mob.setAI(false);
        player.sendMessage("§a¡Se generó un mob del tipo §e" + mobType.name() + " §asin IA en tu posición!");
    }
    @Subcommand("stick")
    @Description("Sirve para descartar tus mobs")
    @CommandPermission("customstick.give")
    public void giveCustomStick(Player player) {
        ItemStack customStick = new ItemStack(Material.STICK);
        ItemMeta meta = customStick.getItemMeta();

        meta.setCustomModelData(1);
        meta.setDisplayName("§6Palo Descartador");
        customStick.setItemMeta(meta);

        player.getInventory().addItem(customStick);
        player.sendMessage("§a¡Has recibido el §6Palo Descartador§a!");
    }
}

