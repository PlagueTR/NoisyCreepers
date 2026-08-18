package space.plague.plaguesnoisycreepers.neoforge;

import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.config.gui.GeneralOptionsScreen;

@Mod(Main.MOD_ID)
public final class MainNeoForge {
    public MainNeoForge() {
        Main.init();

        if (ModList.get().isLoaded("cloth_config")) {
            ModLoadingContext.get().registerExtensionPoint(
                    IConfigScreenFactory.class,
                    () -> (minecraftClient, screen) ->
                            GeneralOptionsScreen.getConfigBuilder().build()
            );
        }
    }
}
