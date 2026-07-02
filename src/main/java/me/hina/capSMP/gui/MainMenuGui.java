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

public class MainMenuGui extends Gui {
    public MainMenuGui(@NonNull Player player) {
        super(player, "main-menu", "主菜單", 3);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        ItemStack pane = ItemUtils.createItemNoTooltips(Material.GRAY_STAINED_GLASS_PANE);

        Icon partyIcon = new Icon(ItemUtils.createItem(Material.ENCHANTING_TABLE, "§fParty", List.of(
                "§f/party create <隊伍名稱>：建立自己的隊伍 (需花費 1000 紫水晶)",
                "§f/party invite <ID>：(隊長) 邀請玩家加入隊伍",
                "§f/party join <隊伍名稱>：申請加入隊伍 (收到邀請者可直接秒進)",
                "§f/party accept：(隊長) 同意加入申請",
                "§f/party leave：退出目前的隊伍 (有 30 秒倒數機制)",
                "§f/party info：查看隊伍成員與資訊",
                "§f/party kick <ID>：(隊長) 踢出隊員",
                "§f/party disband：(隊長) 解散隊伍"
        )));

        GuiUtils.addIcons(this, List.of(
                "退田田田嗨田田田黑",
                "田田隊簽傳交晶田田",
                "箱田田田田田田田插"))
                .setIcon('田', new Icon(pane))
                .setIcon('退', new Icon(ItemUtils.createItem(Material.BARRIER, "§c退出")).onClick(_ -> player.closeInventory()))
                .setIcon('嗨', new Icon(ItemUtils.createItem(Material.BUDDING_AMETHYST, "§fThe Capital SMP 資本伺服器", List.of("§fIP: tpc.cfh.tw:10402", "§f困難"))))
                .setIcon('黑', new Icon(ItemUtils.createItem(Material.WARPED_SIGN, "§bDiscord網址")).onClick(_ -> {
                    player.sendMessage(Component.text("https://discord.gg/q2jcBJ9Qxc").clickEvent(ClickEvent.openUrl("https://discord.gg/q2jcBJ9Qxc")));
                    player.closeInventory();
                }))

                .setIcon('隊', partyIcon)
                .setIcon('簽', new Icon(ItemUtils.createItemNoExtraTooltips(Material.WHITE_BUNDLE, "§f每日簽到")).onClick(_ -> {
                    player.performCommand("daily");
                }))
                .setIcon('傳', new Icon(ItemUtils.createItem(Material.COMPASS, "§f傳送")).onClick(_ -> {
                    new TeleportMenuGui(player).open();
                }))
                .setIcon('交', new Icon(ItemUtils.createItem(Material.EMERALD, "§f交易")))
                .setIcon('晶', new Icon(ItemUtils.createItem(Material.AMETHYST_CLUSTER, "§f手持GUI")))

                .setIcon('箱', new Icon(ItemUtils.createItem(Material.ENDER_CHEST, "§5打開終界箱")).onClick(_ -> player.openInventory(player.getEnderChest())))
                .setIcon('插', new Icon(ItemUtils.createItem(Material.REDSTONE_TORCH, "§8Plugin developed by Hina", "§8Contact hina.anano if you encountered any issue.")));

    }
}
