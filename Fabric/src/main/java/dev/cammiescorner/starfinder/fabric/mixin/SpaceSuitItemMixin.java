package dev.cammiescorner.starfinder.fabric.mixin;

import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpaceSuitItem.class)
public abstract class SpaceSuitItemMixin extends Item implements Trinket {
	public SpaceSuitItemMixin(Properties properties) { super(properties); }

	@Inject(method = "<init>", at = @At("RETURN"))
	private void construct(DyeColor color, SpaceSuitItem.SuitPiece piece, CallbackInfo info) {
		TrinketsApi.registerTrinket(this, this);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack stack = player.getItemInHand(usedHand);

		if(TrinketItem.equipItem(player, stack))
			return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());

		return super.use(level, player, usedHand);
	}
}
