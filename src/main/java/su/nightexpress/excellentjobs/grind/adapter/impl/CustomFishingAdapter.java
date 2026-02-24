package su.nightexpress.excellentjobs.grind.adapter.impl;

@Deprecated
public class CustomFishingAdapter /*extends AbstractGrindAdapter<Loot, ItemStack>*/ {

    /*public CustomFishingAdapter(@NotNull String name) {
        super(name);
    }

    @NotNull
    private static BukkitCustomFishingPlugin getAPI() {
        return BukkitCustomFishingPlugin.getInstance();
    }

    @Override
    public boolean canHandle(@NotNull ItemStack itemStack) {
        return getAPI().getItemManager().getCustomFishingItemID(itemStack) != null;
    }

    @Override
    @Nullable
    public Loot getTypeByName(@NotNull String name) {
        return getAPI().getLootManager().getLoot(name).orElse(null);
    }

    @Override
    @Nullable
    public Loot getType(@NotNull ItemStack itemStack) {
        String id = getAPI().getItemManager().getCustomFishingItemID(itemStack);
        if (id == null) return null;

        return getTypeByName(id);
    }

    @Override
    @NotNull
    public String getName(@NotNull Loot loot) {
        return loot.id();
    }

    @Override
    @NotNull
    public String toFullNameOfType(@NotNull Loot loot) {
        return "customfishing:" + super.toFullNameOfType(loot);
    }*/
}
