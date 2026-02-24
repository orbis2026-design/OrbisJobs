package su.nightexpress.orbisjobs;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.orbisjobs.booster.BoosterManager;
import su.nightexpress.orbisjobs.api.booster.MultiplierType;
import su.nightexpress.orbisjobs.grind.GrindManager;
import su.nightexpress.orbisjobs.grind.GrindRegistry;
import su.nightexpress.orbisjobs.job.JobManager;
import su.nightexpress.orbisjobs.job.impl.Job;
import su.nightexpress.orbisjobs.user.JobUser;
import su.nightexpress.orbisjobs.user.UserManager;
import su.nightexpress.orbisjobs.zone.ZoneManager;

import java.util.Set;

public class JobsAPI {

    public static JobsPlugin instance;

    static void load(@NotNull JobsPlugin plugin) {
        instance = plugin;
    }

    static void clear() {
        instance = null;
    }

    @NotNull
    @Deprecated
    public static JobsPlugin getPlugin() {
        return instance();
    }

    public static boolean isLoaded() {
        return instance != null;
    }

    @NotNull
    public static JobsPlugin instance() {
        if (!isLoaded()) throw new IllegalStateException("API is not yet loaded!");

        return instance;
    }

    @NotNull
    public static GrindManager getGrindManager() {
        return instance().getGrindManager();
    }

    @NotNull
    public static GrindRegistry getGrindRegistry() {
        return instance().getGrindRegistry();
    }

    @NotNull
    public static JobManager getJobManager() {
        return instance().getJobManager();
    }

    @Nullable
    public static ZoneManager getZoneManager() {
        return instance().getZoneManager();
    }

    @Nullable
    public static BoosterManager getBoosterManager() {
        return instance().getBoosterManager();
    }

    @NotNull
    public static UserManager getUserManager() {
        return instance().getUserManager();
    }

    @NotNull
    public static JobUser getUserData(@NotNull Player player) {
        return getUserManager().getOrFetch(player);
    }

    @Nullable
    public static Job getJobById(@NotNull String id) {
        return getJobManager().getJobById(id);
    }

    @NotNull
    public static Set<Job> getJobs() {
        return getJobManager().getJobs();
    }

    public static double getBoost(@NotNull Player player, @NotNull Job job, @NotNull MultiplierType type) {
        BoosterManager manager = getBoosterManager();
        return manager == null ? 0D : manager.getTotalBoost(player, job, type);
    }

    public static double getBoostPercent(@NotNull Player player, @NotNull Job job, @NotNull MultiplierType type) {
        BoosterManager manager = getBoosterManager();
        return manager == null ? 0D : manager.getTotalBoostPercent(player, job, type);
    }
}
