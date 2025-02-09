package dev.cammiescorner.starfinder.client.renderer.entity.spaceship;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.spaceship.SmallSpaceshipModel;
import dev.cammiescorner.starfinder.common.entities.SmallSpaceshipEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class SmallSpaceshipEntityRenderer extends EntityRenderer<SmallSpaceshipEntity> {
	public static final ResourceLocation TEXTURE = Starfinder.id("textures/entity/spaceship/small_spaceship.png");
	private final SmallSpaceshipModel model;

	public SmallSpaceshipEntityRenderer(EntityRendererProvider.Context ctx) {
		super(ctx);
		model = new SmallSpaceshipModel(ctx.getModelSet().bakeLayer(SmallSpaceshipModel.MODEL_LAYER));
	}

	@Override
	public void render(SmallSpaceshipEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		model.door.xRot = (float) Math.toRadians(0);
		poseStack.pushPose();
		poseStack.translate(0f, 1.5f, 0f);
		poseStack.mulPose(Axis.XP.rotationDegrees(180));
		poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));
		model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffffff);
		poseStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(SmallSpaceshipEntity entity) {
		return TEXTURE;
	}
}
