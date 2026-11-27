package space.plague.plaguesnoisycreepers.config;

public class ModConfig {

    public static final int[] AMBIENT_FREQUENCIES = {80, 120, 160, 240, 360};

    private static final int MIN_AMBIENT_FREQUENCY = 20;

    private boolean enableMod;

    private boolean enableSteps;

    private boolean enableAmbient;

    private float stepVolume;

    private float ambientVolume;

    private int ambientFrequency;

    public ModConfig() {
        this.enableMod = true;

        this.enableSteps = true;

        this.enableAmbient = true;

        this.stepVolume = 0.5F;

        this.ambientVolume = 0.5F;

        this.ambientFrequency = AMBIENT_FREQUENCIES[0];
    }

    public void sanitize() {
        ModConfig defaults = new ModConfig();

        this.stepVolume = clampVolume(this.stepVolume, defaults.stepVolume);

        this.ambientVolume = clampVolume(this.ambientVolume, defaults.ambientVolume);

        if (this.ambientFrequency < MIN_AMBIENT_FREQUENCY) {
            this.ambientFrequency = defaults.ambientFrequency;
        }
    }

    private static float clampVolume(float volume, float fallback) {
        if (Float.isNaN(volume) || Float.isInfinite(volume)) {
            return fallback;
        }
        return Math.max(0.0F, Math.min(1.0F, volume));
    }

    public static int nearestAmbientFrequency(int frequency) {
        int nearest = AMBIENT_FREQUENCIES[0];
        for (int preset : AMBIENT_FREQUENCIES) {
            if (Math.abs(preset - frequency) < Math.abs(nearest - frequency)) {
                nearest = preset;
            }
        }
        return nearest;
    }

    public boolean isEnableMod() {
        return enableMod;
    }

    public void setEnableMod(boolean enableMod) {
        this.enableMod = enableMod;
    }

    public boolean isEnableSteps() {
        return enableSteps;
    }

    public void setEnableSteps(boolean enableSteps) {
        this.enableSteps = enableSteps;
    }

    public boolean isEnableAmbient() {
        return enableAmbient;
    }

    public void setEnableAmbient(boolean enableAmbient) {
        this.enableAmbient = enableAmbient;
    }

    public float getStepVolume() {
        return stepVolume;
    }

    public void setStepVolume(float stepVolume) {
        this.stepVolume = stepVolume;
    }

    public float getAmbientVolume() {
        return ambientVolume;
    }

    public void setAmbientVolume(float ambientVolume) {
        this.ambientVolume = ambientVolume;
    }

    public int getAmbientFrequency() {
        return ambientFrequency;
    }

    public void setAmbientFrequency(int ambientFrequency) {
        this.ambientFrequency = ambientFrequency;
    }

}
