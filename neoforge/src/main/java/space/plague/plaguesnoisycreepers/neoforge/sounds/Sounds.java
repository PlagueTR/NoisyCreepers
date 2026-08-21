package space.plague.plaguesnoisycreepers.neoforge.sounds;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

import net.neoforged.neoforge.registries.DeferredRegister;

import space.plague.plaguesnoisycreepers.Main;

import java.util.function.Supplier;

public class Sounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "plaguesnoisycreepers");

    public static final Supplier<SoundEvent> CREEPER_STEP = registerSound("entity.creeper.step");

    public static final Supplier<SoundEvent> CREEPER_AMBIENT = registerSound("entity.creeper.ambient");

    public static void register() {
        Main.LOGGER.info("[" + Main.MOD_NAME + "] Registering Sound Events...");
    }

    public static Supplier<SoundEvent> registerSound(String name) {

        Identifier id = Identifier.fromNamespaceAndPath("plaguesnoisycreepers", name);

        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

}
