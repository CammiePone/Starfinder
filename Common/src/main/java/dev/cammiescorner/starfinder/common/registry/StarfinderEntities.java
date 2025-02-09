package dev.cammiescorner.starfinder.common.registry;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.entities.SmallSpaceshipEntity;
import dev.cammiescorner.starfinder.common.entities.tech.FPVDroneEntity;
import dev.cammiescorner.starfinder.common.entities.tech.FPVRoverEntity;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class StarfinderEntities {
	public static final RegistryHandler<EntityType<?>> ENTITY_TYPES = RegistryHandler.create(Registries.ENTITY_TYPE, Starfinder.MOD_ID);

	//-----Entities-----//
	public static final RegistrySupplier<EntityType<SmallSpaceshipEntity>> SMALL_SPACESHIP = ENTITY_TYPES.register("small_spaceship", () -> EntityType.Builder.of(SmallSpaceshipEntity::new, MobCategory.MISC).sized(6f, 4f).build("small_spaceship"));
	public static final RegistrySupplier<EntityType<FPVDroneEntity>> FPV_DRONE = ENTITY_TYPES.register("fpv_drone", () -> EntityType.Builder.of(FPVDroneEntity::new, MobCategory.MISC).sized(0.8f, 0.65f).build("fpv_drone"));
	public static final RegistrySupplier<EntityType<FPVRoverEntity>> FPV_ROVER = ENTITY_TYPES.register("fpv_rover", () -> EntityType.Builder.of(FPVRoverEntity::new, MobCategory.MISC).sized(2.5f, 1.75f).build("fpv_rover"));
}
