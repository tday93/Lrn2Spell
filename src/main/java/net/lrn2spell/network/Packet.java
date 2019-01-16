package net.lrn2spell.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.Identifier;

public interface Packet {


        void fromBytes(ByteBuf buf);

        void toBytes(ByteBuf buf);

        Identifier getId();

}
