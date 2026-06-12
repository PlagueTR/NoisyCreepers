package space.plague.noisycreepers.config.gui;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import space.plague.noisycreepers.Main;
import space.plague.noisycreepers.config.ModConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralOptionsScreen {

    public static ConfigBuilder getConfigBuilder() {

        ModConfig defaults = new ModConfig();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(Minecraft.getInstance().screen)
                .setTitle(Component.literal("Plague's Noisy Creepers - General"));

        builder.setSavingRunnable(Main::saveConfig);

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        ConfigCategory general = builder.getOrCreateCategory(Component.literal("General"));

        general.addEntry(entryBuilder.startBooleanToggle(Component.literal("Enable Mod"), Main.getConfig().isEnableMod())
                .setDefaultValue(defaults.isEnableMod())
                .setTooltip(Component.literal("Enables the mod."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableMod(newValue))
                .build());

        general.addEntry(entryBuilder.startBooleanToggle(Component.literal("Enable Steps"), Main.getConfig().isEnableSteps())
                .setDefaultValue(defaults.isEnableSteps())
                .setTooltip(Component.literal("Enables footstep sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableSteps(newValue))
                .build());

        general.addEntry(entryBuilder.startIntSlider(Component.literal("Steps volume"), (int)(Main.getConfig().getStepVolume() * 100), 0, 100)
                .setDefaultValue((int)(defaults.getStepVolume() * 100))
                .setTooltip(Component.literal("Sets the volume level for creeper footstep sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setStepVolume(((float)newValue)/100.0F))
                .build());

        general.addEntry(entryBuilder.startBooleanToggle(Component.literal("Enable Ambient"), Main.getConfig().isEnableAmbient())
                .setDefaultValue(defaults.isEnableAmbient())
                .setTooltip(Component.literal("Enables ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableAmbient(newValue))
                .build());

        general.addEntry(entryBuilder.startIntSlider(Component.literal("Ambient volume"), (int)(Main.getConfig().getAmbientVolume() * 100), 0, 100)
                .setDefaultValue((int)(defaults.getAmbientVolume() * 100))
                .setTooltip(Component.literal("Sets the volume level for creeper ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setAmbientVolume(((float)newValue)/100.0F))
                .build());


        String[] frequencies_s = new String[]{
                "Default",
                "Occasional",
                "Rare",
                "Very Rare",
                "Extremely Rare"
        };
        int[] frequencies_i = new int[]{
                80,
                120,
                160,
                240,
                360
        };

        Map<String, Integer> frequencies_si = new HashMap<>();
        Map<Integer, String> frequencies_is = new HashMap<>();
        for (int i = 0; i < frequencies_s.length; i++){
            frequencies_si.put(frequencies_s[i], frequencies_i[i]);
            frequencies_is.put(frequencies_i[i], frequencies_s[i]);
        }

        general.addEntry(entryBuilder.startSelector(Component.literal("Ambient Frequency"), frequencies_s, frequencies_is.get(Main.getConfig().getAmbientFrequency()))
                .setDefaultValue(frequencies_is.get(defaults.getAmbientFrequency()))
                .setTooltip(Component.literal("Sets the frequency for creeper ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setAmbientFrequency(frequencies_si.get(newValue)))
                .build());

        builder.transparentBackground();

        return builder;

    }

}
