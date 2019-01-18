package net.lrn2spell.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.client.render.EntityRendererRegistry;
import net.lrn2spell.client.render.entity.BeamSpellRender;
import net.lrn2spell.entity.BeamSpellEntity;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModKeys.init();
        registerRender();

    }


    public static void registerRender(){
        EntityRendererRegistry.INSTANCE.register(BeamSpellEntity.class, ((manager, context) -> new BeamSpellRender<>(manager)));
    }
}
