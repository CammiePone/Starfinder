package dev.cammiescorner.starfinder.common.items;

import dev.cammiescorner.starfinder.Starfinder;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.List;

public class SpaceSuitItem extends TrinketItem {
	private final DyeColor color;
	private final SuitPiece piece;

	public SpaceSuitItem(DyeColor color, SuitPiece piece) {
		super(new QuiltItemSettings().maxCount(1));
		this.color = color;
		this.piece = piece;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if(piece == SuitPiece.HELMET) {
			if(isTinted(stack))
				tooltip.add(Starfinder.translate("tooltip", "space_helmet_visor", "tinted").formatted(Formatting.GRAY));
			else
				tooltip.add(Starfinder.translate("tooltip", "space_helmet_visor", "untinted").formatted(Formatting.GRAY));
		}
	}

	public DyeColor getColor() {
		return color;
	}

	public SuitPiece getType() {
		return piece;
	}

	public static boolean isTinted(ItemStack stack) {
		NbtCompound tag = stack.getSubNbt(Starfinder.MOD_ID);
		return tag != null && tag.getBoolean("Tinted");
	}

	public enum SuitPiece {
		HELMET, SUIT
	}
}
