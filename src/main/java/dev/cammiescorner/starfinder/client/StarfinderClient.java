package dev.cammiescorner.starfinder.client;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.client.models.entity.spaceship.SmallSpaceshipModel;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVDroneModel;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVRoverModel;
import dev.cammiescorner.starfinder.client.models.trinkets.SpaceSuitModel;
import dev.cammiescorner.starfinder.client.renderer.entity.spaceship.SmallSpaceshipEntityRenderer;
import dev.cammiescorner.starfinder.client.renderer.entity.tech.FPVDroneEntityRenderer;
import dev.cammiescorner.starfinder.client.renderer.entity.tech.FPVRoverEntityRenderer;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import dev.cammiescorner.starfinder.common.registry.SFEntities;
import dev.cammiescorner.starfinder.common.registry.SFItems;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class StarfinderClient implements ClientModInitializer {
	public static final Identifier VISOR_OVERLAY = Starfinder.id("textures/gui/hud/space_suit_visor_overlay.png");
	public static final Identifier TINTED_VISOR_OVERLAY = Starfinder.id("textures/gui/hud/tinted_space_suit_visor_overlay.png");
	public static final Identifier SPACE_SUIT_INDICATORS = Starfinder.id("textures/gui/hud/space_suit_indicators.png");

	@Override
	public void onInitializeClient(ModContainer mod) {
		EntityModelLayerRegistry.registerModelLayer(SpaceSuitModel.MODEL_LAYER, SpaceSuitModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SmallSpaceshipModel.MODEL_LAYER, SmallSpaceshipModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(FPVDroneModel.MODEL_LAYER, FPVDroneModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(FPVRoverModel.MODEL_LAYER, FPVRoverModel::getTexturedModelData);

		EntityRendererRegistry.register(SFEntities.SMALL_SPACESHIP, SmallSpaceshipEntityRenderer::new);
		EntityRendererRegistry.register(SFEntities.FPV_DRONE, FPVDroneEntityRenderer::new);
		EntityRendererRegistry.register(SFEntities.FPV_ROVER, FPVRoverEntityRenderer::new);

		ModelPredicateProviderRegistry.register(SFItems.WHITE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.ORANGE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.MAGENTA_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.LIGHT_BLUE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.YELLOW_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.LIME_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.PINK_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.GRAY_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.LIGHT_GRAY_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.CYAN_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.PURPLE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.BLUE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.BROWN_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.GREEN_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.RED_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ModelPredicateProviderRegistry.register(SFItems.BLACK_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
	}
}
