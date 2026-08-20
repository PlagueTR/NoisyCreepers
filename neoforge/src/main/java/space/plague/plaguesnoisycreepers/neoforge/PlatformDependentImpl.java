package space.plague.plaguesnoisycreepers.neoforge;

import net.minecraft.sounds.SoundEvent;

import net.neoforged.fml.loading.FMLPaths;

import space.plague.plaguesnoisycreepers.neoforge.sounds.Sounds;

import java.nio.file.Path;

public class PlatformDependentImpl {

    public static Path getConfigDirectory() { return FMLPaths.CONFIGDIR.get(); }

    public static SoundEvent getCreeperStep() { return Sounds.CREEPER_STEP.get(); }

    public static SoundEvent getCreeperAmbient() { return Sounds.CREEPER_AMBIENT.get(); }

}
