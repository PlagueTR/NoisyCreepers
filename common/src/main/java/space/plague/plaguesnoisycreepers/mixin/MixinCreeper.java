package space.plague.plaguesnoisycreepers.mixin;

import org.jetbrains.annotations.Nullable;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.PlatformDependent;
import space.plague.plaguesnoisycreepers.config.ModConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(Creeper.class)
public abstract class MixinCreeper extends Monster {

    protected MixinCreeper(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public int getAmbientSoundInterval() {
        return Main.getConfig().getAmbientFrequency();
    }

    @Override
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

        return PlatformDependent.getCreeperAmbient();
    }

    @Override
    public void playAmbientSound() {
        SoundEvent sound = this.getAmbientSound();
        if (sound != null) {
            this.playSound(sound, Main.getConfig().getAmbientVolume() * 2.0F, this.getVoicePitch());
        }
    }

    @Override
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

        this.playSound(PlatformDependent.getCreeperStep(), mc.getStepVolume() * 0.3F, 1.0F);

    }

}
