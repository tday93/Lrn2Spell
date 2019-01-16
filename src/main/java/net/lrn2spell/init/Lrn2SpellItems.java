package net.lrn2spell.init;

import net.lrn2spell.Lrn2Spell;
import net.lrn2spell.items.SpellingStaffItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Lrn2SpellItems {

    public static Item SPELLING_STAFF;

    public static void init(){

        SPELLING_STAFF = register(new SpellingStaffItem((new Item.Settings()).itemGroup(Lrn2Spell.lrn2spellGroup)), "spelling_staff");
    }

    public static Item register(Item item, String name) {

        Registry.ITEM.register(new Identifier(Lrn2Spell.MOD_ID + ":" + name), item);
        return item;
    }
}
