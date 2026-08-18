package space.plague.plaguesnoisycreepers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import space.plague.plaguesnoisycreepers.config.ModConfig;
import space.plague.plaguesnoisycreepers.config.ModConfigManager;

public final class Main {

    public static final String MOD_ID = "plaguesnoisycreepers";
    public static final String MOD_NAME = "Plague's Noisy Creepers";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {

        LOGGER.info("[" + MOD_NAME + "] Loading...");

        ModConfigManager.initializeConfig();

        LOGGER.info("[" + MOD_NAME +"] All done!");

    }

    public static ModConfig getConfig() {
        return ModConfigManager.getConfig();
    }

    public static void saveConfig() {
        ModConfigManager.save();
    }

}
