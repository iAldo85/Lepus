package me.ialdo80;

import me.ialdo80.utilities.command.CommandManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import lombok.Getter;
import lombok.Setter;
import me.ialdo80.utilities.file.FileConfig;
import me.ialdo80.commands.*;

import java.util.ArrayList;

@Getter @Setter
public final class Lepus extends JavaPlugin {

    public static Plugin plugin;
    private CommandManager commandManager;
    private FileConfig settingsConfig;

    @Override
    public void onEnable() {
        this.settingsConfig = new FileConfig(this, "config.yml");

        this.commandManager = new CommandManager(this, new ArrayList<>());
        this.registerCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void registerCommand() {
        new LepusCommand();
    }
    public static Lepus get() { return getPlugin(Lepus.class); }
}
