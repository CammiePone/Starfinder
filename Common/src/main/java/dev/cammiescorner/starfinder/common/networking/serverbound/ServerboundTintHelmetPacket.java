package dev.cammiescorner.starfinder.common.networking.serverbound;

import commonnetwork.networking.data.PacketContext;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.data.TintedDataComponent;
import dev.cammiescorner.starfinder.common.registries.StarfinderData;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public record ServerboundTintHelmetPacket(int slot) implements CustomPacketPayload {
	public static final Type<ServerboundTintHelmetPacket> TYPE = new Type<>(Starfinder.id("tint_helmet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundTintHelmetPacket> CODEC = StreamCodec.of((buffer, packet) -> {
		buffer.writeVarInt(packet.slot);
	}, buffer -> new ServerboundTintHelmetPacket(buffer.readVarInt()));

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(PacketContext<ServerboundTintHelmetPacket> context) {
		int slot = context.message().slot();
		Inventory inventory = context.sender().getInventory();
		ItemStack stack = inventory.getItem(slot);

		if(stack.has(StarfinderData.IS_TINTED.get())) {
			stack.set(StarfinderData.IS_TINTED.get(), TintedDataComponent.get(stack).toggleTint());
			inventory.setItem(slot, stack);
		}
	}
}
