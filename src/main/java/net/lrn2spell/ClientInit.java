package net.lrn2spell;

import net.fabricmc.api.ClientModInitializer;
import net.lrn2spell.init.Lrn2SpellKeys;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        Lrn2SpellKeys.init();

    }
}
