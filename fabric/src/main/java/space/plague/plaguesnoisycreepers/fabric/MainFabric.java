package space.plague.plaguesnoisycreepers.fabric;

import net.fabricmc.api.ClientModInitializer;

import space.plague.plaguesnoisycreepers.Main;
import space.plague.plaguesnoisycreepers.fabric.sounds.Sounds;

public final class MainFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        Main.init();

        Sounds.register();

    }
}
