package dev.cammiescorner.starfinder.client.renderer.entity.tech;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVRoverModel;
import dev.cammiescorner.starfinder.common.entities.tech.FPVRoverEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Axis;

public class FPVRoverEntityRenderer extends EntityRenderer<FPVRoverEntity> {
	public static final Identifier TEXTURE = Starfinder.id("textures/entity/tech/fpv_rover.png");
	private final FPVRoverModel model;

	public FPVRoverEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		model = new FPVRoverModel(ctx.getModelLoader().getModelPart(FPVRoverModel.MODEL_LAYER));
	}

	@Override
	public void render(FPVRoverEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertices, int light) {
		matrices.push();
		matrices.translate(0, 1.5F, 0);
		matrices.multiply(Axis.X_POSITIVE.rotationDegrees(180));
		matrices.multiply(Axis.Y_POSITIVE.rotationDegrees(yaw));
		model.clawPole.visible = entity.isAlive();
		model.drillPole.visible = !model.clawPole.visible;
		model.toolBall.pitch = (float) Math.toRadians(-60);
		model.clawPole.pitch = (float) Math.toRadians(60);
		model.drillPole.pitch = model.clawPole.pitch;
		model.cameraBall.pitch = (float) Math.toRadians(-40);
		model.camPole.pitch = (float) Math.toRadians(20);
		model.camera.pitch = (float) Math.toRadians(40);
		model.drillBlades.roll += Math.toRadians(10);

		model.render(matrices, vertices.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
		matrices.pop();
	}

	@Override
	public Identifier getTexture(FPVRoverEntity entity) {
		return TEXTURE;
	}
}
