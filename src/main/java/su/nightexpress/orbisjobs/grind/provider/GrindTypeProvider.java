package su.nightexpress.orbisjobs.grind.provider;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.grind.type.GrindType;

public interface GrindTypeProvider<T extends GrindType<?>> {

    @NotNull T provide(@NotNull String id);
}
