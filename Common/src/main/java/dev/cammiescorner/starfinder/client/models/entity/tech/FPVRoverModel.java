package dev.cammiescorner.starfinder.client.models.entity.tech;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.cammiescorner.starfinder.Starfinder;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
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

		PartDefinition body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, -12.0F, -21.0F, 24.0F, 9.0F, 42.0F, new Dilation(0.0F)).uv(14, 74).mirrored().cuboid(12.0F, -12.0F, -21.0F, 8.0F, 12.0F, 42.0F, new Dilation(0.0F)).mirrored(false).uv(114, 74).cuboid(-20.0F, -12.0F, -21.0F, 8.0F, 12.0F, 42.0F, new Dilation(0.0F)).uv(0, 24).cuboid(-8.0F, -16.0F, 12.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-7.0F, -32.0F, 16.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)).uv(5, 0).cuboid(-4.0F, -25.0F, 13.0F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		PartDefinition frontWheels = body.addChild("frontWheels", ModelPartBuilder.create().uv(22, 26).mirrored().cuboid(18.1F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false).uv(22, 26).cuboid(-20.1F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, -15.0F));
		PartDefinition backWheels = body.addChild("backWheels", ModelPartBuilder.create().uv(22, 26).mirrored().cuboid(18.1F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false).uv(22, 26).cuboid(-20.1F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 15.0F));
		PartDefinition middleWheels = body.addChild("middleWheels", ModelPartBuilder.create().uv(10, 34).mirrored().cuboid(18.1F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false).uv(10, 34).cuboid(-20.1F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -2.0F));

		PartDefinition toolBall = body.addChild("toolBall", ModelPartBuilder.create().uv(106, 30).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -11.5F, -18.5F));
		PartDefinition toolPole = toolBall.addChild("toolPole", ModelPartBuilder.create().uv(131, 12).cuboid(-2.0F, -24.0F, -2.0F, 4.0F, 26.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
		PartDefinition clawPole = toolPole.addChild("clawPole", ModelPartBuilder.create().uv(0, 55).cuboid(-1.0F, -1.0F, -27.0F, 2.0F, 2.0F, 26.0F, new Dilation(0.0F)).uv(106, 0).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
		PartDefinition clawLeft = clawPole.addChild("clawLeft", ModelPartBuilder.create().uv(22, 0).mirrored().cuboid(-1.0F, 0.0F, -8.0F, 5.0F, 0.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.0F, 0.0F, -26.0F));
		PartDefinition clawRight = clawPole.addChild("clawRight", ModelPartBuilder.create().uv(22, 0).cuboid(-4.0F, 0.0F, -8.0F, 5.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, -26.0F));

		PartDefinition drillPole = toolPole.addChild("drillPole", ModelPartBuilder.create().uv(0, 55).cuboid(-1.0F, -1.0F, -27.0F, 2.0F, 2.0F, 26.0F, new Dilation(0.0F)).uv(106, 0).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
		PartDefinition drillMotor = drillPole.addChild("drillMotor", ModelPartBuilder.create().uv(0, 71).cuboid(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -26.0F));
		PartDefinition drillBlades = drillMotor.addChild("drillBlades", ModelPartBuilder.create().uv(0, 51).cuboid(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)).uv(0, 62).cuboid(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).uv(0, 69).cuboid(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		PartDefinition drillBlades2 = drillBlades.addChild("drillBlades2", ModelPartBuilder.create().uv(0, 66).cuboid(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).uv(0, 57).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cameraBall = body.addChild("cameraBall", ModelPartBuilder.create().uv(106, 18).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -11.5F, 7.5F));
		PartDefinition camPoleBase = cameraBall.addChild("camPoleBase", ModelPartBuilder.create().uv(131, 12).cuboid(-2.0F, -24.0F, -2.0F, 4.0F, 26.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
		PartDefinition camPole = camPoleBase.addChild("camPole", ModelPartBuilder.create().uv(0, 55).cuboid(-1.0F, -1.0F, -27.0F, 2.0F, 2.0F, 26.0F, new Dilation(0.0F)).uv(106, 0).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
		PartDefinition camera = camPole.addChild("camera", ModelPartBuilder.create().uv(16, 2).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -26.0F));

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
