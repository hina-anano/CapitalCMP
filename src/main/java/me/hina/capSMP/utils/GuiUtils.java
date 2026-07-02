package me.hina.capSMP.utils;

import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiUtils {
    public static final ItemStack EMPTY_PANE = ItemUtils.createItemNoTooltips(Material.BLACK_STAINED_GLASS_PANE);

    public static Action addIcons(Gui gui, List<String> symbols) {
        return new Action(gui, symbols);
    }

    public static class Action {
        private final Gui gui;
        // char, slots
        private final HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        public Action(Gui gui, List<String> symbols) {
            this.gui = gui;

            int row = 0;
            for (String line : symbols) {
                int col = 0;
                for (char c : line.toCharArray()) {
                    if (c == ' ') continue;

                    ArrayList<Integer> list = this.map.get(c);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(row * 9 + col);
                    map.put(c, list);
                    col++;
                }
                row++;
            }
        }

        public Action setIcon(char c, ItemStack itemStack) {
            return setIcon(c, new Icon(itemStack));
        }

        public Action setIcon(char c, Icon icon) {
            ArrayList<Integer> slots = map.get(c);
            if (slots != null) {
                for (int slot : slots) {
                    this.gui.addItem(slot, icon);
                }
            }
            return this;
        }
    }
}
