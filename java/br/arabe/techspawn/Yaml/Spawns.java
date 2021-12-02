package br.arabe.techspawn.Yaml;

import br.arabe.techspawn.Comandos.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static br.arabe.techspawn.TechSpawn.*;

public class Spawns {

    private File file;
    private FileConfiguration fileConfiguration;

    public Spawns() {
        file = new File(getPlugin().getDataFolder(),"Spawns.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(this.file);

        if(!file.exists()) {
            try {
                file.createNewFile();
                getConfig().createSection("Spawns");
                getConfig().createSection("Spawns.teste");
                getConfig().set("Spawns.teste.perm","teste.spawn.usar");
                getConfig().set("Spawns.teste.world","world");
                getConfig().set("Spawns.teste.x",0);
                getConfig().set("Spawns.teste.y",0);
                getConfig().set("Spawns.teste.z",0);
                getConfig().set("Spawns.teste.pitch",0);
                getConfig().set("Spawns.teste.yaw",0);
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"[TechSpawn] Spawns.yml foi criada!");
                this.saveConfig();
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[TechSpawn] Nao foi Possivel criar a Spawns.yml");
            }
        }
    }

    public FileConfiguration getConfig() {
        return this.fileConfiguration;
    }

    public void saveConfig() {
        try {
            this.fileConfiguration.save(this.file);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"[TechSpawn] Spawns.yml foi Salvada!");
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[TechSpawn] Spawns.yml Erro ao Salvar (Nao foi Salvo)!");
        }
    }

}
