package space.plague.plaguesnoisycreepers.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.ConfigScreenHandler;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.config.gui.GeneralOptionsScreen;
import space.plague.plaguesnoisycreepers.neoforge.sounds.Sounds;

@Mod(Main.MOD_ID)
public final class MainNeoForge {
    public MainNeoForge(IEventBus eventBus) {

        if (FMLEnvironment.dist == Dist.DEDICATED_SERVER) {
            return;
        }

        Main.init();

        Sounds.SOUNDS.register(eventBus);
        Sounds.register();

        if (ModList.get().isLoaded("cloth_config")) {
            ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory(
                    (minecraftClient, screen) -> GeneralOptionsScreen.getConfigBuilder().build()
                ));
        }
    }
}
