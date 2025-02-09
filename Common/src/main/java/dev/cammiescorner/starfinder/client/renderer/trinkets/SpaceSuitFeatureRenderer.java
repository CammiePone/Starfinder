package dev.cammiescorner.starfinder.client.renderer.trinkets;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.trinkets.SpaceSuitModel;
import dev.cammiescorner.starfinder.fabric.common.items.SpaceSuitItem;
import dev.cammiescorner.starfinder.fabric.entrypoints.FabricMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;

public class SpaceSuitFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
	private static final ResourceLocation VISOR_OVERLAY = Starfinder.id("textures/entity/spacesuit/untinted_visor.png");
	private static final ResourceLocation TINTED_VISOR_OVERLAY = Starfinder.id("textures/entity/spacesuit/tinted_visor.png");
	private final Minecraft client = Minecraft.getInstance();
	private SpaceSuitModel<T> model;

	public SpaceSuitFeatureRenderer(RenderLayerParent<T, M> context) {
		super(context);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headpitch) {
		ItemStack helmetStack = FabricMain.getSpaceHelmet(livingEntity);
		ItemStack suitStack = FabricMain.getSpaceSuit(livingEntity);

		if(model == null)
			model = new SpaceSuitModel<T>(client.getEntityModels().bakeLayer(SpaceSuitModel.MODEL_LAYER));

		model.setAllVisible(true);
		getParentModel().copyPropertiesTo(model);
		model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headpitch);

		if(helmetStack.getItem() instanceof SpaceSuitItem spaceHelmet) {
			ResourceLocation texture = Starfinder.id("textures/entity/spacesuit/" + spaceHelmet.getColor().getName().toLowerCase(Locale.ROOT) + "_space_suit.png");

			model.helmet.visible = true;
			model.backpack.visible = true;

			model.leftSleeve.visible = false;
			model.rightSleeve.visible = false;
			model.torso.visible = false;
			model.leftPant.visible = false;
			model.rightPant.visible = false;
			model.leftBoot.visible = false;
			model.rightBoot.visible = false;

			model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffff);
			model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffff);
			model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(SpaceSuitItem.isTinted(helmetStack) ? TINTED_VISOR_OVERLAY : VISOR_OVERLAY)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffff);
		}

		if(suitStack.getItem() instanceof SpaceSuitItem spaceSuit) {
			ResourceLocation texture = Starfinder.id("textures/entity/spacesuit/" + spaceSuit.getColor().getName().toLowerCase(Locale.ROOT) + "_space_suit.png");

			model.helmet.visible = false;
			model.backpack.visible = false;

			model.leftSleeve.visible = true;
			model.rightSleeve.visible = true;
			model.torso.visible = true;
			model.leftPant.visible = true;
			model.rightPant.visible = true;
			model.leftBoot.visible = true;
			model.rightBoot.visible = true;

			model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 0xffffff);
		}
	}
}
