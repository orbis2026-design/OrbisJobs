package su.nightexpress.orbisjobs.grind;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.grind.table.GrindTable;
import su.nightexpress.orbisjobs.job.impl.Job;

public interface GrindCalculator<T extends GrindTable> {

    @NotNull GrindReward calculate(@NotNull Job job, @NotNull T table);
}
