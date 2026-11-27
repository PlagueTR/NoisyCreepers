package space.plague.plaguesnoisycreepers;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class VersionCompat {

    private VersionCompat() {
    }

    public static Component literal(String text) {
        return Component.literal(text);
    }

    public static SoundEvent createSound(String path) {
        return SoundEvent.createVariableRangeEvent(id(path));
    }

    public static SoundEvent registerSound(String path) {
        ResourceLocation id = id(path);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.tryBuild(Main.MOD_ID, path);
    }

}
