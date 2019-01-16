package net.lrn2spell.misc;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.nbt.CompoundTag;

public class Tools {

    public static CompoundTag getTagCompound(ItemStack stack){
        CompoundTag tagCompound = stack.getTag();
        if (tagCompound == null){
            tagCompound = new CompoundTag();
            stack.setTag(tagCompound);
        }
        return tagCompound;
    }

    public static void notify(PlayerEntity player, String msg) {
        player.addChatMessage(new StringTextComponent(TextFormat.GREEN + msg), false);
    }
}
