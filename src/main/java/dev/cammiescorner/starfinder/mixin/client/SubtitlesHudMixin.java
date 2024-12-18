package dev.cammiescorner.starfinder.mixin.client;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.SubtitlesHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SubtitlesHud.class)
public class SubtitlesHudMixin {
	@Shadow @Final private MinecraftClient client;

	@Inject(method = "render", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/util/math/MatrixStack;scale(FFF)V"
	))
	private void starfinder$renderSubtitlesHigher(MatrixStack matrices, CallbackInfo info) {
		if(client.cameraEntity instanceof LivingEntity entity && Starfinder.getSpaceHelmet(entity).getItem() instanceof SpaceSuitItem && !client.gameRenderer.getCamera().isThirdPerson())
			matrices.translate(0, -24, 0);
	}
}
