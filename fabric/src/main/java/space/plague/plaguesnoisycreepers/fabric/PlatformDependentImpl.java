package space.plague.plaguesnoisycreepers.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.sounds.SoundEvent;
import space.plague.plaguesnoisycreepers.fabric.sounds.Sounds;

import java.nio.file.Path;

public class PlatformDependentImpl {

    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static SoundEvent getCreeperStep() { return Sounds.CREEPER_STEP; }

    public static SoundEvent getCreeperAmbient() { return Sounds.CREEPER_AMBIENT; }

}
