package dev.cammiescorner.starfinder;

import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import dev.cammiescorner.starfinder.common.registry.SFEntities;
import dev.cammiescorner.starfinder.common.registry.SFItems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Starfinder implements ModInitializer {
	public static final String MOD_ID = "starfinder";
	public static final Logger LOGGER = LoggerFactory.getLogger("Starfinder");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

		SFItems.register();
		SFEntities.register();
	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}

	public static MutableText translate(@Nullable String prefix, String... value) {
		String translationKey = Starfinder.MOD_ID + "." + String.join(".", value);
		return Text.translatable(prefix != null ? (prefix + "." + translationKey) : translationKey);
	}

	public static ItemStack getSpaceHelmet(LivingEntity entity) {
		Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);

		if(optional.isPresent()) {
			TrinketComponent component = optional.get();

			for(Pair<SlotReference, ItemStack> pair : component.getEquipped(stack -> stack.getItem() instanceof SpaceSuitItem spaceSuit && spaceSuit.getType() == SpaceSuitItem.SuitPiece.HELMET))
				if(pair.getLeft().inventory().getSlotType().getName().equals("space_helmet"))
					return pair.getRight();
		}

		return ItemStack.EMPTY;
	}

	public static ItemStack getSpaceSuit(LivingEntity entity) {
		Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);

		if(optional.isPresent()) {
			TrinketComponent component = optional.get();

			for(Pair<SlotReference, ItemStack> pair : component.getEquipped(stack -> stack.getItem() instanceof SpaceSuitItem spaceSuit && spaceSuit.getType() == SpaceSuitItem.SuitPiece.SUIT))
				if(pair.getLeft().inventory().getSlotType().getName().equals("space_suit"))
					return pair.getRight();
		}

		return ItemStack.EMPTY;
	}
}
