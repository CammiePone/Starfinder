package dev.cammiescorner.starfinder.common;

import dev.upcraft.sparkweave.api.platform.Services;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class MainHelper {
	private static final DuckMain duck = Services.getService(DuckMain.class);

	public static ItemStack getSpaceHelmet(LivingEntity entity) {
		return duck.getSpaceHelmet(entity);
	}

	public static ItemStack getSpaceSuit(LivingEntity entity) {
		return duck.getSpaceSuit(entity);
	}
}
