package space.plague.plaguesnoisycreepers.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.config.gui.GeneralOptionsScreen;
import space.plague.plaguesnoisycreepers.forge.sounds.Sounds;

@Mod(Main.MOD_ID)
public final class MainForge {
    public MainForge() {

        if (FMLEnvironment.dist == Dist.DEDICATED_SERVER) {
            return;
        }

        Main.init();

        Sounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Sounds.register();

        if (ModList.get().isLoaded("cloth-config")) {
            ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () ->
                ((minecraft, screen) -> GeneralOptionsScreen.getConfigBuilder().build()
            ));
        }
        
    }
}
