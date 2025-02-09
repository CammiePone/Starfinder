package dev.cammiescorner.starfinder.mixin;

import dev.cammiescorner.starfinder.common.MainHelper;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
	@Shadow public abstract ItemStack getItemBySlot(EquipmentSlot slot);

	protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) { super(entityType, level); }

	@Inject(method = "shouldShowName", at = @At("RETURN"), cancellable = true)
	private void starfinder$hidePlayerName(CallbackInfoReturnable<Boolean> info) {
		ItemStack helmet = MainHelper.getSpaceHelmet(this);

		if(helmet.getItem() instanceof SpaceSuitItem && SpaceSuitItem.isTinted(helmet))
			info.setReturnValue(false);
	}
}
