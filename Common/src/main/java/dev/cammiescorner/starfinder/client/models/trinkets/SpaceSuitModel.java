package dev.cammiescorner.starfinder.client.models.trinkets;

import dev.cammiescorner.starfinder.Starfinder;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class SpaceSuitModel<T extends LivingEntity> extends HumanoidModel<T> {
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Starfinder.id("space_suit"), "main");
	public final ModelPart helmet;
	public final ModelPart leftSleeve;
	public final ModelPart rightSleeve;
	public final ModelPart torso;
	public final ModelPart backpack;
	public final ModelPart leftPant;
	public final ModelPart rightPant;
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;

	public SpaceSuitModel(ModelPart root) {
		super(root);
		helmet = head.getChild("helmet");
		leftSleeve = leftArm.getChild("leftSleeve");
		rightSleeve = rightArm.getChild("rightSleeve");
		torso = body.getChild("torso");
		backpack = body.getChild("backpack");
		leftPant = leftLeg.getChild("leftPant");
		rightPant = rightLeg.getChild("rightPant");
		leftBoot = leftLeg.getChild("leftBoot");
		rightBoot = rightLeg.getChild("rightBoot");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition data = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition head = data.getRoot().getChild(PartNames.HEAD);
		PartDefinition body = data.getRoot().getChild(PartNames.BODY);
		PartDefinition rightArm = data.getRoot().getChild(PartNames.RIGHT_ARM);
		PartDefinition leftArm = data.getRoot().getChild(PartNames.LEFT_ARM);
		PartDefinition rightLeg = data.getRoot().getChild(PartNames.RIGHT_LEG);
		PartDefinition leftLeg = data.getRoot().getChild(PartNames.LEFT_LEG);

		PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(64, 0).addBox(-4f, -8f, -4f, 8f, 8f, 8f, new CubeDeformation(0.9f)).texOffs(96, 0).addBox(-4f, -8f, -4f, 8f, 8f, 8f, new CubeDeformation(0.6f)), PartPose.offset(0f, 0f, 0f));

		PartDefinition leftSleeve = leftArm.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(112, 16).addBox(-1f, -2f, -2f, 4f, 12f, 4f, new CubeDeformation(0.4f)), PartPose.offset(0f, 0f, 0f));
		PartDefinition rightSleeve = rightArm.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(64, 16).addBox(-3f, -2f, -2f, 4f, 12f, 4f, new CubeDeformation(0.4f)), PartPose.offset(0f, 0f, 0f));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(80, 16).addBox(-4f, 0f, -2f, 8f, 12f, 4f, new CubeDeformation(0.6f)), PartPose.offset(0f, 0f, 0f));
		PartDefinition backpack = body.addOrReplaceChild("backpack", CubeListBuilder.create().texOffs(80, 48).addBox(-4.5f, 0f, 2f, 9f, 11f, 4f, new CubeDeformation(0f)), PartPose.offset(0f, 0f, 0f));

		PartDefinition leftPant = leftLeg.addOrReplaceChild("leftPant", CubeListBuilder.create().texOffs(112, 32).addBox(-2f, 0f, -2f, 4f, 12f, 4f, new CubeDeformation(0.4f)), PartPose.offset(0f, 0f, 0f));
		PartDefinition rightPant = rightLeg.addOrReplaceChild("rightPant", CubeListBuilder.create().texOffs(64, 32).addBox(-2f, 0f, -2f, 4f, 12f, 4f, new CubeDeformation(0.4f)), PartPose.offset(0f, 0f, 0f));

		PartDefinition leftBoot = leftLeg.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(96, 32).addBox(-2f, 0f, -2f, 4f, 12f, 4f, new CubeDeformation(0.6f)), PartPose.offset(0f, 0f, 0f));
		PartDefinition rightBoot = rightLeg.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(80, 32).addBox(-2f, 0f, -2f, 4f, 12f, 4f, new CubeDeformation(0.6f)), PartPose.offset(0f, 0f, 0f));

		return LayerDefinition.create(data, 128, 64);
	}
}
