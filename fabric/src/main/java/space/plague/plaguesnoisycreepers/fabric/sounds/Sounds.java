package space.plague.plaguesnoisycreepers.fabric.sounds;

import net.minecraft.sounds.SoundEvent;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.VersionCompat;

public class Sounds {

    public static final SoundEvent CREEPER_STEP = VersionCompat.registerSound("entity.creeper.step");

    public static final SoundEvent CREEPER_AMBIENT = VersionCompat.registerSound("entity.creeper.ambient");

    public static void register() {
        Main.LOGGER.info("[" + Main.MOD_NAME + "] Registering Sound Events...");
    }

}
