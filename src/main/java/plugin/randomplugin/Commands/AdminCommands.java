package plugin.randomplugin.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.Random;

@CommandAlias("randomblock")
public class AdminCommands extends BaseCommand {
    private Location selectedLocation;

    @Subcommand("select")
    @Description("Selecciona la posición de un bloque mirando a un bloque.")
    @CommandPermission("randomblock.select")
    public void onSelect(Player player) {
        Location targetBlock = player.getTargetBlockExact(5).getLocation();
        if (targetBlock != null) {
            selectedLocation = targetBlock;
            player.sendMessage("§a¡Bloque seleccionado en la posición: §e" + targetBlock.toString() + "!");
        } else {
            player.sendMessage("§cNo estás mirando ningún bloque cercano.");
        }
    }

    @Subcommand("generate")
    @Description("Genera un bloque aleatorio en la posición seleccionada o cerca.")
    @CommandPermission("randomblock.generate")
    public void onGenerate(Player player) {
        if (selectedLocation == null) {
            player.sendMessage("§cPrimero selecciona una posición con §e/randomblock select§c.");
            return;
        }

        Material randomMaterial = getRandomBlockMaterial();
        if (randomMaterial == null) {
            player.sendMessage("§cNo se pudo generar un bloque aleatorio válido.");
            return;
        }

        selectedLocation.getBlock().setType(randomMaterial);
        player.sendMessage("§aSe generó un bloque aleatorio: §e" + randomMaterial + " §aen la posición seleccionada.");
    }

    @Subcommand("random")
    @Description("Genera bloques aleatorios en la posición del jugador.")
    @CommandPermission("randomblock.random")
    public void onRandom(Player player) {
        Location playerLocation = player.getLocation();
        Material randomMaterial = getRandomBlockMaterial();

        if (randomMaterial != null) {
            playerLocation.getBlock().setType(randomMaterial);
            player.sendMessage("§a¡Se generó un bloque aleatorio §e" + randomMaterial.name() + " §aen tu posición!");
        } else {
            player.sendMessage("§cNo se pudo generar un bloque.");
        }
    }

    private Material getRandomBlockMaterial() {
        Material[] materials = Material.values();
        Random random = new Random();

        Material randomMaterial;
        do {
            randomMaterial = materials[random.nextInt(materials.length)];
        } while (!randomMaterial.isBlock() || randomMaterial.isAir());

        return randomMaterial;
    }
}

