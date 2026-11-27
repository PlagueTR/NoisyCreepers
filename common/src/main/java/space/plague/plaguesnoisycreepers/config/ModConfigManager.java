package space.plague.plaguesnoisycreepers.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.PlatformDependent;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ModConfigManager {

    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    private static ModConfig config = new ModConfig();

    private ModConfigManager() {
    }

    private static Path getConfigFile() {
        return PlatformDependent.getConfigDirectory().resolve(Main.MOD_ID + ".json");
    }

    public static ModConfig getConfig() {
        return config;
    }

    public static void load() {
        Path configFile = getConfigFile();

        if (Files.exists(configFile)) {
            try (Reader reader = Files.newBufferedReader(configFile, StandardCharsets.UTF_8)) {
                ModConfig parsed = GSON.fromJson(reader, ModConfig.class);
                if (parsed != null) {
                    config = parsed;
                }
            } catch (IOException | JsonParseException e) {
                Main.LOGGER.warn("[" + Main.MOD_NAME + "] Couldn't load config file " + configFile + ", using defaults", e);
                config = new ModConfig();
            }
        }

        config.sanitize();
        save();
    }

    public static void save() {
        Path configFile = getConfigFile();

        try {
            Files.createDirectories(configFile.getParent());
            try (Writer writer = Files.newBufferedWriter(configFile, StandardCharsets.UTF_8)) {
                GSON.toJson(config, writer);
            }
        } catch (IOException e) {
            Main.LOGGER.warn("[" + Main.MOD_NAME + "] Couldn't save config file " + configFile, e);
        }
    }

}
