package su.nightexpress.orbisjobs.grind.type.impl;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.grind.adapter.GrindAdapterFamily;
import su.nightexpress.orbisjobs.grind.table.GrindTable;
import su.nightexpress.orbisjobs.grind.table.SourceReward;
import su.nightexpress.orbisjobs.grind.table.SourceTable;
import su.nightexpress.orbisjobs.grind.table.impl.BasicBlockGrindTable;
import su.nightexpress.orbisjobs.grind.type.GrindType;
import su.nightexpress.nightcore.config.FileConfig;

import java.util.Map;

public class MiningGrindType extends GrindType<BasicBlockGrindTable> {

    public MiningGrindType(@NotNull String id) {
        super(id, BasicBlockGrindTable.class);
    }

    @Override
    public boolean isToolRequired() {
        return true;
    }

    @Override
    @NotNull
    public BasicBlockGrindTable readTable(@NotNull FileConfig config, @NotNull String path) {
        return BasicBlockGrindTable.read(config, path);
    }

    @Override
    public @NotNull GrindTable convertTable(@NotNull Map<String, SourceReward> convertedEntries) {
        return new BasicBlockGrindTable(SourceTable.fromConverted(convertedEntries, GrindAdapterFamily.BLOCK));
    }
}
