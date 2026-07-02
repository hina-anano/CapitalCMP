package me.hina.capSMP;

import mc.obliviate.inventory.InventoryAPI;
import me.hina.capSMP.command.HinaCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CapSMP extends JavaPlugin {
    public static CapSMP INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        HinaCommandManager.initialize();

        // ObliviateInvs API
        new InventoryAPI(this).init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
