package space.plague.plaguesnoisycreepers.config.gui;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

import net.minecraft.client.gui.screens.Screen;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.config.ModConfig;

import java.util.HashMap;
import java.util.Map;

import static space.plague.plaguesnoisycreepers.VersionCompat.literal;

public final class GeneralOptionsScreen {

    private static final String[] FREQUENCY_NAMES = {
            "Default",
            "Occasional",
            "Rare",
            "Very Rare",
            "Extremely Rare"
    };

    private GeneralOptionsScreen() {
    }

    public static Screen create(Screen parent) {

        ModConfig defaults = new ModConfig();
        ModConfig config = Main.getConfig();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(literal("Plague's Noisy Creepers - General"));

        builder.setSavingRunnable(Main::saveConfig);

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        ConfigCategory general = builder.getOrCreateCategory(literal("General"));

        general.addEntry(entryBuilder.startBooleanToggle(literal("Enable Mod"), config.isEnableMod())
                .setDefaultValue(defaults.isEnableMod())
                .setTooltip(literal("Enables the mod."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableMod(newValue))
                .build());

        general.addEntry(entryBuilder.startBooleanToggle(literal("Enable Steps"), config.isEnableSteps())
                .setDefaultValue(defaults.isEnableSteps())
                .setTooltip(literal("Enables footstep sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableSteps(newValue))
                .build());

        general.addEntry(entryBuilder.startIntSlider(literal("Steps volume"), Math.round(config.getStepVolume() * 100), 0, 100)
                .setDefaultValue(Math.round(defaults.getStepVolume() * 100))
                .setTooltip(literal("Sets the volume level for creeper footstep sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setStepVolume(newValue / 100.0F))
                .build());

        general.addEntry(entryBuilder.startBooleanToggle(literal("Enable Ambient"), config.isEnableAmbient())
                .setDefaultValue(defaults.isEnableAmbient())
                .setTooltip(literal("Enables ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableAmbient(newValue))
                .build());

        general.addEntry(entryBuilder.startIntSlider(literal("Ambient volume"), Math.round(config.getAmbientVolume() * 100), 0, 100)
                .setDefaultValue(Math.round(defaults.getAmbientVolume() * 100))
                .setTooltip(literal("Sets the volume level for creeper ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setAmbientVolume(newValue / 100.0F))
                .build());

        Map<String, Integer> frequenciesByName = new HashMap<>();
        Map<Integer, String> namesByFrequency = new HashMap<>();
        for (int i = 0; i < FREQUENCY_NAMES.length; i++) {
            frequenciesByName.put(FREQUENCY_NAMES[i], ModConfig.AMBIENT_FREQUENCIES[i]);
            namesByFrequency.put(ModConfig.AMBIENT_FREQUENCIES[i], FREQUENCY_NAMES[i]);
        }

        String current = namesByFrequency.get(ModConfig.nearestAmbientFrequency(config.getAmbientFrequency()));

        general.addEntry(entryBuilder.startSelector(literal("Ambient Frequency"), FREQUENCY_NAMES, current)
                .setDefaultValue(namesByFrequency.get(defaults.getAmbientFrequency()))
                .setTooltip(literal("Sets the frequency for creeper ambient sounds."))
                .setSaveConsumer(newValue -> {
                    Integer frequency = frequenciesByName.get(newValue);
                    if (frequency != null) {
                        Main.getConfig().setAmbientFrequency(frequency);
                    }
                })
                .build());

        builder.transparentBackground();

        return builder.build();

    }

}
