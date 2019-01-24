package net.lrn2spell.network;

import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.networking.PacketContext;
import net.lrn2spell.Lrn2Spell;
import net.lrn2spell.items.SpellingStaffItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AddElementPacket implements Packet{

    public static final Identifier ADD_ELEMENT = new Identifier(Lrn2Spell.MOD_ID, "add_element");

    private int element;

    @Override
    public Identifier getId() {
        return ADD_ELEMENT;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        element = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(element);
    }

    public AddElementPacket(){

    }

    public AddElementPacket(int newElement){
        this.element = newElement;
    }

    public static class Handler extends MessageHandler<AddElementPacket>{

        @Override
        protected AddElementPacket createPacket(){
            return new AddElementPacket();
        }

        @Override
        public void handle(PacketContext context, AddElementPacket message){
            PlayerEntity player = context.getPlayer();
            ItemStack heldItem = player.getMainHandStack();
            if (!heldItem.isEmpty() && heldItem.getItem() instanceof SpellingStaffItem){
                SpellingStaffItem staff = (SpellingStaffItem) (heldItem.getItem());
                staff.addElement(player, heldItem, message.element);
            }
        }
    }
}
