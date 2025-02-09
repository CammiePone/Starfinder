package dev.cammiescorner.starfinder.client.models.entity.spaceship;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cammiescorner.starfinder.Starfinder;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class SmallSpaceshipModel extends EntityModel<Entity> {
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Starfinder.id("small_spaceship"), "main");
	public final ModelPart body;
	public final ModelPart landingGearFront;
	public final ModelPart landingGearFront2;
	public final ModelPart landingGearBackR;
	public final ModelPart landingGearBackR2;
	public final ModelPart landingGearBackL;
	public final ModelPart landingGearBackL2;
	public final ModelPart door;
	public final ModelPart gearStick;

	public SmallSpaceshipModel(ModelPart root) {
		this.body = root.getChild("body");
		this.landingGearFront = body.getChild("landingGearFront");
		this.landingGearFront2 = landingGearFront.getChild("landingGearFront2");
		this.landingGearBackR = body.getChild("landingGearBackR");
		this.landingGearBackR2 = landingGearBackR.getChild("landingGearBackR2");
		this.landingGearBackL = body.getChild("landingGearBackL");
		this.landingGearBackL2 = landingGearBackL.getChild("landingGearBackL2");
		this.door = body.getChild("door");
		this.gearStick = body.getChild("gearStick");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();

		PartDefinition body = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(257, 222).addBox(-12.8f, -2f, -46f, 1f, 6f, 8f, new CubeDeformation(0f)).texOffs(385, 223).addBox(-11f, 9f, -50f, 22f, 1f, 32f, new CubeDeformation(0f)).texOffs(303, 231).addBox(-11f, 3f, -27f, 22f, 6f, 19f, new CubeDeformation(0f)).texOffs(200, 206).mirror().addBox(-7.5f, 6f, -45f, 15f, 3f, 13f, new CubeDeformation(0f)).mirror(false).texOffs(200, 206).mirror().addBox(-7.5f, 1f, -27f, 15f, 3f, 13f, new CubeDeformation(0f)).mirror(false).texOffs(256, 245).addBox(-11f, -1f, -51f, 22f, 10f, 1f, new CubeDeformation(0f)).texOffs(208, 236).addBox(-11f, -3f, -50f, 22f, 8f, 2f, new CubeDeformation(0f)).texOffs(222, 228).addBox(3f, -3f, -48f, 7f, 7f, 1f, new CubeDeformation(0f)).texOffs(238, 222).addBox(-12.8f, -2f, -46f, 1f, 6f, 8f, new CubeDeformation(0.01f)).texOffs(214, 166).addBox(-1.5f, 6.1f, -51f, 3f, 3f, 18f, new CubeDeformation(0f)).texOffs(0, 86).addBox(-13f, -1.9f, -45.6f, 26f, 18f, 43f, new CubeDeformation(0.1f)).texOffs(95, 104).addBox(-13f, -1.9f, -48.6f, 26f, 18f, 43f, new CubeDeformation(-0.1f)).texOffs(0, 0).addBox(-14f, -18.5f, -2.5f, 28f, 35f, 51f, new CubeDeformation(0f)).texOffs(114, 174).addBox(-34f, -28f, -3.5f, 4f, 44f, 38f, new CubeDeformation(0.02f)).texOffs(210, 42).addBox(-30.5f, 1f, 3.5f, 17f, 4f, 30f, new CubeDeformation(0f)).texOffs(210, 42).addBox(13.5f, 1f, 3.5f, 17f, 4f, 30f, new CubeDeformation(0f)).texOffs(114, 174).mirror().addBox(30f, -28f, -3.5f, 4f, 44f, 38f, new CubeDeformation(0.02f)).mirror(false).texOffs(222, 0).mirror().addBox(4f, -32f, -3.5f, 30f, 4f, 38f, new CubeDeformation(0.02f)).mirror(false).texOffs(222, 0).addBox(-34f, -32f, -3.5f, 30f, 4f, 38f, new CubeDeformation(0.02f)).texOffs(416, 0).addBox(-8f, -46f, 4.5f, 4f, 14f, 30f, new CubeDeformation(0.01f)).texOffs(328, 0).addBox(-48f, 12f, 4.5f, 14f, 4f, 30f, new CubeDeformation(0.01f)).texOffs(452, 202).addBox(-27f, 6f, -41.5f, 14f, 4f, 16f, new CubeDeformation(0.01f)).texOffs(328, 0).mirror().addBox(34f, 12f, 4.5f, 14f, 4f, 30f, new CubeDeformation(0.01f)).mirror(false).texOffs(452, 202).mirror().addBox(13f, 6f, -41.5f, 14f, 4f, 16f, new CubeDeformation(0.01f)).mirror(false).texOffs(416, 0).addBox(4f, -46f, 4.5f, 4f, 14f, 30f, new CubeDeformation(0.01f)).texOffs(472, 45).addBox(3f, 6f, 48.5f, 10f, 10f, 10f, new CubeDeformation(0f)).texOffs(472, 45).addBox(-13f, 6f, 48.5f, 10f, 10f, 10f, new CubeDeformation(0f)).texOffs(472, 45).addBox(-13f, -9f, 48.5f, 10f, 10f, 10f, new CubeDeformation(0f)).texOffs(472, 45).addBox(3f, -9f, 48.5f, 10f, 10f, 10f, new CubeDeformation(0f)), PartPose.offset(0f, 0f, 0f));
		PartDefinition cubeR1 = body.addOrReplaceChild("cubeR1", CubeListBuilder.create().texOffs(474, 193).mirror().addBox(-15f, -2f, 0f, 15f, 4f, 4f, new CubeDeformation(0f)).mirror(false), PartPose.offsetAndRotation(27f, 8f, -41.5f, 0f, -0.2618f, 0f));
		PartDefinition cubeR2 = body.addOrReplaceChild("cubeR2", CubeListBuilder.create().texOffs(320, 0).mirror().addBox(-15f, -2f, 0f, 15f, 4f, 4f, new CubeDeformation(0f)).mirror(false), PartPose.offsetAndRotation(48f, 14f, 4.5f, 0f, -0.2618f, 0f));
		PartDefinition cubeR3 = body.addOrReplaceChild("cubeR3", CubeListBuilder.create().texOffs(474, 193).addBox(0f, -2f, 0f, 15f, 4f, 4f, new CubeDeformation(0f)), PartPose.offsetAndRotation(-27f, 8f, -41.5f, 0f, 0.2618f, 0f));
		PartDefinition cubeR4 = body.addOrReplaceChild("cubeR4", CubeListBuilder.create().texOffs(320, 0).addBox(0f, -2f, 0f, 15f, 4f, 4f, new CubeDeformation(0f)), PartPose.offsetAndRotation(-48f, 14f, 4.5f, 0f, 0.2618f, 0f));
		PartDefinition cubeR5 = body.addOrReplaceChild("cubeR5", CubeListBuilder.create().texOffs(387, 0).addBox(10f, 0f, 0f, 4f, 15f, 4f, new CubeDeformation(0f)).texOffs(387, 0).addBox(-2f, 0f, 0f, 4f, 15f, 4f, new CubeDeformation(0f)), PartPose.offsetAndRotation(-6f, -46f, 4.5f, -0.2618f, 0f, 0f));
		PartDefinition cubeR6 = body.addOrReplaceChild("cubeR6", CubeListBuilder.create().texOffs(194, 194).addBox(-1.5f, -7f, -15f, 3f, 2f, 10f, new CubeDeformation(0f)), PartPose.offsetAndRotation(0f, 14f, -37f, -0.2182f, 0f, 0f));
		PartDefinition cubeR7 = body.addOrReplaceChild("cubeR7", CubeListBuilder.create().texOffs(220, 188).addBox(4f, -22f, -1f, 15f, 15f, 3f, new CubeDeformation(0f)), PartPose.offsetAndRotation(-11.5f, 8.5312f, -17.3588f, -0.1745f, 0f, 0f));
		PartDefinition cubeR8 = body.addOrReplaceChild("cubeR8", CubeListBuilder.create().texOffs(220, 188).addBox(4f, -22f, -1f, 15f, 15f, 3f, new CubeDeformation(0f)), PartPose.offsetAndRotation(-11.5f, 13.5312f, -35.3588f, -0.1745f, 0f, 0f));

		PartDefinition landingGearFront = body.addOrReplaceChild("landingGearFront", CubeListBuilder.create().texOffs(466, 242).addBox(-3f, 0f, -1.5f, 6f, 6f, 4f, new CubeDeformation(0f)), PartPose.offset(0f, 16f, -32f));
		PartDefinition landingGearFront2 = landingGearFront.addOrReplaceChild("landingGearFront2", CubeListBuilder.create().texOffs(400, 203).addBox(-4f, 0f, -8.5f, 8f, 2f, 18f, new CubeDeformation(0f)), PartPose.offset(0f, 6f, 0f));

		PartDefinition landingGearBackR = body.addOrReplaceChild("landingGearBackR", CubeListBuilder.create().texOffs(466, 242).addBox(-3f, 0f, -1.5f, 6f, 6f, 4f, new CubeDeformation(0f)), PartPose.offset(-9f, 16f, 30f));
		PartDefinition landingGearBackR2 = landingGearBackR.addOrReplaceChild("landingGearBackR2", CubeListBuilder.create().texOffs(400, 203).addBox(-4f, 0f, -8.5f, 8f, 2f, 18f, new CubeDeformation(0f)), PartPose.offset(0f, 6f, 0f));

		PartDefinition landingGearBackL = body.addOrReplaceChild("landingGearBackL", CubeListBuilder.create().texOffs(466, 242).addBox(-3f, 0f, -1.5f, 6f, 6f, 4f, new CubeDeformation(0f)), PartPose.offset(9f, 16f, 30f));
		PartDefinition landingGearBackL2 = landingGearBackL.addOrReplaceChild("landingGearBackL2", CubeListBuilder.create().texOffs(400, 203).addBox(-4f, 0f, -8.5f, 8f, 2f, 18f, new CubeDeformation(0f)), PartPose.offset(0f, 6f, 0f));

		PartDefinition door = body.addOrReplaceChild("door", CubeListBuilder.create().texOffs(0, 196).addBox(-13f, -33.6f, 13.5f, 26f, 17f, 31f, new CubeDeformation(-0.1f)).texOffs(127, 55).addBox(-13f, -33.8f, 13.6f, 26f, 17f, 31f, new CubeDeformation(0.15f)), PartPose.offset(0f, 16f, -47f));
		PartDefinition cubeR9 = door.addOrReplaceChild("cubeR9", CubeListBuilder.create().texOffs(107, 2).addBox(-13f, -22f, -8f, 26f, 18f, 31f, new CubeDeformation(0.16f)), PartPose.offsetAndRotation(0f, -2f, 10f, 0.6981f, 0f, 0f));
		PartDefinition cubeR10 = door.addOrReplaceChild("cubeR10", CubeListBuilder.create().texOffs(0, 147).addBox(-13f, -22f, -8f, 26f, 18f, 31f, new CubeDeformation(-0.1f)), PartPose.offsetAndRotation(0f, -2.0038f, 10.1346f, 0.6981f, 0f, 0f));

		PartDefinition gearStick = body.addOrReplaceChild("gearStick", CubeListBuilder.create(), PartPose.offset(0f, 5f, -44.25f));
		PartDefinition gearStickKnob = gearStick.addOrReplaceChild("gearStickKnob", CubeListBuilder.create().texOffs(248, 179).addBox(-1f, -12f, -11f, 2f, 2f, 2f, new CubeDeformation(0f)).texOffs(248, 174).addBox(-1f, -8f, -11f, 2f, 2f, 2f, new CubeDeformation(0f)).texOffs(244, 179).addBox(-0.5f, -10f, -10.5f, 1f, 2f, 1f, new CubeDeformation(0f)), PartPose.offsetAndRotation(0f, 9f, 8.25f, -0.2182f, 0f, 0f));

		return LayerDefinition.create(modelData, 512, 256);
	}


	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
