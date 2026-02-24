package su.nightexpress.orbisjobs.grind.adapter.impl;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.orbisjobs.grind.adapter.AbstractGrindAdapter;

import java.lang.reflect.Method;

public class EvenMoreFishAdapter extends AbstractGrindAdapter<Object, ItemStack> {

    private static final String DELIMITER = ":";

    public EvenMoreFishAdapter(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean canHandle(@NotNull ItemStack itemStack) {
        Object api = getApi();
        if (api == null) return false;

        Object result = invoke(api, "isFish", new Class<?>[]{ItemStack.class}, itemStack);
        return result instanceof Boolean bool && bool;
    }

    @Override
    @Nullable
    public Object getTypeByName(@NotNull String name) {
        String[] split = name.split(DELIMITER);
        if (split.length < 2) return null;

        Object api = getApi();
        if (api == null) return null;

        return invoke(api, "getFish", new Class<?>[]{String.class, String.class}, split[0], split[1]);
    }

    @Override
    @Nullable
    public Object getType(@NotNull ItemStack itemStack) {
        Object api = getApi();
        if (api == null) return null;

        return invoke(api, "getFish", new Class<?>[]{ItemStack.class}, itemStack);
    }

    @Override
    @NotNull
    public String getName(@NotNull Object fish) {
        Object rarity = invoke(fish, "getRarity", new Class<?>[]{});
        Object rarityId = rarity == null ? null : invoke(rarity, "getId", new Class<?>[]{});
        Object fishName = invoke(fish, "getName", new Class<?>[]{});

        if (rarityId == null || fishName == null) {
            return fish.toString();
        }

        return rarityId + DELIMITER + fishName;
    }

    @Override
    @NotNull
    public String toFullNameOfType(@NotNull Object fish) {
        return "evenmorefish:" + super.toFullNameOfType(fish);
    }

    @Nullable
    private static Object getApi() {
        try {
            Class<?> pluginClass = Class.forName("com.oheers.fish.EvenMoreFish");
            Object plugin = pluginClass.getMethod("getInstance").invoke(null);
            return pluginClass.getMethod("getApi").invoke(plugin);
        }
        catch (ReflectiveOperationException ignored) {
            return null;
        }
    }

    @Nullable
    private static Object invoke(@NotNull Object target, @NotNull String method, @NotNull Class<?>[] parameterTypes, Object... args) {
        try {
            Method targetMethod = target.getClass().getMethod(method, parameterTypes);
            return targetMethod.invoke(target, args);
        }
        catch (ReflectiveOperationException ignored) {
            return null;
        }
    }
}
