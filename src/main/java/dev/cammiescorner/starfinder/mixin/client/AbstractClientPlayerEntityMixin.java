package dev.cammiescorner.starfinder.mixin.client;

import com.mojang.authlib.GameProfile;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {
	@Unique private final MinecraftClient client = MinecraftClient.getInstance();

	public AbstractClientPlayerEntityMixin(World world, BlockPos pos, float f, GameProfile gameProfile) { super(world, pos, f, gameProfile); }

	@Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
	private void starfinder$getModel(CallbackInfoReturnable<String> info) {
		if(client.cameraEntity == this && !client.gameRenderer.getCamera().isThirdPerson() && Starfinder.getSpaceSuit(this).getItem() instanceof SpaceSuitItem)
			info.setReturnValue("default");
	}
}
