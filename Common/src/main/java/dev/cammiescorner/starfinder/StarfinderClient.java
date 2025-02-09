package dev.cammiescorner.starfinder;

import dev.cammiescorner.starfinder.client.models.entity.spaceship.SmallSpaceshipModel;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVDroneModel;
import dev.cammiescorner.starfinder.client.models.entity.tech.FPVRoverModel;
import dev.cammiescorner.starfinder.client.models.trinkets.SpaceSuitModel;
import dev.cammiescorner.starfinder.client.renderer.entity.spaceship.SmallSpaceshipEntityRenderer;
import dev.cammiescorner.starfinder.client.renderer.entity.tech.FPVDroneEntityRenderer;
import dev.cammiescorner.starfinder.client.renderer.entity.tech.FPVRoverEntityRenderer;
import dev.cammiescorner.starfinder.common.registry.StarfinderEntities;
import dev.upcraft.sparkweave.api.entrypoint.ClientEntryPoint;
import dev.upcraft.sparkweave.api.platform.ModContainer;

public class StarfinderClient implements ClientEntryPoint {
	@Override
	public void onInitializeClient(ModContainer mod) {
		EntityModelLayerRegistry.registerModelLayer(SpaceSuitModel.MODEL_LAYER, SpaceSuitModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SmallSpaceshipModel.MODEL_LAYER, SmallSpaceshipModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(FPVDroneModel.MODEL_LAYER, FPVDroneModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(FPVRoverModel.MODEL_LAYER, FPVRoverModel::getTexturedModelData);

		EntityRendererRegistry.register(StarfinderEntities.SMALL_SPACESHIP.get(), SmallSpaceshipEntityRenderer::new);
		EntityRendererRegistry.register(StarfinderEntities.FPV_DRONE.get(), FPVDroneEntityRenderer::new);
		EntityRendererRegistry.register(StarfinderEntities.FPV_ROVER.get(), FPVRoverEntityRenderer::new);
	}
}
