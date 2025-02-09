package dev.cammiescorner.starfinder.mixin.client;

import dev.cammiescorner.starfinder.client.renderer.trinkets.SpaceSuitFeatureRenderer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> implements RenderLayerParent<T, M> {
	@Shadow protected abstract boolean addLayer(RenderLayer<T, M> layer);

	protected LivingEntityRendererMixin(EntityRendererProvider.Context context) { super(context); }

	@Inject(method = "<init>", at = @At("TAIL"))
	public void init(EntityRendererProvider.Context context, EntityModel<T> model, float shadowRadius, CallbackInfo info) {
		if(model instanceof HumanoidModel<?>)
			addLayer(new SpaceSuitFeatureRenderer<>(this));
	}
}
