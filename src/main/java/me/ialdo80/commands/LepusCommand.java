package me.ialdo80.commands;


import me.ialdo80.Lepus;
import me.ialdo80.utilities.chat.ChatUtil;
import me.ialdo80.utilities.command.BaseCommand;
import me.ialdo80.utilities.command.Command;
import me.ialdo80.utilities.command.CommandArgs;
import me.ialdo80.utilities.file.FileConfig;
import org.bukkit.entity.Player;

public class LepusCommand extends BaseCommand {

    private final FileConfig settingsConfig = Lepus.get().getSettingsConfig();

    @Command(name = "lepus", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        for (String lepuscommand : settingsConfig.getStringList("LANG.LEPUS_VERSION"))  {
            ChatUtil.message(player, lepuscommand);
        }
    }
}