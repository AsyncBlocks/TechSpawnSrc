package br.arabe.techspawn;

import br.arabe.techspawn.Controlador.SpawnLocations;
import br.arabe.techspawn.Yaml.Spawns;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TechSpawn extends JavaPlugin {

    private static TechSpawn plugin;
    private static Spawns spawnsConfig;
    private static SpawnLocations spawnLocations;

    @Override
    public void onEnable() {
        plugin = this;
        iniciarConfig();
        spawnsConfig = new Spawns();
        spawnLocations = new SpawnLocations();
    }

    private void iniciarConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static TechSpawn getPlugin() {
        return plugin;
    }

    public static FileConfiguration getSpawnsConfig() {
        return spawnsConfig.getConfig();
    }

    public static void saveSpawnsConfig() {
        spawnsConfig.saveConfig();
    }

    public static SpawnLocations getSpawnLocations() {
        return spawnLocations;
    }
}
