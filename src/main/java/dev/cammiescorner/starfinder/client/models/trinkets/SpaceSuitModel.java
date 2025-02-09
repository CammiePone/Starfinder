package dev.cammiescorner.starfinder.client.models.trinkets;

import dev.cammiescorner.starfinder.Starfinder;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;

public class SpaceSuitModel<T extends LivingEntity> extends BipedEntityModel<T> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Starfinder.id("space_suit"), "main");
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

	public static TexturedModelData getTexturedModelData() {
		ModelData data = BipedEntityModel.getModelData(Dilation.NONE, 0);
		ModelPartData head = data.getRoot().getChild(EntityModelPartNames.HEAD);
		ModelPartData body = data.getRoot().getChild(EntityModelPartNames.BODY);
		ModelPartData rightArm = data.getRoot().getChild(EntityModelPartNames.RIGHT_ARM);
		ModelPartData leftArm = data.getRoot().getChild(EntityModelPartNames.LEFT_ARM);
		ModelPartData rightLeg = data.getRoot().getChild(EntityModelPartNames.RIGHT_LEG);
		ModelPartData leftLeg = data.getRoot().getChild(EntityModelPartNames.LEFT_LEG);

		ModelPartData helmet = head.addChild("helmet", ModelPartBuilder.create().uv(64, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.9F)).uv(96, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftSleeve = leftArm.addChild("leftSleeve", ModelPartBuilder.create().uv(112, 16).cuboid(-1F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData rightSleeve = rightArm.addChild("rightSleeve", ModelPartBuilder.create().uv(64, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(80, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData backpack = body.addChild("backpack", ModelPartBuilder.create().uv(80, 48).cuboid(-4.5F, 0.0F, 2.0F, 9.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftPant = leftLeg.addChild("leftPant", ModelPartBuilder.create().uv(112, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData rightPant = rightLeg.addChild("rightPant", ModelPartBuilder.create().uv(64, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftBoot = leftLeg.addChild("leftBoot", ModelPartBuilder.create().uv(96, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData rightBoot = rightLeg.addChild("rightBoot", ModelPartBuilder.create().uv(80, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(data, 128, 64);
	}
}
