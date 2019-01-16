package net.lrn2spell.client;

import net.lrn2spell.items.SpellingStaffItem;
import net.lrn2spell.network.AddElementPacket;
import net.lrn2spell.network.NetworkInit;
import net.minecraft.item.ItemStack;

public class ClientProxy {

    public static void checkKeys(ItemStack stack) {

        if (stack.getItem() instanceof SpellingStaffItem) {
            if (Lrn2SpellKeys.FIRE.method_1434()) {
                NetworkInit.sendToServer(new AddElementPacket(1));

            } else if (Lrn2SpellKeys.EARTH.method_1434()) {
                NetworkInit.sendToServer(new AddElementPacket(2));

            } else if (Lrn2SpellKeys.AIR.method_1434()) {
                NetworkInit.sendToServer(new AddElementPacket(3));

            } else if (Lrn2SpellKeys.WATER.method_1434()) {
                NetworkInit.sendToServer(new AddElementPacket(4));

            } else if (Lrn2SpellKeys.ARCANE.method_1434()) {
                NetworkInit.sendToServer(new AddElementPacket(5));

            } else if (Lrn2SpellKeys.SHIELD.method_1434()) {
                NetworkInit.sendToServer(new AddElementPacket(6));

            }
        }
    }
}
