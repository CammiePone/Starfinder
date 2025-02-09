package dev.cammiescorner.starfinder.client.renderer.entity.spaceship;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.spaceship.SmallSpaceshipModel;
import dev.cammiescorner.starfinder.common.entities.SmallSpaceshipEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Axis;

public class SmallSpaceshipEntityRenderer extends EntityRenderer<SmallSpaceshipEntity> {
	public static final Identifier TEXTURE = Starfinder.id("textures/entity/spaceship/small_spaceship.png");
	private final SmallSpaceshipModel model;

	public SmallSpaceshipEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		model = new SmallSpaceshipModel(ctx.getModelLoader().getModelPart(SmallSpaceshipModel.MODEL_LAYER));
	}

	@Override
	public void render(SmallSpaceshipEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertices, int light) {
		model.door.pitch = (float) Math.toRadians(0);
		matrices.push();
		matrices.translate(0, 1.5F, 0);
		matrices.multiply(Axis.X_POSITIVE.rotationDegrees(180));
		matrices.multiply(Axis.Y_POSITIVE.rotationDegrees(yaw));
		model.render(matrices, vertices.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
		matrices.pop();
	}

	@Override
	public Identifier getTexture(SmallSpaceshipEntity entity) {
		return TEXTURE;
	}
}
