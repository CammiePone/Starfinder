package dev.cammiescorner.starfinder.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.cammiescorner.starfinder.StarfinderClient;
import dev.cammiescorner.starfinder.common.MainHelper;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class GuiMixin {
	@Shadow @Final private Minecraft minecraft;

	@Shadow protected abstract void renderTextureOverlay(GuiGraphics guiGraphics, ResourceLocation shaderLocation, float alpha);

	@Inject(method = "renderCameraOverlays", at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
	))
	private void starfinder$renderVisor(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo info) {
		if(minecraft.player != null) {
			ItemStack stack = MainHelper.getSpaceHelmet(minecraft.player);
			PoseStack poseStack = guiGraphics.pose();

			if(!minecraft.player.isSpectator() && stack.getItem() instanceof SpaceSuitItem) {
				int oxygenDialIndex = 0;
				int tempDialIndex = 0;
				int tempLightIndex = 0;
				int suitBlinkTime = MainHelper.getSpaceSuit(minecraft.player).isEmpty() ? (int) (Math.round(Math.sin(minecraft.player.tickCount * 0.25) * 0.5 + 0.5)) : 1;

				renderTextureOverlay(guiGraphics, SpaceSuitItem.isTinted(stack) ? StarfinderClient.TINTED_VISOR_OVERLAY : StarfinderClient.VISOR_OVERLAY, 1f);

				poseStack.pushPose();
				poseStack.translate(0, minecraft.getWindow().getGuiScaledHeight(), 0);

				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 0, 64, 14, -40, 64, 48); // oxygen meter
				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 8, 112 + (32 * oxygenDialIndex), 22, -37, 48, 32); // oxygen dial

				poseStack.translate(minecraft.getWindow().getGuiScaledWidth(), 0, 0);
				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 48, 0, -108, -40, 64, 48); // indicator light plate
				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 0, 16 + 24, -101, -28, 24, 24); // needs helmet
				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 24, 16 + suitBlinkTime * 24, -74, -36, 24, 24); // needs space suit

				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 64, 64, -42, -50, 40, 40); // temperature meter
				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 104 + (16 * tempDialIndex), 72, -36, -42, 16, 24); // temperature dial
				guiGraphics.blitSprite(StarfinderClient.SPACE_SUIT_INDICATORS, 256, 384, 16 * tempLightIndex, 0, -21, -38, 16, 16); // temperature indicator light
				poseStack.popPose();
			}
		}
	}
}
