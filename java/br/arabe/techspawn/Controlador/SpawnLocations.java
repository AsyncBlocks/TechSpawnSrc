package br.arabe.techspawn.Controlador;

import br.arabe.techspawn.Comandos.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Objects;

import static br.arabe.techspawn.TechSpawn.*;

public class SpawnLocations {

    private final HashMap<String, Location> SpawnLocations;
    private final HashMap<String,String> PatchLocations;

    public SpawnLocations() {
        SpawnLocations = new HashMap<>();
        PatchLocations = new HashMap<>();
        final FileConfiguration config = getSpawnsConfig();
        final ConfigurationSection configurationSection = getSpawnsConfig().getConfigurationSection("Spawns");
        if(configurationSection == null) return;
        configurationSection.getKeys(false).forEach(string -> {
            String searchKey = config.getString("Spawns."+string+".perm");
            double x,y,z;
            x = config.getDouble("Spawns."+string+".x");
            y = config.getDouble("Spawns."+string+".y");
            z = config.getDouble("Spawns."+string+".z");
            float pitch,yaw;
            pitch = (float) config.getDouble("Spawns."+string+".pitch");
            yaw = (float) config.getDouble("Spawns."+string+".yaw");
            World world = Bukkit.getWorld(Objects.requireNonNull(config.getString("Spawns." + string + ".world")));
            Location location = new Location(world,x,y,z,yaw,pitch);
            PatchLocations.put(searchKey,string);
            SpawnLocations.put(searchKey,location);
        });
    }

    public HashMap<String, Location> getSpawnLocations() {
        return SpawnLocations;
    }

    public HashMap<String, String> getPatchLocations() {
        return PatchLocations;
    }
}
