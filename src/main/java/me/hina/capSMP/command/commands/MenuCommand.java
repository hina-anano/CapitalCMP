package me.hina.capSMP.command.commands;

import me.hina.capSMP.command.HinaCommand;
import me.hina.capSMP.gui.MainMenuGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MenuCommand extends HinaCommand {
    @Override
    public String getCommandName() {
        return "menu";
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return super.onTabComplete(sender, command, alias, args);
    }

    @Override
    public void onExecute(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            new MainMenuGui(player).open();
        }
    }
}
