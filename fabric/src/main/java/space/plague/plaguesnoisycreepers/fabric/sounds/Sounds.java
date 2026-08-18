package space.plague.plaguesnoisycreepers.fabric.sounds;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import space.plague.plaguesnoisycreepers.Main;

public class Sounds {

    public static final SoundEvent CREEPER_STEP = registerSound("entity.creeper.step");

    public static final SoundEvent CREEPER_AMBIENT = registerSound("entity.creeper.ambient");

    public static void register() {
        Main.LOGGER.info("[" + Main.MOD_NAME + "] Registering Sound Events...");
    }

    private static SoundEvent registerSound(String name) {

        ResourceLocation id = new ResourceLocation("plaguesnoisycreepers", name);

        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

}
