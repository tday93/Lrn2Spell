package net.lrn2spell.items;

import net.lrn2spell.Lrn2Spell;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static SpellingStaffItem SPELLING_STAFF;

    public static void init(){

        SPELLING_STAFF = new SpellingStaffItem((new Item.Settings()).itemGroup(Lrn2Spell.lrn2spellGroup));

        register(SPELLING_STAFF, "spell_staff");
    }

    public static void register(Item item, String name) {

        Registry.ITEM.register(new Identifier(Lrn2Spell.MOD_ID, name), item);
    }
}
