package me.hina.capSMP.command;

import me.hina.capSMP.CapSMP;
import me.hina.capSMP.command.commands.MenuCommand;
import org.bukkit.command.PluginCommand;

public class HinaCommandManager {

    public static final HinaCommand[] COMMANDS = {
            new MenuCommand()
    };

    public static void initialize() {
        for (HinaCommand hinaCommand : COMMANDS) {
            PluginCommand pluginCommand = CapSMP.INSTANCE.getCommand(hinaCommand.getCommandName());

            if (pluginCommand == null)
                continue;

            pluginCommand.setExecutor((commandSender, command, s, args) -> {
                hinaCommand.onExecute(commandSender, args);
                return true;
            });

            pluginCommand.setTabCompleter(hinaCommand::onTabComplete);
        }
    }
}