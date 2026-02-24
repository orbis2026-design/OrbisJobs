package su.nightexpress.orbisjobs.grind.table.impl;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.grind.GrindReward;
import su.nightexpress.orbisjobs.grind.adapter.GrindAdapterFamily;
import su.nightexpress.orbisjobs.grind.table.GrindTable;
import su.nightexpress.orbisjobs.grind.table.SourceTable;
import su.nightexpress.nightcore.config.FileConfig;

public class BasicEntityGrindTable implements GrindTable {

    private final SourceTable entities;

    public BasicEntityGrindTable(@NotNull SourceTable entities) {
        this.entities = entities;
    }

    @NotNull
    public static BasicEntityGrindTable read(@NotNull FileConfig config, @NotNull String path) {
        SourceTable table = SourceTable.read(config, path + ".Mobs");

        return new BasicEntityGrindTable(table);
    }

    @Override
    public void write(@NotNull FileConfig config, @NotNull String path) {
        config.set(path + ".Mobs", this.entities);
    }

    @NotNull
    public GrindReward getMobReward(@NotNull Entity entity) {
        return this.entities.rollForEntityOrDefault(entity, GrindAdapterFamily.ENTITY);
    }
}
