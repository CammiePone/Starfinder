package dev.cammiescorner.starfinder.common.registries;

import dev.cammiescorner.starfinder.Starfinder;
import dev.cammiescorner.starfinder.common.data.TintedDataComponent;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;

public class StarfinderData {
	public static final RegistryHandler<DataComponentType<?>> DATA_COMPONENTS = RegistryHandler.create(Registries.DATA_COMPONENT_TYPE, Starfinder.MOD_ID);

	public static final RegistrySupplier<DataComponentType<TintedDataComponent>> IS_TINTED = DATA_COMPONENTS.register("is_tinted", () -> DataComponentType.<TintedDataComponent>builder().cacheEncoding().persistent(TintedDataComponent.CODEC).networkSynchronized(TintedDataComponent.STREAM_CODEC).build());
}
