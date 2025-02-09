package dev.cammiescorner.starfinder.fabric.entrypoints;

import dev.cammiescorner.starfinder.fabric.common.items.SpaceSuitItem;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class FabricMain implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Starfinder");

	@Override
	public void onInitialize() {
	}

	public static ItemStack getSpaceHelmet(LivingEntity entity) {
		Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);

		if(optional.isPresent()) {
			TrinketComponent component = optional.get();

			for(Tuple<SlotReference, ItemStack> pair : component.getEquipped(stack -> stack.getItem() instanceof SpaceSuitItem spaceSuit && spaceSuit.getType() == SpaceSuitItem.SuitPiece.HELMET))
				if(pair.getA().inventory().getSlotType().getName().equals("space_helmet"))
					return pair.getB();
		}

		return ItemStack.EMPTY;
	}

	public static ItemStack getSpaceSuit(LivingEntity entity) {
		Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);

		if(optional.isPresent()) {
			TrinketComponent component = optional.get();

			for(Tuple<SlotReference, ItemStack> pair : component.getEquipped(stack -> stack.getItem() instanceof SpaceSuitItem spaceSuit && spaceSuit.getType() == SpaceSuitItem.SuitPiece.SUIT))
				if(pair.getA().inventory().getSlotType().getName().equals("space_suit"))
					return pair.getB();
		}

		return ItemStack.EMPTY;
	}
}
