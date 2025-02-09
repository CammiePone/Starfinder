package dev.cammiescorner.starfinder.client.renderer.entity.tech;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVRoverModel;
import dev.cammiescorner.starfinder.common.entities.tech.FPVRoverEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class FPVRoverEntityRenderer extends EntityRenderer<FPVRoverEntity> {
	public static final ResourceLocation TEXTURE = Starfinder.id("textures/entity/tech/fpv_rover.png");
	private final FPVRoverModel model;

	public FPVRoverEntityRenderer(EntityRendererProvider.Context ctx) {
		super(ctx);
		model = new FPVRoverModel(ctx.getModelSet().bakeLayer(FPVRoverModel.MODEL_LAYER));
	}

	@Override
	public void render(FPVRoverEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		poseStack.pushPose();
		poseStack.translate(0, 1.5F, 0);
		poseStack.mulPose(Axis.XP.rotationDegrees(180));
		poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));
		model.clawPole.visible = entity.isAlive();
		model.drillPole.visible = !model.clawPole.visible;
		model.toolBall.xRot = (float) Math.toRadians(-60);
		model.clawPole.xRot = (float) Math.toRadians(60);
		model.drillPole.xRot = model.clawPole.xRot;
		model.cameraBall.xRot = (float) Math.toRadians(-40);
		model.camPole.xRot = (float) Math.toRadians(20);
		model.camera.xRot = (float) Math.toRadians(40);
		model.drillBlades.zRot += (float) Math.toRadians(10);

		model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffffff);
		poseStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(FPVRoverEntity entity) {
		return TEXTURE;
	}
}
