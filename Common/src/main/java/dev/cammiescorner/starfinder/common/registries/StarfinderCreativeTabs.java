package dev.cammiescorner.starfinder.common.registries;

import dev.cammiescorner.starfinder.Starfinder;
import dev.upcraft.sparkweave.api.item.CreativeTabHelper;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class StarfinderCreativeTabs {
	public static final RegistryHandler<CreativeModeTab> CREATIVE_TABS = RegistryHandler.create(Registries.CREATIVE_MODE_TAB, Starfinder.MOD_ID);

	public static final RegistrySupplier<CreativeModeTab> STARFINDER_SPACE_SUIT_TAB = CREATIVE_TABS.register("space_suit_tab", () -> CreativeTabHelper.newBuilder(Starfinder.id("space_suit_tab")).icon(() -> new ItemStack(StarfinderItems.WHITE_SPACE_HELMET.get())).displayItems((parameters, output) -> CreativeTabHelper.addRegistryEntries(parameters, output, StarfinderItems.ITEMS)).build());
}
