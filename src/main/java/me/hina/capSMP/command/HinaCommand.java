package me.hina.capSMP.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class HinaCommand {

    public abstract String getCommandName();

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    public void onExecute(CommandSender sender, String[] args) {

    }

    protected final List<String> findMatches(String arg, Iterable<String> array) {
        ArrayList<String> matches = new ArrayList<>();
        StringUtil.copyPartialMatches(arg.toLowerCase(), array, matches);
        return matches;
    }
}