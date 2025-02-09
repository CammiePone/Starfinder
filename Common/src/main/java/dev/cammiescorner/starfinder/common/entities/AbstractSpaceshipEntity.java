package dev.cammiescorner.starfinder.common.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;

public abstract class AbstractSpaceshipEntity extends Entity {
	public AbstractSpaceshipEntity(EntityType<?> type, Level level) {
		super(type, level);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {

	}

	@Override
	public void tick() {
		if(!isNoGravity())
			setDeltaMovement(getDeltaMovement().add(0.0, -0.04, 0.0));

		move(MoverType.SELF, getDeltaMovement());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {

	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {

	}
}
