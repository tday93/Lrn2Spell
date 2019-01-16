package net.lrn2spell.client;

import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        Lrn2SpellKeys.init();

    }
}
