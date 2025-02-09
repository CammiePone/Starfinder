package dev.cammiescorner.starfinder.client.models.entity.tech;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cammiescorner.starfinder.Starfinder;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class FPVRoverModel extends EntityModel<Entity> {
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Starfinder.id("fpv_rover"), "main");
	public final ModelPart body;
	public final ModelPart frontWheels;
	public final ModelPart backWheels;
	public final ModelPart middleWheels;
	public final ModelPart toolBall;
	public final ModelPart clawPole;
	public final ModelPart clawLeft;
	public final ModelPart clawRight;
	public final ModelPart drillPole;
	public final ModelPart drillBlades;
	public final ModelPart cameraBall;
	public final ModelPart camPole;
	public final ModelPart camera;

	public FPVRoverModel(ModelPart root) {
		this.body = root.getChild("body");
		this.frontWheels = body.getChild("frontWheels");
		this.backWheels = body.getChild("backWheels");
		this.middleWheels = body.getChild("middleWheels");
		this.toolBall = body.getChild("toolBall");
		this.clawPole = toolBall.getChild("toolPole").getChild("clawPole");
		this.clawLeft = clawPole.getChild("clawLeft");
		this.clawRight = clawPole.getChild("clawRight");
		this.drillPole = toolBall.getChild("toolPole").getChild("drillPole");
		this.drillBlades = drillPole.getChild("drillMotor").getChild("drillBlades");
		this.cameraBall = body.getChild("cameraBall");
		this.camPole = cameraBall.getChild("camPoleBase").getChild("camPole");
		this.camera = camPole.getChild("camera");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition root = meshDefinition.getRoot();

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12f, -12f, -21f, 24f, 9f, 42f, new CubeDeformation(0f)).texOffs(14, 74).mirror().addBox(12f, -12f, -21f, 8f, 12f, 42f, new CubeDeformation(0f)).mirror(false).texOffs(114, 74).addBox(-20f, -12f, -21f, 8f, 12f, 42f, new CubeDeformation(0f)).texOffs(0, 24).addBox(-8f, -16f, 12f, 6f, 4f, 6f, new CubeDeformation(0f)).texOffs(0, 0).addBox(-7f, -32f, 16f, 1f, 16f, 1f, new CubeDeformation(0f)).texOffs(5, 0).addBox(-4f, -25f, 13f, 1f, 9f, 1f, new CubeDeformation(0f)), PartPose.offset(0f, 24f, 0f));

		PartDefinition frontWheels = body.addOrReplaceChild("frontWheels", CubeListBuilder.create().texOffs(22, 26).mirror().addBox(18.1f, -4f, -4f, 2f, 8f, 8f, new CubeDeformation(0f)).mirror(false).texOffs(22, 26).addBox(-20.1f, -4f, -4f, 2f, 8f, 8f, new CubeDeformation(0f)), PartPose.offset(0f, -6f, -15f));
		PartDefinition backWheels = body.addOrReplaceChild("backWheels", CubeListBuilder.create().texOffs(22, 26).mirror().addBox(18.1f, -4f, -4f, 2f, 8f, 8f, new CubeDeformation(0f)).mirror(false).texOffs(22, 26).addBox(-20.1f, -4f, -4f, 2f, 8f, 8f, new CubeDeformation(0f)), PartPose.offset(0f, -6f, 15f));
		PartDefinition middleWheels = body.addOrReplaceChild("middleWheels", CubeListBuilder.create().texOffs(10, 34).mirror().addBox(18.1f, -2f, -2f, 2f, 4f, 4f, new CubeDeformation(0f)).mirror(false).texOffs(10, 34).addBox(-20.1f, -2f, -2f, 2f, 4f, 4f, new CubeDeformation(0f)), PartPose.offset(0f, -4f, -2f));

		PartDefinition toolBall = body.addOrReplaceChild("toolBall", CubeListBuilder.create().texOffs(106, 30).addBox(-3f, -3f, -3f, 6f, 6f, 6f, new CubeDeformation(0f)), PartPose.offset(0f, -11.5f, -18.5f));
		PartDefinition toolPole = toolBall.addOrReplaceChild("toolPole", CubeListBuilder.create().texOffs(131, 12).addBox(-2f, -24f, -2f, 4f, 26f, 4f, new CubeDeformation(0f)), PartPose.offset(0f, -2f, 0f));
		PartDefinition clawPole = toolPole.addOrReplaceChild("clawPole", CubeListBuilder.create().texOffs(0, 55).addBox(-1f, -1f, -27f, 2f, 2f, 26f, new CubeDeformation(0f)).texOffs(106, 0).addBox(-1.5f, -1.5f, -1.5f, 3f, 3f, 3f, new CubeDeformation(0f)), PartPose.offset(0f, -24f, 0f));
		PartDefinition clawLeft = clawPole.addOrReplaceChild("clawLeft", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-1f, 0f, -8f, 5f, 0f, 10f, new CubeDeformation(0f)).mirror(false), PartPose.offset(1f, 0f, -26f));
		PartDefinition clawRight = clawPole.addOrReplaceChild("clawRight", CubeListBuilder.create().texOffs(22, 0).addBox(-4f, 0f, -8f, 5f, 0f, 10f, new CubeDeformation(0f)), PartPose.offset(-1f, 0f, -26f));

		PartDefinition drillPole = toolPole.addOrReplaceChild("drillPole", CubeListBuilder.create().texOffs(0, 55).addBox(-1f, -1f, -27f, 2f, 2f, 26f, new CubeDeformation(0f)).texOffs(106, 0).addBox(-1.5f, -1.5f, -1.5f, 3f, 3f, 3f, new CubeDeformation(0f)), PartPose.offset(0f, -24f, 0f));
		PartDefinition drillMotor = drillPole.addOrReplaceChild("drillMotor", CubeListBuilder.create().texOffs(0, 71).addBox(-2.5f, -2.5f, -2f, 5f, 5f, 5f, new CubeDeformation(0f)), PartPose.offset(0f, 0f, -26f));
		PartDefinition drillBlades = drillMotor.addOrReplaceChild("drillBlades", CubeListBuilder.create().texOffs(0, 51).addBox(-2.5f, -2.5f, -3f, 5f, 5f, 1f, new CubeDeformation(0f)).texOffs(0, 62).addBox(-1.5f, -1.5f, -5f, 3f, 3f, 1f, new CubeDeformation(0f)).texOffs(0, 69).addBox(-0.5f, -0.5f, -7f, 1f, 1f, 1f, new CubeDeformation(0f)), PartPose.offset(0f, 0f, 0f));
		PartDefinition drillBlades2 = drillBlades.addOrReplaceChild("drillBlades2", CubeListBuilder.create().texOffs(0, 66).addBox(-1f, -1f, -6f, 2f, 2f, 1f, new CubeDeformation(0f)).texOffs(0, 57).addBox(-2f, -2f, -4f, 4f, 4f, 1f, new CubeDeformation(0f)), PartPose.offsetAndRotation(0f, 0f, 0f, 0f, 0f, 0.7854f));

		PartDefinition cameraBall = body.addOrReplaceChild("cameraBall", CubeListBuilder.create().texOffs(106, 18).addBox(-3f, -3f, -3f, 6f, 6f, 6f, new CubeDeformation(0f)), PartPose.offset(9f, -11.5f, 7.5f));
		PartDefinition camPoleBase = cameraBall.addOrReplaceChild("camPoleBase", CubeListBuilder.create().texOffs(131, 12).addBox(-2f, -24f, -2f, 4f, 26f, 4f, new CubeDeformation(0f)), PartPose.offset(0f, -2f, 0f));
		PartDefinition camPole = camPoleBase.addOrReplaceChild("camPole", CubeListBuilder.create().texOffs(0, 55).addBox(-1f, -1f, -27f, 2f, 2f, 26f, new CubeDeformation(0f)).texOffs(106, 0).addBox(-1.5f, -1.5f, -1.5f, 3f, 3f, 3f, new CubeDeformation(0f)), PartPose.offset(0f, -24f, 0f));
		PartDefinition camera = camPole.addOrReplaceChild("camera", CubeListBuilder.create().texOffs(16, 2).addBox(-2f, -4f, -4f, 4f, 4f, 8f, new CubeDeformation(0f)), PartPose.offset(0f, 0f, -26f));

		return LayerDefinition.create(meshDefinition, 256, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}
