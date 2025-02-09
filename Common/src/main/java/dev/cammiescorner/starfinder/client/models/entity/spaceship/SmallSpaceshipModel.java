package dev.cammiescorner.starfinder.client.models.entity.spaceship;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.fabric.entrypoints.FabricMain;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
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
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(257, 222).cuboid(-12.8F, -2.0F, -46.0F, 1.0F, 6.0F, 8.0F, new Dilation(0.0F)).uv(385, 223).cuboid(-11.0F, 9.0F, -50.0F, 22.0F, 1.0F, 32.0F, new Dilation(0.0F)).uv(303, 231).cuboid(-11.0F, 3.0F, -27.0F, 22.0F, 6.0F, 19.0F, new Dilation(0.0F)).uv(200, 206).mirrored().cuboid(-7.5F, 6.0F, -45.0F, 15.0F, 3.0F, 13.0F, new Dilation(0.0F)).mirrored(false).uv(200, 206).mirrored().cuboid(-7.5F, 1.0F, -27.0F, 15.0F, 3.0F, 13.0F, new Dilation(0.0F)).mirrored(false).uv(256, 245).cuboid(-11.0F, -1.0F, -51.0F, 22.0F, 10.0F, 1.0F, new Dilation(0.0F)).uv(208, 236).cuboid(-11.0F, -3.0F, -50.0F, 22.0F, 8.0F, 2.0F, new Dilation(0.0F)).uv(222, 228).cuboid(3.0F, -3.0F, -48.0F, 7.0F, 7.0F, 1.0F, new Dilation(0.0F)).uv(238, 222).cuboid(-12.8F, -2.0F, -46.0F, 1.0F, 6.0F, 8.0F, new Dilation(0.01F)).uv(214, 166).cuboid(-1.5F, 6.1F, -51.0F, 3.0F, 3.0F, 18.0F, new Dilation(0.0F)).uv(0, 86).cuboid(-13.0F, -1.9F, -45.6F, 26.0F, 18.0F, 43.0F, new Dilation(0.1F)).uv(95, 104).cuboid(-13.0F, -1.9F, -48.6F, 26.0F, 18.0F, 43.0F, new Dilation(-0.1F)).uv(0, 0).cuboid(-14.0F, -18.5F, -2.5F, 28.0F, 35.0F, 51.0F, new Dilation(0.0F)).uv(114, 174).cuboid(-34.0F, -28.0F, -3.5F, 4.0F, 44.0F, 38.0F, new Dilation(0.02F)).uv(210, 42).cuboid(-30.5F, 1.0F, 3.5F, 17.0F, 4.0F, 30.0F, new Dilation(0.0F)).uv(210, 42).cuboid(13.5F, 1.0F, 3.5F, 17.0F, 4.0F, 30.0F, new Dilation(0.0F)).uv(114, 174).mirrored().cuboid(30.0F, -28.0F, -3.5F, 4.0F, 44.0F, 38.0F, new Dilation(0.02F)).mirrored(false).uv(222, 0).mirrored().cuboid(4.0F, -32.0F, -3.5F, 30.0F, 4.0F, 38.0F, new Dilation(0.02F)).mirrored(false).uv(222, 0).cuboid(-34.0F, -32.0F, -3.5F, 30.0F, 4.0F, 38.0F, new Dilation(0.02F)).uv(416, 0).cuboid(-8.0F, -46.0F, 4.5F, 4.0F, 14.0F, 30.0F, new Dilation(0.01F)).uv(328, 0).cuboid(-48.0F, 12.0F, 4.5F, 14.0F, 4.0F, 30.0F, new Dilation(0.01F)).uv(452, 202).cuboid(-27.0F, 6.0F, -41.5F, 14.0F, 4.0F, 16.0F, new Dilation(0.01F)).uv(328, 0).mirrored().cuboid(34.0F, 12.0F, 4.5F, 14.0F, 4.0F, 30.0F, new Dilation(0.01F)).mirrored(false).uv(452, 202).mirrored().cuboid(13.0F, 6.0F, -41.5F, 14.0F, 4.0F, 16.0F, new Dilation(0.01F)).mirrored(false).uv(416, 0).cuboid(4.0F, -46.0F, 4.5F, 4.0F, 14.0F, 30.0F, new Dilation(0.01F)).uv(472, 45).cuboid(3.0F, 6.0F, 48.5F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)).uv(472, 45).cuboid(-13.0F, 6.0F, 48.5F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)).uv(472, 45).cuboid(-13.0F, -9.0F, 48.5F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)).uv(472, 45).cuboid(3.0F, -9.0F, 48.5F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData cubeR1 = body.addChild("cubeR1", ModelPartBuilder.create().uv(474, 193).mirrored().cuboid(-15.0F, -2.0F, 0.0F, 15.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(27.0F, 8.0F, -41.5F, 0.0F, -0.2618F, 0.0F));
		ModelPartData cubeR2 = body.addChild("cubeR2", ModelPartBuilder.create().uv(320, 0).mirrored().cuboid(-15.0F, -2.0F, 0.0F, 15.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(48.0F, 14.0F, 4.5F, 0.0F, -0.2618F, 0.0F));
		ModelPartData cubeR3 = body.addChild("cubeR3", ModelPartBuilder.create().uv(474, 193).cuboid(0.0F, -2.0F, 0.0F, 15.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-27.0F, 8.0F, -41.5F, 0.0F, 0.2618F, 0.0F));
		ModelPartData cubeR4 = body.addChild("cubeR4", ModelPartBuilder.create().uv(320, 0).cuboid(0.0F, -2.0F, 0.0F, 15.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-48.0F, 14.0F, 4.5F, 0.0F, 0.2618F, 0.0F));
		ModelPartData cubeR5 = body.addChild("cubeR5", ModelPartBuilder.create().uv(387, 0).cuboid(10.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)).uv(387, 0).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -46.0F, 4.5F, -0.2618F, 0.0F, 0.0F));
		ModelPartData cubeR6 = body.addChild("cubeR6", ModelPartBuilder.create().uv(194, 194).cuboid(-1.5F, -7.0F, -15.0F, 3.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 14.0F, -37.0F, -0.2182F, 0.0F, 0.0F));
		ModelPartData cubeR7 = body.addChild("cubeR7", ModelPartBuilder.create().uv(220, 188).cuboid(4.0F, -22.0F, -1.0F, 15.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-11.5F, 8.5312F, -17.3588F, -0.1745F, 0.0F, 0.0F));
		ModelPartData cubeR8 = body.addChild("cubeR8", ModelPartBuilder.create().uv(220, 188).cuboid(4.0F, -22.0F, -1.0F, 15.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-11.5F, 13.5312F, -35.3588F, -0.1745F, 0.0F, 0.0F));

		ModelPartData landingGearFront = body.addChild("landingGearFront", ModelPartBuilder.create().uv(466, 242).cuboid(-3.0F, 0.0F, -1.5F, 6.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, -32.0F));
		ModelPartData landingGearFront2 = landingGearFront.addChild("landingGearFront2", ModelPartBuilder.create().uv(400, 203).cuboid(-4.0F, 0.0F, -8.5F, 8.0F, 2.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData landingGearBackR = body.addChild("landingGearBackR", ModelPartBuilder.create().uv(466, 242).cuboid(-3.0F, 0.0F, -1.5F, 6.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, 16.0F, 30.0F));
		ModelPartData landingGearBackR2 = landingGearBackR.addChild("landingGearBackR2", ModelPartBuilder.create().uv(400, 203).cuboid(-4.0F, 0.0F, -8.5F, 8.0F, 2.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData landingGearBackL = body.addChild("landingGearBackL", ModelPartBuilder.create().uv(466, 242).cuboid(-3.0F, 0.0F, -1.5F, 6.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, 16.0F, 30.0F));
		ModelPartData landingGearBackL2 = landingGearBackL.addChild("landingGearBackL2", ModelPartBuilder.create().uv(400, 203).cuboid(-4.0F, 0.0F, -8.5F, 8.0F, 2.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData door = body.addChild("door", ModelPartBuilder.create().uv(0, 196).cuboid(-13.0F, -33.6F, 13.5F, 26.0F, 17.0F, 31.0F, new Dilation(-0.1F)).uv(127, 55).cuboid(-13.0F, -33.8F, 13.6F, 26.0F, 17.0F, 31.0F, new Dilation(0.15F)), ModelTransform.pivot(0.0F, 16.0F, -47.0F));
		ModelPartData cubeR9 = door.addChild("cubeR9", ModelPartBuilder.create().uv(107, 2).cuboid(-13.0F, -22.0F, -8.0F, 26.0F, 18.0F, 31.0F, new Dilation(0.16F)), ModelTransform.of(0.0F, -2.0F, 10.0F, 0.6981F, 0.0F, 0.0F));
		ModelPartData cubeR10 = door.addChild("cubeR10", ModelPartBuilder.create().uv(0, 147).cuboid(-13.0F, -22.0F, -8.0F, 26.0F, 18.0F, 31.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -2.0038F, 10.1346F, 0.6981F, 0.0F, 0.0F));

		ModelPartData gearStick = body.addChild("gearStick", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, -44.25F));
		ModelPartData gearStickKnob = gearStick.addChild("gearStickKnob", ModelPartBuilder.create().uv(248, 179).cuboid(-1.0F, -12.0F, -11.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(248, 174).cuboid(-1.0F, -8.0F, -11.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(244, 179).cuboid(-0.5F, -10.0F, -10.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.0F, 8.25F, -0.2182F, 0.0F, 0.0F));

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
