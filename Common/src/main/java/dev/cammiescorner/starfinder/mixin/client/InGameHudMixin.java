package dev.cammiescorner.starfinder.mixin.client;

import com.mojang.blaze3d.glfw.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.cammiescorner.starfinder.fabric.entrypoints.Starfinder;
import dev.cammiescorner.starfinder.fabric.client.StarfinderClient;
import dev.cammiescorner.starfinder.fabric.common.items.SpaceSuitItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin extends DrawableHelper {
	@Shadow @Final private MinecraftClient client;
	@Shadow protected abstract void renderOverlay(MatrixStack matrices, Identifier texture, float opacity);

	@Inject(method = "render", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
	), locals = LocalCapture.CAPTURE_FAILSOFT)
	private void starfinder$renderVisor(MatrixStack matrices, float tickDelta, CallbackInfo ci, Window window, TextRenderer textRenderer, float f, ItemStack itemStack) {
		ItemStack stack = Starfinder.getSpaceHelmet(client.player);

		if(!client.player.isSpectator() && stack.getItem() instanceof SpaceSuitItem) {
			int oxygenDialIndex = 0;
			int tempDialIndex = 0;
			int tempLightIndex = 0;

			renderOverlay(matrices, SpaceSuitItem.isTinted(stack) ? StarfinderClient.TINTED_VISOR_OVERLAY : StarfinderClient.VISOR_OVERLAY, 1F);

			matrices.push();
			matrices.translate(0, window.getScaledHeight(), 0);
			RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
			RenderSystem.setShaderTexture(0, StarfinderClient.SPACE_SUIT_INDICATORS);

			drawTexture(matrices, 14, -40, 0, 64, 64, 48, 256, 384); // oxygen meter
			drawTexture(matrices, 22, -37, 8, 112 + (32 * oxygenDialIndex), 48, 32, 256, 384); // oxygen dial

			matrices.translate(window.getScaledWidth(), 0, 0);
			drawTexture(matrices, -108, -40, 48, 0, 64, 48, 256, 384); // indicator light plate
			drawTexture(matrices, -74, -36, 24, 16, 24, 24, 256, 384); // needs space suit
			drawTexture(matrices, -101, -28, 0, 40, 24, 24, 256, 384); // needs helmet

			drawTexture(matrices, -42, -50, 64, 64, 40, 40, 256, 384); // temperature meter
			drawTexture(matrices, -36, -42, 104 + (16 * tempDialIndex), 72, 16, 24, 256, 384); // temperature dial
			drawTexture(matrices, -21, -38, 16 * tempLightIndex, 0, 16, 16, 256, 384); // temperature indicator light
			matrices.pop();
		}
	}
}
