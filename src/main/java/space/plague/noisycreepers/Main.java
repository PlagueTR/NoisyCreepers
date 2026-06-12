package space.plague.noisycreepers;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import space.plague.noisycreepers.config.ModConfig;
import space.plague.noisycreepers.config.ModConfigManager;
import space.plague.noisycreepers.sounds.Sounds;

public class Main implements ModInitializer {

    //mod logger
    public static final Logger LOGGER = LogManager.getLogger("plaguesnoisycreepers");

    @Override
    public void onInitialize() {

        //Log beginning of initialization
        LOGGER.info("[Plague's Noisy Creepers] Loading... ");

        Sounds.register();

        //Load Config
        ModConfigManager.initializeConfig();

        //Log initialization success
        LOGGER.info("[Plague's Noisy Creepers] All done!");

    }

    public static ModConfig getConfig() {
        return ModConfigManager.getConfig();
    }

    public static void saveConfig() {
        ModConfigManager.save();
    }

}
