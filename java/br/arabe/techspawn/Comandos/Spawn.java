package br.arabe.techspawn.Comandos;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import static br.arabe.techspawn.TechSpawn.*;

public class Spawn implements CommandExecutor {

    private static HashMap<String, Location> SpawnLocation = getSpawnLocations().getSpawnLocations();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return false;

        Player player = (Player) commandSender;
        if(getSpawnsConfig().getConfigurationSection("Spawns") == null) return false;
        for (String spawns : getSpawnsConfig().getConfigurationSection("Spawns").getKeys(false)) {
            String targetPerm = getSpawnsConfig().getString("Spawns."+spawns+".perm");
            if(player.hasPermission(targetPerm)) {

                break;
            }
        }

        return true;
    }
}
