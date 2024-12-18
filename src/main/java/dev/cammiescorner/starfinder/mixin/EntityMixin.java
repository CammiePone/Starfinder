package dev.cammiescorner.starfinder.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
	@Unique private final Entity self = (Entity) (Object) this;

	@Inject(method = "tick", at = @At("HEAD"))
	private void starfinder$gravity(CallbackInfo info) {
//		GravityChangerAPI.setDefualtGravityStrength(self, 0.166);
	}
}
