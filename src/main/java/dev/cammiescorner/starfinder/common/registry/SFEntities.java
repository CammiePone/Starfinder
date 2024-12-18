package dev.cammiescorner.starfinder.common.registry;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.entities.SmallSpaceshipEntity;
import dev.cammiescorner.starfinder.common.entities.tech.FPVDroneEntity;
import dev.cammiescorner.starfinder.common.entities.tech.FPVRoverEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

import java.util.LinkedHashMap;

public class SFEntities {
	//-----Entity Map-----//
	public static final LinkedHashMap<EntityType<?>, Identifier> ENTITIES = new LinkedHashMap<>();

	//-----Entities-----//
	public static final EntityType<SmallSpaceshipEntity> SMALL_SPACESHIP = create("small_spaceship", QuiltEntityTypeBuilder.create().entityFactory(SmallSpaceshipEntity::new).setDimensions(EntityDimensions.fixed(6F, 4F)).build());
	public static final EntityType<FPVDroneEntity> FPV_DRONE = create("fpv_drone", QuiltEntityTypeBuilder.create().entityFactory(FPVDroneEntity::new).setDimensions(EntityDimensions.fixed(0.8F, 0.65F)).build());
	public static final EntityType<FPVRoverEntity> FPV_ROVER = create("fpv_rover", QuiltEntityTypeBuilder.create().entityFactory(FPVRoverEntity::new).setDimensions(EntityDimensions.fixed(2.5F, 1.75F)).build());

	//-----Registry-----//
	public static void register() {
		ENTITIES.keySet().forEach(entityType -> Registry.register(Registries.ENTITY_TYPE, ENTITIES.get(entityType), entityType));
	}

	private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
		ENTITIES.put(type, Starfinder.id(name));
		return type;
	}
}
