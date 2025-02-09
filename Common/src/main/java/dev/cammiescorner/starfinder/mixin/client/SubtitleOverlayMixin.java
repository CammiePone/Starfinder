package dev.cammiescorner.starfinder.mixin.client;

import dev.cammiescorner.starfinder.common.MainHelper;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.SubtitleOverlay;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SubtitleOverlay.class)
public class SubtitleOverlayMixin {
	@Shadow @Final private Minecraft minecraft;

	@Inject(method = "render", at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"
	))
	private void starfinder$renderSubtitlesHigher(GuiGraphics guiGraphics, CallbackInfo info) {
		if(minecraft.cameraEntity instanceof LivingEntity entity && MainHelper.getSpaceHelmet(entity).getItem() instanceof SpaceSuitItem && !minecraft.gameRenderer.getMainCamera().isDetached())
			guiGraphics.pose().translate(0, -24, 0);
	}
}
