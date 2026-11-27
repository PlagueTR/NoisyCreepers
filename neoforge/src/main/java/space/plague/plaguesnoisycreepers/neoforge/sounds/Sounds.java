package space.plague.plaguesnoisycreepers.neoforge.sounds;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import net.neoforged.neoforge.registries.DeferredRegister;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.VersionCompat;

import java.util.function.Supplier;

public class Sounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Main.MOD_ID);

    public static final Supplier<SoundEvent> CREEPER_STEP = registerSound("entity.creeper.step");

    public static final Supplier<SoundEvent> CREEPER_AMBIENT = registerSound("entity.creeper.ambient");

    public static void register() {
        Main.LOGGER.info("[" + Main.MOD_NAME + "] Registering Sound Events...");
    }

    private static Supplier<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> VersionCompat.createSound(name));
    }

}
