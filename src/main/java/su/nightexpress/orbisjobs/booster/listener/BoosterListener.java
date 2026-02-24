package su.nightexpress.orbisjobs.booster.listener;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.JobsPlugin;
import su.nightexpress.orbisjobs.booster.BoosterManager;
import su.nightexpress.nightcore.manager.AbstractListener;

public class BoosterListener extends AbstractListener<JobsPlugin> {

    private final BoosterManager manager;

    public BoosterListener(@NotNull JobsPlugin plugin, @NotNull BoosterManager manager) {
        super(plugin);
        this.manager = manager;
    }

//    @EventHandler(priority = EventPriority.MONITOR)
//    public void onBoosterJoin(PlayerJoinEvent event) {
//
//    }
}
