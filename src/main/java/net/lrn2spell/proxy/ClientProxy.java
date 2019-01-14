package net.lrn2spell.proxy;

import net.lrn2spell.init.Lrn2SpellKeys;
import net.lrn2spell.items.SpellingStaffItem;
import net.minecraft.item.Item;

public class ClientProxy {

    public static void checkKeys(Item item) {
        SpellingStaffItem staff = (SpellingStaffItem)item;

        if (Lrn2SpellKeys.FIRE.method_1434()) {
            staff.addElement("F");

        } else if (Lrn2SpellKeys.EARTH.method_1434()) {
            staff.addElement("E");

        } else if (Lrn2SpellKeys.AIR.method_1434()) {
            staff.addElement("A");

        } else if (Lrn2SpellKeys.WATER.method_1434()) {
            staff.addElement("W");

        } else if (Lrn2SpellKeys.ARCANE.method_1434()) {
            staff.addElement("R");

        } else if (Lrn2SpellKeys.SHIELD.method_1434()) {
            staff.addElement("S");

        }
    }
}
