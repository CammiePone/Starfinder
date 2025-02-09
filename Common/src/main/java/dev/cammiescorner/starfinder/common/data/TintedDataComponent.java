package dev.cammiescorner.starfinder.common.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.cammiescorner.starfinder.common.registries.StarfinderData;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

public record TintedDataComponent(boolean isTinted) {
	public static final Codec<TintedDataComponent> CODEC = RecordCodecBuilder.create(component -> component.group(Codec.BOOL.fieldOf("tinted").forGetter(TintedDataComponent::isTinted)).apply(component, TintedDataComponent::new));
	public static final StreamCodec<RegistryFriendlyByteBuf, TintedDataComponent> STREAM_CODEC = StreamCodec.of((byteBuf, component) -> byteBuf.writeBoolean(component.isTinted()), byteBuf -> new TintedDataComponent(byteBuf.readBoolean()));
	public static final TintedDataComponent DEFAULT = new TintedDataComponent(false);

	public TintedDataComponent toggleTint() {
		return new TintedDataComponent(!isTinted);
	}

	public static TintedDataComponent get(ItemStack stack) {
		return stack.getOrDefault(StarfinderData.IS_TINTED.get(), TintedDataComponent.DEFAULT);
	}
}
