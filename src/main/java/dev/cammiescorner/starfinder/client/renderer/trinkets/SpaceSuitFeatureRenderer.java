package dev.cammiescorner.starfinder.client.renderer.trinkets;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.trinkets.SpaceSuitModel;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Locale;

public class SpaceSuitFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
	private static final Identifier VISOR_OVERLAY = Starfinder.id("textures/entity/spacesuit/untinted_visor.png");
	private static final Identifier TINTED_VISOR_OVERLAY = Starfinder.id("textures/entity/spacesuit/tinted_visor.png");
	private final MinecraftClient client = MinecraftClient.getInstance();
	private SpaceSuitModel<T> model;

	public SpaceSuitFeatureRenderer(FeatureRendererContext<T, M> context) {
		super(context);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		ItemStack helmetStack = Starfinder.getSpaceHelmet(entity);
		ItemStack suitStack = Starfinder.getSpaceSuit(entity);

		if(model == null)
			model = new SpaceSuitModel<T>(client.getEntityModelLoader().getModelPart(SpaceSuitModel.MODEL_LAYER));

		model.setVisible(true);
		getContextModel().copyStateTo(model);
		model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);

		if(helmetStack.getItem() instanceof SpaceSuitItem spaceHelmet) {
			Identifier texture = Starfinder.id("textures/entity/spacesuit/" + spaceHelmet.getColor().getName().toLowerCase(Locale.ROOT) + "_space_suit.png");

			model.helmet.visible = true;
			model.backpack.visible = true;

			model.leftSleeve.visible = false;
			model.rightSleeve.visible = false;
			model.torso.visible = false;
			model.leftPant.visible = false;
			model.rightPant.visible = false;
			model.leftBoot.visible = false;
			model.rightBoot.visible = false;

			model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(texture)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
			model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(texture)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
			model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(SpaceSuitItem.isTinted(helmetStack) ? TINTED_VISOR_OVERLAY : VISOR_OVERLAY)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
		}

		if(suitStack.getItem() instanceof SpaceSuitItem spaceSuit) {
			Identifier texture = Starfinder.id("textures/entity/spacesuit/" + spaceSuit.getColor().getName().toLowerCase(Locale.ROOT) + "_space_suit.png");

			model.helmet.visible = false;
			model.backpack.visible = false;

			model.leftSleeve.visible = true;
			model.rightSleeve.visible = true;
			model.torso.visible = true;
			model.leftPant.visible = true;
			model.rightPant.visible = true;
			model.leftBoot.visible = true;
			model.rightBoot.visible = true;

			model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(texture)), light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);
		}
	}
}
