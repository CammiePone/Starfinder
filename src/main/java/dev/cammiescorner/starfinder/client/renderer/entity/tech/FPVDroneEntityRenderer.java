package dev.cammiescorner.starfinder.client.renderer.entity.tech;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVDroneModel;
import dev.cammiescorner.starfinder.common.entities.tech.FPVDroneEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Axis;

public class FPVDroneEntityRenderer extends EntityRenderer<FPVDroneEntity> {
	public static final Identifier TEXTURE = Starfinder.id("textures/entity/tech/fpv_drone.png");
	private final FPVDroneModel model;

	public FPVDroneEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		model = new FPVDroneModel(ctx.getModelLoader().getModelPart(FPVDroneModel.MODEL_LAYER));
	}

	@Override
	public void render(FPVDroneEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertices, int light) {
		matrices.push();
		matrices.translate(0, 1.5F, 0);
		matrices.multiply(Axis.X_POSITIVE.rotationDegrees(180));
		matrices.multiply(Axis.Y_POSITIVE.rotationDegrees(yaw));
		model.render(matrices, vertices.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
		matrices.pop();
	}

	@Override
	public Identifier getTexture(FPVDroneEntity entity) {
		return TEXTURE;
	}
}
