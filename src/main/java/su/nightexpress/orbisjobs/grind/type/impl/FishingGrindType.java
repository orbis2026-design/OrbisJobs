package su.nightexpress.orbisjobs.grind.type.impl;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.grind.adapter.GrindAdapterFamily;
import su.nightexpress.orbisjobs.grind.table.GrindTable;
import su.nightexpress.orbisjobs.grind.table.SourceReward;
import su.nightexpress.orbisjobs.grind.table.SourceTable;
import su.nightexpress.orbisjobs.grind.table.impl.FishingGrindTable;
import su.nightexpress.orbisjobs.grind.type.GrindType;
import su.nightexpress.nightcore.config.FileConfig;

import java.util.Map;

public class FishingGrindType extends GrindType<FishingGrindTable> {

    public FishingGrindType(@NotNull String id) {
        super(id, FishingGrindTable.class);
    }

    @Override
    public boolean isToolRequired() {
        return true;
    }

    @Override
    @NotNull
    public FishingGrindTable readTable(@NotNull FileConfig config, @NotNull String path) {
        return FishingGrindTable.read(config, path);
    }

    @Override
    public @NotNull GrindTable convertTable(@NotNull Map<String, SourceReward> convertedEntries) {
        return new FishingGrindTable(SourceTable.EMPTY, SourceTable.fromConverted(convertedEntries, GrindAdapterFamily.ITEM));
    }
}
