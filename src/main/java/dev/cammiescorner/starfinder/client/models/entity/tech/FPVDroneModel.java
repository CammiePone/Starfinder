package dev.cammiescorner.starfinder.client.models.entity.tech;

import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cammiescorner.starfinder.Starfinder;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class FPVDroneModel extends EntityModel<Entity> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Starfinder.id("fpv_drone"), "main");
	public final ModelPart droneBody;
	public final ModelPart camera;
	public final ModelPart rotatingBall;
	public final ModelPart claw;

	public FPVDroneModel(ModelPart root) {
		this.droneBody = root.getChild("droneBody");
		this.camera = droneBody.getChild("camera");
		this.rotatingBall = droneBody.getChild("rotatingBall");
		this.claw = rotatingBall.getChild("claw");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData droneBody = modelPartData.addChild("droneBody", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -0.5F, -2.5F, 7.0F, 4.0F, 7.0F, new Dilation(0.0F)).uv(0, 11).cuboid(-2.0F, -0.5F, -4.5F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)).uv(49, 0).cuboid(0.25F, -8.0F, 4.0F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F)).uv(45, 0).cuboid(-1.25F, -4.0F, 4.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 19.0F, 0.0F));

		ModelPartData camera = droneBody.addChild("camera", ModelPartBuilder.create().uv(0, 17).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, -2.0F));

		ModelPartData arm_front_right = droneBody.addChild("arm_front_right", ModelPartBuilder.create(), ModelTransform.of(-3.5F, -0.5F, -2.5F, 0.0F, -0.7854F, 0.0F));
		ModelPartData thruster_tail_r1 = arm_front_right.addChild("thruster_tail_r1", ModelPartBuilder.create().uv(21, 0).cuboid(-8.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.01F)).uv(37, 0).cuboid(-8.0F, 1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
		ModelPartData support_2_r1 = arm_front_right.addChild("support_2_r1", ModelPartBuilder.create().uv(30, 10).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(-0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
		ModelPartData support_1_r1 = arm_front_right.addChild("support_1_r1", ModelPartBuilder.create().uv(28, 7).mirrored().cuboid(-7.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		ModelPartData thuster_end_1 = arm_front_right.addChild("thuster_end_1", ModelPartBuilder.create(), ModelTransform.pivot(-8.75F, 3.25F, 0.0F));

		ModelPartData arm_back_left = droneBody.addChild("arm_back_left", ModelPartBuilder.create(), ModelTransform.of(3.5F, -0.5F, 4.5F, 0.0F, -0.7854F, 0.0F));
		ModelPartData thruster_tail_r2 = arm_back_left.addChild("thruster_tail_r2", ModelPartBuilder.create().uv(21, 0).mirrored().cuboid(6.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.01F)).mirrored(false).uv(37, 0).mirrored().cuboid(6.0F, 1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));
		ModelPartData support_2_r2 = arm_back_left.addChild("support_2_r2", ModelPartBuilder.create().uv(30, 10).cuboid(0.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(-0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));
		ModelPartData support_1_r2 = arm_back_left.addChild("support_1_r2", ModelPartBuilder.create().uv(28, 7).cuboid(-1.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
		ModelPartData thruster_end_2 = arm_back_left.addChild("thruster_end_2", ModelPartBuilder.create(), ModelTransform.pivot(8.75F, 3.25F, 0.0F));

		ModelPartData arm_front_left = droneBody.addChild("arm_front_left", ModelPartBuilder.create(), ModelTransform.of(3.5F, -0.5F, -2.5F, 0.0F, 0.7854F, 0.0F));
		ModelPartData thruster_tail_r3 = arm_front_left.addChild("thruster_tail_r3", ModelPartBuilder.create().uv(21, 0).mirrored().cuboid(6.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.01F)).mirrored(false).uv(37, 0).mirrored().cuboid(6.0F, 1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));
		ModelPartData support_2_r3 = arm_front_left.addChild("support_2_r3", ModelPartBuilder.create().uv(30, 10).cuboid(0.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(-0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));
		ModelPartData support_1_r3 = arm_front_left.addChild("support_1_r3", ModelPartBuilder.create().uv(28, 7).cuboid(-1.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
		ModelPartData thruster_end_3 = arm_front_left.addChild("thruster_end_3", ModelPartBuilder.create(), ModelTransform.pivot(8.75F, 3.25F, 0.0F));

		ModelPartData arm_back_right = droneBody.addChild("arm_back_right", ModelPartBuilder.create(), ModelTransform.of(-3.5F, -0.5F, 4.5F, 0.0F, 0.7854F, 0.0F));
		ModelPartData thruster_tail_r4 = arm_back_right.addChild("thruster_tail_r4", ModelPartBuilder.create().uv(21, 0).cuboid(-8.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.01F)).uv(37, 0).cuboid(-8.0F, 1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
		ModelPartData support_2_r4 = arm_back_right.addChild("support_2_r4", ModelPartBuilder.create().uv(30, 10).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(-0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
		ModelPartData support_1_r4 = arm_back_right.addChild("support_1_r4", ModelPartBuilder.create().uv(28, 7).mirrored().cuboid(-7.0F, 0.0F, -1.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		ModelPartData thruster_end_4 = arm_back_right.addChild("thruster_end_4", ModelPartBuilder.create(), ModelTransform.pivot(-8.75F, 3.25F, 0.0F));

		ModelPartData rotatingBall = droneBody.addChild("rotatingBall", ModelPartBuilder.create().uv(12, 11).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.5F, 1.0F));
		ModelPartData claw = rotatingBall.addChild("claw", ModelPartBuilder.create().uv(18, 11).cuboid(-1.5F, 0.0F, -6.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, 0.0F));
		ModelPartData claw_end = claw.addChild("claw_end", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, -5.0F));

		return TexturedModelData.of(modelData, 64, 32);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		droneBody.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
