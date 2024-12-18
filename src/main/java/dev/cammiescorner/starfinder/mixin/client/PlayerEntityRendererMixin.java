package dev.cammiescorner.starfinder.mixin.client;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
	@Unique private final MinecraftClient client = MinecraftClient.getInstance();
	@Unique private AbstractClientPlayerEntity player;

	public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) { super(ctx, model, shadowRadius); }

	@Inject(method = "renderArm", at = @At("HEAD"))
	private void starfinder$capturePlayer(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity player, ModelPart arm, ModelPart sleeve, CallbackInfo info) {
		this.player = player;
	}

	@ModifyArg(method = "renderArm", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/render/RenderLayer;getEntitySolid(Lnet/minecraft/util/Identifier;)Lnet/minecraft/client/render/RenderLayer;"
	))
	private Identifier starfinder$getSkinTexture(Identifier texture) {
		PlayerEntityModel<AbstractClientPlayerEntity> model = getModel();

		if(client.cameraEntity == player && !client.gameRenderer.getCamera().isThirdPerson() && Starfinder.getSpaceSuit(player).getItem() instanceof SpaceSuitItem spaceSuit) {
			texture = Starfinder.id("textures/entity/player/" + spaceSuit.getColor().getName().toLowerCase(Locale.ROOT) + "_space_suit.png");
			model.rightSleeve.visible = false;
			model.leftSleeve.visible = false;
		}

		return texture;
	}
}
