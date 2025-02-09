package dev.cammiescorner.starfinder.client.renderer.entity.tech;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVDroneModel;
import dev.cammiescorner.starfinder.common.entities.tech.FPVDroneEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class FPVDroneEntityRenderer extends EntityRenderer<FPVDroneEntity> {
	public static final ResourceLocation TEXTURE = Starfinder.id("textures/entity/tech/fpv_drone.png");
	private final FPVDroneModel model;

	public FPVDroneEntityRenderer(EntityRendererProvider.Context ctx) {
		super(ctx);
		model = new FPVDroneModel(ctx.getModelSet().bakeLayer(FPVDroneModel.MODEL_LAYER));
	}

	@Override
	public void render(FPVDroneEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		poseStack.pushPose();
		poseStack.translate(0f, 1.5f, 0f);
		poseStack.mulPose(Axis.XP.rotationDegrees(180));
		poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));
		model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffffff);
		poseStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(FPVDroneEntity entity) {
		return TEXTURE;
	}
}
