package su.nightexpress.orbisjobs.grind.provider;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.JobsPlugin;
import su.nightexpress.orbisjobs.grind.listener.GrindListener;
import su.nightexpress.orbisjobs.grind.GrindManager;
import su.nightexpress.orbisjobs.grind.table.GrindTable;
import su.nightexpress.orbisjobs.grind.type.GrindType;

public interface GrindListenerProvider<E extends GrindTable, T extends GrindType<E>> {

    @NotNull GrindListener<E, T> provide(@NotNull JobsPlugin plugin, @NotNull GrindManager grindManager, @NotNull T grindType);
}
