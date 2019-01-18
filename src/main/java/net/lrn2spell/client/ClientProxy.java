package net.lrn2spell.client;

import net.lrn2spell.items.SpellingStaffItem;
import net.lrn2spell.network.AddElementPacket;
import net.lrn2spell.network.NetworkInit;
import net.minecraft.item.ItemStack;

public class ClientProxy {


    public static void checkKeys(ItemStack stack) {

        if (stack.getItem() instanceof SpellingStaffItem) {

            if (ModKeys.FIRE.method_1436()) {
                NetworkInit.sendToServer(new AddElementPacket(1));

            } else if (ModKeys.EARTH.method_1436()) {
                NetworkInit.sendToServer(new AddElementPacket(2));

            } else if (ModKeys.AIR.method_1436()) {
                NetworkInit.sendToServer(new AddElementPacket(3));

            } else if (ModKeys.WATER.method_1436()) {
                NetworkInit.sendToServer(new AddElementPacket(4));

            } else if (ModKeys.ARCANE.method_1436()) {
                NetworkInit.sendToServer(new AddElementPacket(5));

            } else if (ModKeys.SHIELD.method_1436()) {
                NetworkInit.sendToServer(new AddElementPacket(6));

            }
        }
    }
}
