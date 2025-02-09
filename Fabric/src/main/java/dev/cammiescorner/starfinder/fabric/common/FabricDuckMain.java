package dev.cammiescorner.starfinder.fabric.common;

import dev.cammiescorner.starfinder.common.DuckMain;
import dev.cammiescorner.starfinder.common.items.SpaceSuitItem;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class FabricDuckMain implements DuckMain {
	@Override
	public ItemStack getSpaceHelmet(LivingEntity entity) {
		Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);

		if(optional.isPresent()) {
			TrinketComponent component = optional.get();

			for(Tuple<SlotReference, ItemStack> pair : component.getEquipped(stack -> stack.getItem() instanceof SpaceSuitItem spaceSuit && spaceSuit.getType() == SpaceSuitItem.SuitPiece.HELMET))
				if(pair.getA().inventory().getSlotType().getName().equals("space_helmet"))
					return pair.getB();
		}

		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack getSpaceSuit(LivingEntity entity) {
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
