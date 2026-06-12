package space.plague.noisycreepers.mixin;

import org.jspecify.annotations.Nullable;
import space.plague.noisycreepers.Main;
import space.plague.noisycreepers.config.ModConfig;
import space.plague.noisycreepers.sounds.Sounds;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Creeper.class)
public class MixinCreeper {

    @Unique
    public int getAmbientSoundInterval() {
        return Main.getConfig().getAmbientFrequency();
    }

    @Unique
    protected @Nullable SoundEvent getAmbientSound() {

        ModConfig mc = Main.getConfig();

        if (!mc.isEnableMod()) {
            return null;
        }
        if (!mc.isEnableAmbient()){
            return null;
        }
        if (mc.getAmbientVolume() == 0.0F) {
            return null;
        }

        return Sounds.CREEPER_AMBIENT;
    }

    @Unique
    public void makeSound(final @Nullable SoundEvent sound) {
        if (sound != null) {
            Creeper creeper = (Creeper) (Object) this;
            creeper.playSound(sound, Main.getConfig().getAmbientVolume() * 2.0F, creeper.getVoicePitch());
        }
    }

    @Unique
    protected SoundEvent getStepSound() {
        return Sounds.CREEPER_STEP;
    }

    @Unique
    protected void playStepSound(final BlockPos pos, final BlockState blockState) {

        ModConfig mc = Main.getConfig();

        if (!mc.isEnableMod()) {
            return;
        }
        if (!mc.isEnableSteps()){
            return;
        }
        if (mc.getStepVolume() == 0.0F) {
            return;
        }

        Creeper creeper = (Creeper) (Object) this;
        creeper.playSound(this.getStepSound(), mc.getStepVolume() * 0.3F, 1.0F);

    }

}