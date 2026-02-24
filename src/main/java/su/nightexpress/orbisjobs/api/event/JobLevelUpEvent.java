package su.nightexpress.orbisjobs.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.data.impl.JobData;
import su.nightexpress.orbisjobs.user.JobUser;

public class JobLevelUpEvent extends JobLevelEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public JobLevelUpEvent(@NotNull Player player, @NotNull JobUser user, @NotNull JobData data, int oldLevel) {
        super(player, user, data, oldLevel);
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
