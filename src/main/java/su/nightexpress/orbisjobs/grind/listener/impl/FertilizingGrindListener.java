package su.nightexpress.orbisjobs.grind.listener.impl;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.JobsPlugin;
import su.nightexpress.orbisjobs.grind.GrindManager;
import su.nightexpress.orbisjobs.grind.listener.GrindListener;
import su.nightexpress.orbisjobs.grind.table.impl.BasicBlockGrindTable;
import su.nightexpress.orbisjobs.grind.type.impl.BasicBlockGrindType;

import java.util.HashSet;
import java.util.Set;

public class FertilizingGrindListener extends GrindListener<BasicBlockGrindTable, BasicBlockGrindType> {

    public FertilizingGrindListener(@NotNull JobsPlugin plugin, @NotNull GrindManager grindManager, @NotNull BasicBlockGrindType grindType) {
        super(plugin, grindManager, grindType);
    }

    @EventHandler
    public void onFertilize(BlockFertilizeEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;
        if (!this.grindManager.canGrinding(player)) return;

        Set<BlockState> blocks = new HashSet<>();
        blocks.add(event.getBlock().getState());
        blocks.addAll(event.getBlocks());

        blocks.forEach(blockState -> {
            this.giveXP(player, (job, table) -> table.getBlockXP(blockState));
        });
    }
}
