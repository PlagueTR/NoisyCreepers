package space.plague.noisycreepers.config;

public class ModConfig {

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

        this.ambientFrequency = 80;
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