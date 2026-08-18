package space.plague.plaguesnoisycreepers;

import net.minecraft.sounds.SoundEvent;

import java.nio.file.Path;

public class PlatformDependent {

    @dev.architectury.injectables.annotations.ExpectPlatform
    public static Path getConfigDirectory() {
        throw new AssertionError();
    }

    @dev.architectury.injectables.annotations.ExpectPlatform
    public static SoundEvent getCreeperStep() { throw new AssertionError(); }

    @dev.architectury.injectables.annotations.ExpectPlatform
    public static SoundEvent getCreeperAmbient() { throw new AssertionError(); }

}
