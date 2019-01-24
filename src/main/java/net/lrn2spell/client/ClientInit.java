package net.lrn2spell.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.client.render.EntityRendererRegistry;
import net.lrn2spell.client.render.entity.ProjectileSpellRenderer;
import net.lrn2spell.entity.ProjectileSpellEntity;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModKeys.init();
        registerRender();

    }


    public static void registerRender(){
        System.out.println("Registering renderers.");
        EntityRendererRegistry.INSTANCE.register(ProjectileSpellEntity.class, ((manager, context) -> new ProjectileSpellRenderer<>(manager)));
    }
}
