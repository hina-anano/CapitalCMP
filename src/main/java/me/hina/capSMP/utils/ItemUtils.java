package me.hina.capSMP.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemUtils {

    public static ItemStack createItem(Material material, String customName, String... lore) {
        return createItem(material, customName, Arrays.asList(lore));
    }

    public static ItemStack createItemNoExtraTooltips(Material material, String customName, String... lore) {
        ItemStack itemStack = createItem(material, customName, Arrays.asList(lore));

        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }

    public static ItemStack createItem(Material material, String customName, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return itemStack;
        }

        if (lore != null && !lore.isEmpty()) {
            itemMeta.setLore(lore);
        }

        itemMeta.setDisplayName(customName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createItem(Material material, Component customName, List<Component> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return itemStack;
        }

        if (lore != null && !lore.isEmpty()) {
            itemMeta.lore(lore);
        }

        itemMeta.customName(customName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createItemNoTooltips(Material material) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setHideTooltip(true);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
