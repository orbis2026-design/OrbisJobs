package su.nightexpress.orbisjobs.hook.impl;

import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class LevelledMobsHook {

    public static int getLevel(@NotNull LivingEntity entity) {
        try {
            Class<?> pluginClass = Class.forName("io.github.arcaneplugins.levelledmobs.LevelledMobs");
            Object plugin = pluginClass.getMethod("getInstance").invoke(null);
            Object levelInterface = pluginClass.getMethod("getLevelInterface").invoke(plugin);
            Object level = levelInterface.getClass().getMethod("getLevelOfMob", LivingEntity.class).invoke(levelInterface, entity);

            return level instanceof Number number ? number.intValue() : 0;
        }
        catch (ReflectiveOperationException ignored) {
            return 0;
        }
    }
}
