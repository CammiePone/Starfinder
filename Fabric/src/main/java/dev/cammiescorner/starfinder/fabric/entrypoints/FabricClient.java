package dev.cammiescorner.starfinder.fabric.entrypoints;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.fabric.common.items.SpaceSuitItem;
import dev.cammiescorner.starfinder.fabric.common.registry.StarfinderItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class FabricClient implements ClientModInitializer {
	public static final ResourceLocation VISOR_OVERLAY = Starfinder.id("textures/gui/hud/space_suit_visor_overlay.png");
	public static final ResourceLocation TINTED_VISOR_OVERLAY = Starfinder.id("textures/gui/hud/tinted_space_suit_visor_overlay.png");
	public static final ResourceLocation SPACE_SUIT_INDICATORS = Starfinder.id("textures/gui/hud/space_suit_indicators.png");

	@Override
	public void onInitializeClient() {
		ItemProperties.register(StarfinderItems.WHITE_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.ORANGE_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.MAGENTA_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.LIGHT_BLUE_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.YELLOW_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.LIME_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.PINK_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.GRAY_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.LIGHT_GRAY_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.CYAN_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.PURPLE_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.BLUE_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.BROWN_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.GREEN_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.RED_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
		ItemProperties.register(StarfinderItems.BLACK_SPACE_HELMET.get(), Starfinder.id("tinted_visor"), (stack, world, entity, i) -> SpaceSuitItem.isTinted(stack) ? 1F : 0F);
	}
}
