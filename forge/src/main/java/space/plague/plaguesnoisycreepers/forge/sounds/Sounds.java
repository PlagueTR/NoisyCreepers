package space.plague.plaguesnoisycreepers.forge.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import space.plague.plaguesnoisycreepers.Main;

public class Sounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "plaguesnoisycreepers");

    public static final RegistryObject<SoundEvent> CREEPER_STEP = registerSound("entity.creeper.step");

    public static final RegistryObject<SoundEvent> CREEPER_AMBIENT = registerSound("entity.creeper.ambient");

    public static void register() {
        Main.LOGGER.info("[" + Main.MOD_NAME + "] Registering Sound Events...");
    }

    public static RegistryObject<SoundEvent> registerSound(String name) {

        ResourceLocation id = new ResourceLocation("plaguesnoisycreepers", name);

        return SOUNDS.register(name, () -> new SoundEvent(id));
    }

}
