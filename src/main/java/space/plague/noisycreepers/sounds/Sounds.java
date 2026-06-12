package space.plague.noisycreepers.sounds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

import space.plague.noisycreepers.Main;

public class Sounds {

    public static final SoundEvent CREEPER_STEP = registerSound("entity.creeper.step");

    public static final SoundEvent CREEPER_AMBIENT = registerSound("entity.creeper.ambient");

    public static void register() {
        Main.LOGGER.info("[Plague's Noisy Creepers] Registering Sound Events...");
    }

    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.fromNamespaceAndPath("plaguesnoisycreepers", name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

}
