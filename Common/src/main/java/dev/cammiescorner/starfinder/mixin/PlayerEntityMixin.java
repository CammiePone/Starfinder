package dev.cammiescorner.starfinder.mixin;

import dev.cammiescorner.starfinder.fabric.entrypoints.Starfinder;
import dev.cammiescorner.starfinder.fabric.common.items.SpaceSuitItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
	@Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) { super(entityType, world); }

	@Inject(method = "shouldRenderName", at = @At("RETURN"), cancellable = true)
	private void starfinder$hidePlayerName(CallbackInfoReturnable<Boolean> info) {
		ItemStack helmet = Starfinder.getSpaceHelmet(this);

		if(helmet.getItem() instanceof SpaceSuitItem && SpaceSuitItem.isTinted(helmet))
			info.setReturnValue(false);
	}
}
