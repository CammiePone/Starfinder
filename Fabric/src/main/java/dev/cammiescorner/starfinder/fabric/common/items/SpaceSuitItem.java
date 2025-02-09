package dev.cammiescorner.starfinder.fabric.common.items;

import dev.cammiescorner.starfinder.Starfinder;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SpaceSuitItem extends TrinketItem {
	private final DyeColor color;
	private final SuitPiece piece;

	public SpaceSuitItem(DyeColor color, SuitPiece piece) {
		super(new Properties().stacksTo(1));
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
//		NbtCompound tag = stack.getSubNbt(FabricMain.MOD_ID);
//		return tag != null && tag.getBoolean("Tinted");
		return true;
	}

	public enum SuitPiece {
		HELMET, SUIT
	}
}
