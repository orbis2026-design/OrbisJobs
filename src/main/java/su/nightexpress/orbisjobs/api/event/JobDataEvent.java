package su.nightexpress.orbisjobs.api.event;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.orbisjobs.data.impl.JobData;
import su.nightexpress.orbisjobs.user.JobUser;

public abstract class JobDataEvent extends JobEvent {

    protected final JobUser user;
    protected final JobData jobData;

    public JobDataEvent(@NotNull Player player, @NotNull JobUser user, @NotNull JobData jobData) {
        super(false, player, jobData.getJob());
        this.user = user;
        this.jobData = jobData;
    }

    @NotNull
    public final JobData getJobData() {
        return this.jobData;
    }

    @NotNull
    public final JobUser getUser() {
        return user;
    }
}
