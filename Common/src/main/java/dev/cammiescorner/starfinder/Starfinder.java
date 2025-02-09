package dev.cammiescorner.starfinder;

import dev.upcraft.sparkweave.api.entrypoint.MainEntryPoint;
import dev.upcraft.sparkweave.api.platform.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class Starfinder implements MainEntryPoint {
    public static final String MOD_ID = "starfinder";

    @Override
    public void onInitialize(ModContainer mod) {

    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static MutableComponent translate(@Nullable String prefix, String... value) {
        String translationKey = Starfinder.MOD_ID + "." + String.join(".", value);
        return Component.translatable(prefix != null ? (prefix + "." + translationKey) : translationKey);
    }
}
