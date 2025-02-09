package dev.cammiescorner.starfinder.common.registries;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class StarfinderItems {
	public static final RegistryHandler<Item> ITEMS = RegistryHandler.create(Registries.ITEM, Starfinder.MOD_ID);
	
	//-----Items-----//
	public static final RegistrySupplier<SpaceSuitItem> WHITE_SPACE_HELMET = ITEMS.register("white_space_helmet", () -> new SpaceSuitItem(DyeColor.WHITE, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> WHITE_SPACE_SUIT = ITEMS.register("white_space_suit", () -> new SpaceSuitItem(DyeColor.WHITE, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> ORANGE_SPACE_HELMET = ITEMS.register("orange_space_helmet", () -> new SpaceSuitItem(DyeColor.ORANGE, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> ORANGE_SPACE_SUIT = ITEMS.register("orange_space_suit", () -> new SpaceSuitItem(DyeColor.ORANGE, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> MAGENTA_SPACE_HELMET = ITEMS.register("magenta_space_helmet", () -> new SpaceSuitItem(DyeColor.MAGENTA, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> MAGENTA_SPACE_SUIT = ITEMS.register("magenta_space_suit", () -> new SpaceSuitItem(DyeColor.MAGENTA, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> LIGHT_BLUE_SPACE_HELMET = ITEMS.register("light_blue_space_helmet", () -> new SpaceSuitItem(DyeColor.LIGHT_BLUE, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> LIGHT_BLUE_SPACE_SUIT = ITEMS.register("light_blue_space_suit", () -> new SpaceSuitItem(DyeColor.LIGHT_BLUE, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> YELLOW_SPACE_HELMET = ITEMS.register("yellow_space_helmet", () -> new SpaceSuitItem(DyeColor.YELLOW, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> YELLOW_SPACE_SUIT = ITEMS.register("yellow_space_suit", () -> new SpaceSuitItem(DyeColor.YELLOW, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> LIME_SPACE_HELMET = ITEMS.register("lime_space_helmet", () -> new SpaceSuitItem(DyeColor.LIME, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> LIME_SPACE_SUIT = ITEMS.register("lime_space_suit", () -> new SpaceSuitItem(DyeColor.LIME, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> PINK_SPACE_HELMET = ITEMS.register("pink_space_helmet", () -> new SpaceSuitItem(DyeColor.PINK, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> PINK_SPACE_SUIT = ITEMS.register("pink_space_suit", () -> new SpaceSuitItem(DyeColor.PINK, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> GRAY_SPACE_HELMET = ITEMS.register("gray_space_helmet", () -> new SpaceSuitItem(DyeColor.GRAY, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> GRAY_SPACE_SUIT = ITEMS.register("gray_space_suit", () -> new SpaceSuitItem(DyeColor.GRAY, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> LIGHT_GRAY_SPACE_HELMET = ITEMS.register("light_gray_space_helmet", () -> new SpaceSuitItem(DyeColor.LIGHT_GRAY, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> LIGHT_GRAY_SPACE_SUIT = ITEMS.register("light_gray_space_suit", () -> new SpaceSuitItem(DyeColor.LIGHT_GRAY, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> CYAN_SPACE_HELMET = ITEMS.register("cyan_space_helmet", () -> new SpaceSuitItem(DyeColor.CYAN, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> CYAN_SPACE_SUIT = ITEMS.register("cyan_space_suit", () -> new SpaceSuitItem(DyeColor.CYAN, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> PURPLE_SPACE_HELMET = ITEMS.register("purple_space_helmet", () -> new SpaceSuitItem(DyeColor.PURPLE, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> PURPLE_SPACE_SUIT = ITEMS.register("purple_space_suit", () -> new SpaceSuitItem(DyeColor.PURPLE, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> BLUE_SPACE_HELMET = ITEMS.register("blue_space_helmet", () -> new SpaceSuitItem(DyeColor.BLUE, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> BLUE_SPACE_SUIT = ITEMS.register("blue_space_suit", () -> new SpaceSuitItem(DyeColor.BLUE, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> BROWN_SPACE_HELMET = ITEMS.register("brown_space_helmet", () -> new SpaceSuitItem(DyeColor.BROWN, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> BROWN_SPACE_SUIT = ITEMS.register("brown_space_suit", () -> new SpaceSuitItem(DyeColor.BROWN, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> GREEN_SPACE_HELMET = ITEMS.register("green_space_helmet", () -> new SpaceSuitItem(DyeColor.GREEN, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> GREEN_SPACE_SUIT = ITEMS.register("green_space_suit", () -> new SpaceSuitItem(DyeColor.GREEN, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> RED_SPACE_HELMET = ITEMS.register("red_space_helmet", () -> new SpaceSuitItem(DyeColor.RED, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> RED_SPACE_SUIT = ITEMS.register("red_space_suit", () -> new SpaceSuitItem(DyeColor.RED, SpaceSuitItem.SuitPiece.SUIT));

	public static final RegistrySupplier<SpaceSuitItem> BLACK_SPACE_HELMET = ITEMS.register("black_space_helmet", () -> new SpaceSuitItem(DyeColor.BLACK, SpaceSuitItem.SuitPiece.HELMET));
	public static final RegistrySupplier<SpaceSuitItem> BLACK_SPACE_SUIT = ITEMS.register("black_space_suit", () -> new SpaceSuitItem(DyeColor.BLACK, SpaceSuitItem.SuitPiece.SUIT));
}
