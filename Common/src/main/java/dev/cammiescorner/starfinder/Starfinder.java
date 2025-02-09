package dev.cammiescorner.starfinder;

import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import commonnetwork.api.Network;
import dev.cammiescorner.starfinder.common.networking.serverbound.ServerboundTintHelmetPacket;
import dev.cammiescorner.starfinder.common.registry.StarfinderData;
import dev.cammiescorner.starfinder.common.registry.StarfinderEntities;
import dev.cammiescorner.starfinder.common.registry.StarfinderItems;
import dev.upcraft.sparkweave.api.entrypoint.MainEntryPoint;
import dev.upcraft.sparkweave.api.platform.ModContainer;
import dev.upcraft.sparkweave.api.platform.services.RegistryService;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class Starfinder implements MainEntryPoint {
    public static final String MOD_ID = "starfinder";
    public static final Configurator CONFIGURATOR = new Configurator(MOD_ID);

    @Override
    public void onInitialize(ModContainer mod) {
        RegistryService registryService = RegistryService.get();

        StarfinderData.DATA_COMPONENTS.accept(registryService);
        StarfinderItems.ITEMS.accept(registryService);
        StarfinderEntities.ENTITY_TYPES.accept(registryService);

        Network.registerPacket(ServerboundTintHelmetPacket.TYPE, ServerboundTintHelmetPacket.class, ServerboundTintHelmetPacket.CODEC, ServerboundTintHelmetPacket::handle);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static MutableComponent translate(@Nullable String prefix, String... value) {
        String translationKey = Starfinder.MOD_ID + "." + String.join(".", value);
        return Component.translatable(prefix != null ? (prefix + "." + translationKey) : translationKey);
    }
}
