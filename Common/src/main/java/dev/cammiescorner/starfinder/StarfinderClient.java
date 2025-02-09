package dev.cammiescorner.starfinder;

import commonnetwork.api.Network;
import dev.cammiescorner.starfinder.client.models.entity.spaceship.SmallSpaceshipModel;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVDroneModel;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVRoverModel;
import dev.cammiescorner.starfinder.client.models.trinkets.SpaceSuitModel;
import dev.cammiescorner.starfinder.client.renderer.entity.spaceship.SmallSpaceshipEntityRenderer;
import dev.cammiescorner.starfinder.client.renderer.entity.tech.FPVDroneEntityRenderer;
import dev.cammiescorner.starfinder.client.renderer.entity.tech.FPVRoverEntityRenderer;
import dev.cammiescorner.starfinder.common.data.TintedDataComponent;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import dev.cammiescorner.starfinder.common.networking.serverbound.ServerboundTintHelmetPacket;
import dev.cammiescorner.starfinder.common.registries.StarfinderData;
import dev.cammiescorner.starfinder.common.registries.StarfinderEntities;
import dev.cammiescorner.starfinder.common.registries.StarfinderItems;
import dev.upcraft.sparkweave.api.client.event.RegisterEntityRenderersEvent;
import dev.upcraft.sparkweave.api.client.event.RegisterItemPropertiesEvent;
import dev.upcraft.sparkweave.api.client.event.RegisterLayerDefinitionsEvent;
import dev.upcraft.sparkweave.api.entrypoint.ClientEntryPoint;
import dev.upcraft.sparkweave.api.event.ItemMenuInteractionEvent;
import dev.upcraft.sparkweave.api.platform.ModContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.ClickAction;

public class StarfinderClient implements ClientEntryPoint {
	public static final ResourceLocation VISOR_OVERLAY = Starfinder.id("textures/gui/hud/space_suit_visor_overlay.png");
	public static final ResourceLocation TINTED_VISOR_OVERLAY = Starfinder.id("textures/gui/hud/tinted_space_suit_visor_overlay.png");
	public static final ResourceLocation SPACE_SUIT_INDICATORS = Starfinder.id("hud/space_suit_indicators");

	@Override
	public void onInitializeClient(ModContainer mod) {
		RegisterLayerDefinitionsEvent.EVENT.register(event -> {
			event.registerModelLayers(SpaceSuitModel.MODEL_LAYER, SpaceSuitModel::getTexturedModelData);
			event.registerModelLayers(SmallSpaceshipModel.MODEL_LAYER, SmallSpaceshipModel::getTexturedModelData);
			event.registerModelLayers(FPVDroneModel.MODEL_LAYER, FPVDroneModel::getTexturedModelData);
			event.registerModelLayers(FPVRoverModel.MODEL_LAYER, FPVRoverModel::getTexturedModelData);
		});

		RegisterEntityRenderersEvent.EVENT.register(event -> {
			event.registerRenderer(StarfinderEntities.SMALL_SPACESHIP, SmallSpaceshipEntityRenderer::new);
			event.registerRenderer(StarfinderEntities.FPV_DRONE, FPVDroneEntityRenderer::new);
			event.registerRenderer(StarfinderEntities.FPV_ROVER, FPVRoverEntityRenderer::new);
		});
		
		RegisterItemPropertiesEvent.EVENT.register(event -> {
			event.register(StarfinderItems.WHITE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.ORANGE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.MAGENTA_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.LIGHT_BLUE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.YELLOW_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.LIME_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.PINK_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.GRAY_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.LIGHT_GRAY_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.CYAN_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.PURPLE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.BLUE_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.BROWN_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.GREEN_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.RED_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
			event.register(StarfinderItems.BLACK_SPACE_HELMET, Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1f : 0f);
		});

		ItemMenuInteractionEvent.EVENT.register((menu, player, level, clickAction, slot, slotStack, cursorStack) -> {
			if(clickAction == ClickAction.SECONDARY && cursorStack.isEmpty() && slotStack.getItem() instanceof SpaceSuitItem helmet && helmet.getType() == SpaceSuitItem.SuitPiece.HELMET) {
				slotStack.set(StarfinderData.IS_TINTED.get(), TintedDataComponent.get(slotStack).toggleTint());
				Network.getNetworkHandler().sendToServer(new ServerboundTintHelmetPacket(slot.getContainerSlot()));
				return true;
			}

			return false;
		});
	}
}
