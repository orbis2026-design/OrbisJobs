package su.nightexpress.orbisjobs.grind.listener.impl;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.JobsPlugin;
import su.nightexpress.orbisjobs.grind.GrindManager;
import su.nightexpress.orbisjobs.grind.listener.GrindListener;
import su.nightexpress.orbisjobs.grind.table.impl.EnchantingGrindTable;
import su.nightexpress.orbisjobs.grind.type.impl.EnchantingGrindType;

public class EnchantingGrindListener extends GrindListener<EnchantingGrindTable, EnchantingGrindType> {

    private static final String DEBUG_ENCHANTING = "You enchanted item with %s %s.";

    public EnchantingGrindListener(@NotNull JobsPlugin plugin, @NotNull GrindManager grindManager, @NotNull EnchantingGrindType grindType) {
        super(plugin, grindManager, grindType);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onGrindEnchanting(EnchantItemEvent event) {
        Player player = event.getEnchanter();
        if (!this.grindManager.canGrinding(player)) return;

        event.getEnchantsToAdd().forEach((enchantment, level) -> {
            //Debugger.info(player, () -> DEBUG_ENCHANTING.formatted(LangUtil.getSerializedName(enchantment), NumberUtil.toRoman(level)));
            this.giveXP(player, (skill, table) -> table.getEnchantXP(enchantment, level));
        });
    }
}
