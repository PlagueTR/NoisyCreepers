package space.plague.plaguesnoisycreepers.config.gui;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

import net.minecraft.client.Minecraft;

import net.minecraft.network.chat.TextComponent;
import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.config.ModConfig;

import java.util.HashMap;
import java.util.Map;

public class GeneralOptionsScreen {

    public static ConfigBuilder getConfigBuilder() {

        ModConfig defaults = new ModConfig();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(Minecraft.getInstance().screen)
                .setTitle(new TextComponent("Plague's Noisy Creepers - General"));

        builder.setSavingRunnable(Main::saveConfig);

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        ConfigCategory general = builder.getOrCreateCategory(new TextComponent("General"));

        general.addEntry(entryBuilder.startBooleanToggle(new TextComponent("Enable Mod"), Main.getConfig().isEnableMod())
                .setDefaultValue(defaults.isEnableMod())
                .setTooltip(new TextComponent("Enables the mod."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableMod(newValue))
                .build());

        general.addEntry(entryBuilder.startBooleanToggle(new TextComponent("Enable Steps"), Main.getConfig().isEnableSteps())
                .setDefaultValue(defaults.isEnableSteps())
                .setTooltip(new TextComponent("Enables footstep sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableSteps(newValue))
                .build());

        general.addEntry(entryBuilder.startIntSlider(new TextComponent("Steps volume"), (int)(Main.getConfig().getStepVolume() * 100), 0, 100)
                .setDefaultValue((int)(defaults.getStepVolume() * 100))
                .setTooltip(new TextComponent("Sets the volume level for creeper footstep sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setStepVolume(((float)newValue)/100.0F))
                .build());

        general.addEntry(entryBuilder.startBooleanToggle(new TextComponent("Enable Ambient"), Main.getConfig().isEnableAmbient())
                .setDefaultValue(defaults.isEnableAmbient())
                .setTooltip(new TextComponent("Enables ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setEnableAmbient(newValue))
                .build());

        general.addEntry(entryBuilder.startIntSlider(new TextComponent("Ambient volume"), (int)(Main.getConfig().getAmbientVolume() * 100), 0, 100)
                .setDefaultValue((int)(defaults.getAmbientVolume() * 100))
                .setTooltip(new TextComponent("Sets the volume level for creeper ambient sounds."))
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

        general.addEntry(entryBuilder.startSelector(new TextComponent("Ambient Frequency"), frequencies_s, frequencies_is.get(Main.getConfig().getAmbientFrequency()))
                .setDefaultValue(frequencies_is.get(defaults.getAmbientFrequency()))
                .setTooltip(new TextComponent("Sets the frequency for creeper ambient sounds."))
                .setSaveConsumer(newValue -> Main.getConfig().setAmbientFrequency(frequencies_si.get(newValue)))
                .build());

        builder.transparentBackground();

        return builder;

    }

}
