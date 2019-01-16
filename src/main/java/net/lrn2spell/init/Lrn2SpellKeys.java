package net.lrn2spell.init;

import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.lrn2spell.Lrn2Spell;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class Lrn2SpellKeys {

    public static FabricKeyBinding FIRE;
    public static FabricKeyBinding EARTH;
    public static FabricKeyBinding AIR;
    public static FabricKeyBinding WATER;
    public static FabricKeyBinding ARCANE;
    public static FabricKeyBinding SHIELD;


    public static void init() {

        KeyBindingRegistry.INSTANCE.addCategory(Lrn2Spell.ITEM_CAT);

        FIRE = registerKey("fire", 37, Lrn2Spell.ITEM_CAT);
        EARTH = registerKey("earth", 37, Lrn2Spell.ITEM_CAT);
        AIR = registerKey("air", 37, Lrn2Spell.ITEM_CAT);
        WATER = registerKey("water", 37, Lrn2Spell.ITEM_CAT);
        ARCANE = registerKey("arcane", 37, Lrn2Spell.ITEM_CAT);
        SHIELD = registerKey("shield", 37, Lrn2Spell.ITEM_CAT);


    }

    public static FabricKeyBinding registerKey(String name, Integer code, String category) {
        FabricKeyBinding key = FabricKeyBinding.Builder.create(new Identifier(Lrn2Spell.MOD_ID + ":" + name), InputUtil.Type.KEY_KEYBOARD, code, category).build();
        KeyBindingRegistry.INSTANCE.register(key);

        return key;

    }
}
