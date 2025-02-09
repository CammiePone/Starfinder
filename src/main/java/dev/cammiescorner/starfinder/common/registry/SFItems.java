package dev.cammiescorner.starfinder.common.registry;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;

public class SFItems {
	//-----Item Map-----//
	public static final LinkedHashMap<Item, Identifier> ITEMS = new LinkedHashMap<>();

	//-----Items-----//
	public static final Item WHITE_SPACE_HELMET = create("white_space_helmet", new SpaceSuitItem(DyeColor.WHITE, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item WHITE_SPACE_SUIT = create("white_space_suit", new SpaceSuitItem(DyeColor.WHITE, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item ORANGE_SPACE_HELMET = create("orange_space_helmet", new SpaceSuitItem(DyeColor.ORANGE, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item ORANGE_SPACE_SUIT = create("orange_space_suit", new SpaceSuitItem(DyeColor.ORANGE, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item MAGENTA_SPACE_HELMET = create("magenta_space_helmet", new SpaceSuitItem(DyeColor.MAGENTA, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item MAGENTA_SPACE_SUIT = create("magenta_space_suit", new SpaceSuitItem(DyeColor.MAGENTA, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item LIGHT_BLUE_SPACE_HELMET = create("light_blue_space_helmet", new SpaceSuitItem(DyeColor.LIGHT_BLUE, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item LIGHT_BLUE_SPACE_SUIT = create("light_blue_space_suit", new SpaceSuitItem(DyeColor.LIGHT_BLUE, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item YELLOW_SPACE_HELMET = create("yellow_space_helmet", new SpaceSuitItem(DyeColor.YELLOW, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item YELLOW_SPACE_SUIT = create("yellow_space_suit", new SpaceSuitItem(DyeColor.YELLOW, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item LIME_SPACE_HELMET = create("lime_space_helmet", new SpaceSuitItem(DyeColor.LIME, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item LIME_SPACE_SUIT = create("lime_space_suit", new SpaceSuitItem(DyeColor.LIME, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item PINK_SPACE_HELMET = create("pink_space_helmet", new SpaceSuitItem(DyeColor.PINK, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item PINK_SPACE_SUIT = create("pink_space_suit", new SpaceSuitItem(DyeColor.PINK, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item GRAY_SPACE_HELMET = create("gray_space_helmet", new SpaceSuitItem(DyeColor.GRAY, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item GRAY_SPACE_SUIT = create("gray_space_suit", new SpaceSuitItem(DyeColor.GRAY, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item LIGHT_GRAY_SPACE_HELMET = create("light_gray_space_helmet", new SpaceSuitItem(DyeColor.LIGHT_GRAY, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item LIGHT_GRAY_SPACE_SUIT = create("light_gray_space_suit", new SpaceSuitItem(DyeColor.LIGHT_GRAY, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item CYAN_SPACE_HELMET = create("cyan_space_helmet", new SpaceSuitItem(DyeColor.CYAN, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item CYAN_SPACE_SUIT = create("cyan_space_suit", new SpaceSuitItem(DyeColor.CYAN, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item PURPLE_SPACE_HELMET = create("purple_space_helmet", new SpaceSuitItem(DyeColor.PURPLE, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item PURPLE_SPACE_SUIT = create("purple_space_suit", new SpaceSuitItem(DyeColor.PURPLE, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item BLUE_SPACE_HELMET = create("blue_space_helmet", new SpaceSuitItem(DyeColor.BLUE, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item BLUE_SPACE_SUIT = create("blue_space_suit", new SpaceSuitItem(DyeColor.BLUE, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item BROWN_SPACE_HELMET = create("brown_space_helmet", new SpaceSuitItem(DyeColor.BROWN, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item BROWN_SPACE_SUIT = create("brown_space_suit", new SpaceSuitItem(DyeColor.BROWN, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item GREEN_SPACE_HELMET = create("green_space_helmet", new SpaceSuitItem(DyeColor.GREEN, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item GREEN_SPACE_SUIT = create("green_space_suit", new SpaceSuitItem(DyeColor.GREEN, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item RED_SPACE_HELMET = create("red_space_helmet", new SpaceSuitItem(DyeColor.RED, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item RED_SPACE_SUIT = create("red_space_suit", new SpaceSuitItem(DyeColor.RED, SpaceSuitItem.SuitPiece.SUIT));

	public static final Item BLACK_SPACE_HELMET = create("black_space_helmet", new SpaceSuitItem(DyeColor.BLACK, SpaceSuitItem.SuitPiece.HELMET));
	public static final Item BLACK_SPACE_SUIT = create("black_space_suit", new SpaceSuitItem(DyeColor.BLACK, SpaceSuitItem.SuitPiece.SUIT));

	//-----Registry-----//
	public static void register() {
		FabricItemGroup.builder(Starfinder.id("general")).icon(() -> new ItemStack(WHITE_SPACE_HELMET)).entries((displayParameters, entries) -> {
			entries.addItem(WHITE_SPACE_HELMET);
			entries.addItem(WHITE_SPACE_SUIT);

			entries.addItem(ORANGE_SPACE_HELMET);
			entries.addItem(ORANGE_SPACE_SUIT);

			entries.addItem(MAGENTA_SPACE_HELMET);
			entries.addItem(MAGENTA_SPACE_SUIT);

			entries.addItem(LIGHT_BLUE_SPACE_HELMET);
			entries.addItem(LIGHT_BLUE_SPACE_SUIT);

			entries.addItem(YELLOW_SPACE_HELMET);
			entries.addItem(YELLOW_SPACE_SUIT);

			entries.addItem(LIME_SPACE_HELMET);
			entries.addItem(LIME_SPACE_SUIT);

			entries.addItem(PINK_SPACE_HELMET);
			entries.addItem(PINK_SPACE_SUIT);

			entries.addItem(GRAY_SPACE_HELMET);
			entries.addItem(GRAY_SPACE_SUIT);

			entries.addItem(LIGHT_GRAY_SPACE_HELMET);
			entries.addItem(LIGHT_GRAY_SPACE_SUIT);

			entries.addItem(CYAN_SPACE_HELMET);
			entries.addItem(CYAN_SPACE_SUIT);

			entries.addItem(PURPLE_SPACE_HELMET);
			entries.addItem(PURPLE_SPACE_SUIT);

			entries.addItem(BLUE_SPACE_HELMET);
			entries.addItem(BLUE_SPACE_SUIT);

			entries.addItem(BROWN_SPACE_HELMET);
			entries.addItem(BROWN_SPACE_SUIT);

			entries.addItem(GREEN_SPACE_HELMET);
			entries.addItem(GREEN_SPACE_SUIT);

			entries.addItem(RED_SPACE_HELMET);
			entries.addItem(RED_SPACE_SUIT);

			entries.addItem(BLACK_SPACE_HELMET);
			entries.addItem(BLACK_SPACE_SUIT);
		}).build();

		ITEMS.keySet().forEach(item -> Registry.register(Registries.ITEM, ITEMS.get(item), item));
	}

	private static <T extends Item> T create(String name, T item) {
		ITEMS.put(item, Starfinder.id(name));
		return item;
	}
}
