package dev.cammiescorner.starfinder.client.models.entity.tech;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cammiescorner.starfinder.fabric.entrypoints.FabricMain;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class FPVDroneModel extends EntityModel<Entity> {
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(FabricMain.id("fpv_drone"), "main");
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

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();

		PartDefinition droneBody = modelPartData.addOrReplaceChild("droneBody", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5f, -0.5f, -2.5f, 7f, 4f, 7f, new CubeDeformation(0f)).texOffs(0, 11).addBox(-2f, -0.5f, -4.5f, 4f, 4f, 2f, new CubeDeformation(0f)).texOffs(49, 0).addBox(0.25f, -8f, 4f, 1f, 10f, 1f, new CubeDeformation(0f)).texOffs(45, 0).addBox(-1.25f, -4f, 4f, 1f, 6f, 1f, new CubeDeformation(0f)), PartPose.offset(0f, 19f, 0f));

		PartDefinition camera = droneBody.addOrReplaceChild("camera", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5f, -1.5f, -1.5f, 3f, 3f, 3f, new CubeDeformation(0f)), PartPose.offset(0f, 1.5f, -2f));

		PartDefinition arm_front_right = droneBody.addOrReplaceChild("arm_front_right", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5f, -0.5f, -2.5f, 0f, -0.7854f, 0f));
		PartDefinition thruster_tail_r1 = arm_front_right.addOrReplaceChild("thruster_tail_r1", CubeListBuilder.create().texOffs(21, 0).addBox(-8f, 6f, -1f, 2f, 2f, 2f, new CubeDeformation(0.01f)).texOffs(37, 0).addBox(-8f, 1f, -1f, 2f, 5f, 2f, new CubeDeformation(0.01f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.3491f));
		PartDefinition support_2_r1 = arm_front_right.addOrReplaceChild("support_2_r1", CubeListBuilder.create().texOffs(30, 10).addBox(-8f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, -0.2618f));
		PartDefinition support_1_r1 = arm_front_right.addOrReplaceChild("support_1_r1", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(-7f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(0f)).mirror(false), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.1745f));
		PartDefinition thuster_end_1 = arm_front_right.addOrReplaceChild("thuster_end_1", CubeListBuilder.create(), PartPose.offset(-8.75f, 3.25f, 0f));

		PartDefinition arm_back_left = droneBody.addOrReplaceChild("arm_back_left", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5f, -0.5f, 4.5f, 0f, -0.7854f, 0f));
		PartDefinition thruster_tail_r2 = arm_back_left.addOrReplaceChild("thruster_tail_r2", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(6f, 6f, -1f, 2f, 2f, 2f, new CubeDeformation(0.01f)).mirror(false).texOffs(37, 0).mirror().addBox(6f, 1f, -1f, 2f, 5f, 2f, new CubeDeformation(0.01f)).mirror(false), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, -0.3491f));
		PartDefinition support_2_r2 = arm_back_left.addOrReplaceChild("support_2_r2", CubeListBuilder.create().texOffs(30, 10).addBox(0f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.2618f));
		PartDefinition support_1_r2 = arm_back_left.addOrReplaceChild("support_1_r2", CubeListBuilder.create().texOffs(28, 7).addBox(-1f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(0f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, -0.1745f));
		PartDefinition thruster_end_2 = arm_back_left.addOrReplaceChild("thruster_end_2", CubeListBuilder.create(), PartPose.offset(8.75f, 3.25f, 0f));

		PartDefinition arm_front_left = droneBody.addOrReplaceChild("arm_front_left", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5f, -0.5f, -2.5f, 0f, 0.7854f, 0f));
		PartDefinition thruster_tail_r3 = arm_front_left.addOrReplaceChild("thruster_tail_r3", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(6f, 6f, -1f, 2f, 2f, 2f, new CubeDeformation(0.01f)).mirror(false).texOffs(37, 0).mirror().addBox(6f, 1f, -1f, 2f, 5f, 2f, new CubeDeformation(0.01f)).mirror(false), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, -0.3491f));
		PartDefinition support_2_r3 = arm_front_left.addOrReplaceChild("support_2_r3", CubeListBuilder.create().texOffs(30, 10).addBox(0f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.2618f));
		PartDefinition support_1_r3 = arm_front_left.addOrReplaceChild("support_1_r3", CubeListBuilder.create().texOffs(28, 7).addBox(-1f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(0f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, -0.1745f));
		PartDefinition thruster_end_3 = arm_front_left.addOrReplaceChild("thruster_end_3", CubeListBuilder.create(), PartPose.offset(8.75f, 3.25f, 0f));

		PartDefinition arm_back_right = droneBody.addOrReplaceChild("arm_back_right", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5f, -0.5f, 4.5f, 0f, 0.7854f, 0f));
		PartDefinition thruster_tail_r4 = arm_back_right.addOrReplaceChild("thruster_tail_r4", CubeListBuilder.create().texOffs(21, 0).addBox(-8f, 6f, -1f, 2f, 2f, 2f, new CubeDeformation(0.01f)).texOffs(37, 0).addBox(-8f, 1f, -1f, 2f, 5f, 2f, new CubeDeformation(0.01f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.3491f));
		PartDefinition support_2_r4 = arm_back_right.addOrReplaceChild("support_2_r4", CubeListBuilder.create().texOffs(30, 10).addBox(-8f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, -0.2618f));
		PartDefinition support_1_r4 = arm_back_right.addOrReplaceChild("support_1_r4", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(-7f, 0f, -1f, 8f, 1f, 2f, new CubeDeformation(0f)).mirror(false), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.1745f));
		PartDefinition thruster_end_4 = arm_back_right.addOrReplaceChild("thruster_end_4", CubeListBuilder.create(), PartPose.offset(-8.75f, 3.25f, 0f));

		PartDefinition rotatingBall = droneBody.addOrReplaceChild("rotatingBall", CubeListBuilder.create().texOffs(12, 11).addBox(-1.5f, -1.5f, -1.5f, 3f, 3f, 3f, new CubeDeformation(0f)), PartPose.offset(0f, 3.5f, 1f));
		PartDefinition claw = rotatingBall.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(18, 11).addBox(-1.5f, 0f, -6f, 3f, 2f, 6f, new CubeDeformation(0f)), PartPose.offset(0f, 1.5f, 0f));
		PartDefinition claw_end = claw.addOrReplaceChild("claw_end", CubeListBuilder.create(), PartPose.offset(0f, 2f, -5f));

		return LayerDefinition.create(modelData, 64, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		droneBody.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
