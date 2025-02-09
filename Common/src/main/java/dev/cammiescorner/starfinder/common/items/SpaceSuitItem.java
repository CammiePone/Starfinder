package dev.cammiescorner.starfinder.common.items;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.data.TintedDataComponent;
import dev.cammiescorner.starfinder.common.registries.StarfinderData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SpaceSuitItem extends Item {
	private final DyeColor color;
	private final SuitPiece piece;

	public SpaceSuitItem(DyeColor color, SuitPiece piece) {
		super(new Properties().stacksTo(1).component(StarfinderData.IS_TINTED.get(), TintedDataComponent.DEFAULT));
		this.color = color;
		this.piece = piece;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		if(piece == SuitPiece.HELMET) {
			if(isTinted(stack))
				tooltipComponents.add(Starfinder.translate("tooltip", "space_helmet_visor", "tinted").withStyle(ChatFormatting.GRAY));
			else
				tooltipComponents.add(Starfinder.translate("tooltip", "space_helmet_visor", "untinted").withStyle(ChatFormatting.GRAY));
		}
	}

	public DyeColor getColor() {
		return color;
	}

	public SuitPiece getType() {
		return piece;
	}

	public static boolean isTinted(ItemStack stack) {
		return stack.getItem() instanceof SpaceSuitItem helmet && helmet.getType() == SuitPiece.HELMET && TintedDataComponent.get(stack).isTinted();
	}

	public static void toggleTinted(ItemStack stack, int slot) {

	}

	public enum SuitPiece {
		HELMET, SUIT
	}
}
