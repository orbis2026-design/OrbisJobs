package su.nightexpress.orbisjobs.grind.listener;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.nightcore.manager.AbstractListener;
import su.nightexpress.orbisjobs.JobsPlugin;
import su.nightexpress.orbisjobs.grind.GrindManager;
import su.nightexpress.orbisjobs.grind.GrindCalculator;
import su.nightexpress.orbisjobs.grind.table.GrindTable;
import su.nightexpress.orbisjobs.grind.type.GrindType;

public abstract class GrindListener<E extends GrindTable, T extends GrindType<E>> extends AbstractListener<JobsPlugin> {

    protected final GrindManager grindManager;
    protected final T            grindType;

    public GrindListener(@NotNull JobsPlugin plugin, @NotNull GrindManager grindManager, @NotNull T grindType) {
        super(plugin);
        this.grindManager = grindManager;
        this.grindType = grindType;
    }

    protected void giveXP(@NotNull Player player, @NotNull GrindCalculator<E> calculator) {
        this.giveXP(player, null, calculator);
    }

    protected void giveXP(@NotNull Player player, @Nullable ItemStack tool, @NotNull GrindCalculator<E> calculator) {
        this.grindManager.giveXP(player, tool, this.grindType, calculator);
    }
}
