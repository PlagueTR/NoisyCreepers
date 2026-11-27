package space.plague.plaguesnoisycreepers;

import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class VersionCompat {

    private VersionCompat() {
    }

    public static Component literal(String text) {
        return new TextComponent(text);
    }

    public static SoundEvent createSound(String path) {
        return new SoundEvent(new ResourceLocation(Main.MOD_ID, path));
    }

    public static SoundEvent registerSound(String path) {
        ResourceLocation id = new ResourceLocation(Main.MOD_ID, path);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

}
