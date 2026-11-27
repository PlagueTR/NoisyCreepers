package space.plague.plaguesnoisycreepers.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.config.gui.GeneralOptionsScreen;
import space.plague.plaguesnoisycreepers.neoforge.sounds.Sounds;

@Mod(value = Main.MOD_ID, dist = Dist.CLIENT)
public final class ClientMainNeoForge {

    public ClientMainNeoForge(IEventBus modBus, ModContainer container) {

        Main.init();

        Sounds.SOUNDS.register(modBus);
        Sounds.register();

        if (ModList.get().isLoaded("cloth_config")) {
            container.registerExtensionPoint(IConfigScreenFactory.class,
                    (modContainer, parent) -> GeneralOptionsScreen.create(parent));
        }

    }

}
