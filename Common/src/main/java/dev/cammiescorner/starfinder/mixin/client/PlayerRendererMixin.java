package dev.cammiescorner.starfinder.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.MainHelper;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
	@Unique private final Minecraft client = Minecraft.getInstance();
	@Unique private AbstractClientPlayer player;

	public PlayerRendererMixin(EntityRendererProvider.Context context, PlayerModel<AbstractClientPlayer> model, float shadowRadius) { super(context, model, shadowRadius); }

	@Inject(method = "renderHand", at = @At("HEAD"))
	private void starfinder$capturePlayer(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, net.minecraft.client.model.geom.ModelPart rendererArm, net.minecraft.client.model.geom.ModelPart rendererArmwear, CallbackInfo ci) {
		this.player = player;
	}

	@ModifyArg(method = "renderHand", at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/renderer/RenderType;entitySolid(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;"
	))
	private ResourceLocation starfinder$getSkinTexture(ResourceLocation texture) {
		PlayerModel<AbstractClientPlayer> model = getModel();

		if(client.cameraEntity == player && !client.gameRenderer.getMainCamera().isDetached() && MainHelper.getSpaceSuit(player).getItem() instanceof SpaceSuitItem spaceSuit) {
			texture = Starfinder.id("textures/entity/player/" + spaceSuit.getColor().getName().toLowerCase(Locale.ROOT) + "_space_suit.png");
			model.rightSleeve.visible = false;
			model.leftSleeve.visible = false;
		}

		return texture;
	}
}
