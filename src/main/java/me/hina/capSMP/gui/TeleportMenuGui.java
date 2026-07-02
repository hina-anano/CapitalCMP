package me.hina.capSMP.gui;

import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;
import me.hina.capSMP.utils.GuiUtils;
import me.hina.capSMP.utils.ItemUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class TeleportMenuGui extends Gui {
    public TeleportMenuGui(@NonNull Player player) {
        super(player, "teleport-menu", "傳送", 3);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        ItemStack pane = ItemUtils.createItemNoTooltips(Material.GRAY_STAINED_GLASS_PANE);

        GuiUtils.addIcons(this, List.of(
                        "退田田田廳田田田田",
                        "田田田星返一田田田",
                        "田田田田二田田田田"))
                .setIcon('田', new Icon(pane))
                .setIcon('退', new Icon(ItemUtils.createItem(Material.ARROW, "§c返回")).onClick(_ -> new MainMenuGui(player).open()))

                .setIcon('廳', new Icon(ItemUtils.createItem(Material.ENDER_EYE, "§f傳送到大廳")).onClick(_ -> {
                    player.performCommand("warp lobby");
                }))
                .setIcon('星', new Icon(ItemUtils.createItem(Material.NETHER_STAR, "§f??")))
                .setIcon('返', new Icon(ItemUtils.createItem(Material.RECOVERY_COMPASS, "§f返回上一個地方")).onClick(_ -> {
                    player.performCommand("back");
                }))
                .setIcon('一', new Icon(ItemUtils.createItem(Material.WHITE_BED, "§f回家")).onClick(_ -> {
                    player.performCommand("home");
                }))
                .setIcon('二', new Icon(ItemUtils.createItem(Material.CHORUS_FRUIT, "§f隨機傳送")).onClick(_ -> {
                    player.performCommand("rtp");
                }));
    }
}
