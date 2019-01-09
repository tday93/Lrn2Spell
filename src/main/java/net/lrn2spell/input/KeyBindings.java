package net.lrn2spell.input;

import net.lrn2spell.Lrn2Spell;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.InputUtil.Type;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;

public class KeyBindings {


    public static void init() {

        KeyBindingRegistry.INSTANCE.addCategory(Lrn2Spell.MODID);

        FabricKeyBinding fire = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MODID + ":" + "fire"), Type.KEY_KEYBOARD, 37, "Lrn2Spell").build();
        FabricKeyBinding earth = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MODID + ":" + "earth"), Type.KEY_KEYBOARD, 37, "Lrn2Spell").build();
        FabricKeyBinding air = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MODID + ":" + "air"), Type.KEY_KEYBOARD, 37, "Lrn2Spell").build();
        FabricKeyBinding water = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MODID + ":" + "water"), Type.KEY_KEYBOARD, 37, "Lrn2Spell").build();
        FabricKeyBinding arcane = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MODID + ":" + "arcane"), Type.KEY_KEYBOARD, 37, "Lrn2Spell").build();
        FabricKeyBinding shield = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MODID + ":" + "shield"), Type.KEY_KEYBOARD, 37, "Lrn2Spell").build();

        KeyBindingRegistry.INSTANCE.register(fire);
        KeyBindingRegistry.INSTANCE.register(earth);
        KeyBindingRegistry.INSTANCE.register(air);
        KeyBindingRegistry.INSTANCE.register(water);
        KeyBindingRegistry.INSTANCE.register(arcane);
        KeyBindingRegistry.INSTANCE.register(shield);




    }
}
