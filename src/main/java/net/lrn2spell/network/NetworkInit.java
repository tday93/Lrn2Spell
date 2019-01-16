package net.lrn2spell.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.networking.CustomPayloadPacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.packet.CustomPayloadClientPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.packet.CustomPayloadServerPacket;
import net.minecraft.util.PacketByteBuf;


public class NetworkInit implements ModInitializer {
    @Override
    public void onInitialize() {

        CustomPayloadPacketRegistry.SERVER.register(AddElementPacket.ADD_ELEMENT, new AddElementPacket.Handler());

    }

    @Environment(EnvType.CLIENT)
    public static void sendToServer(Packet packet) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        packet.toBytes(buf);
        MinecraftClient.getInstance().getNetworkHandler().getClientConnection().sendPacket(new CustomPayloadServerPacket(packet.getId(), buf));

    }

    @Environment(EnvType.SERVER)
    public static void sendToClient(Packet packet, ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        packet.toBytes(buf);
        player.networkHandler.sendPacket(new CustomPayloadClientPacket(packet.getId(), buf));
    }
}
