package dev.cammiescorner.starfinder.common.entities.tech;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class AbstractFPVEntity extends Entity implements OwnableEntity {
	public AbstractFPVEntity(EntityType<?> variant, Level level) {
		super(variant, level);
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

	@Override
	public @Nullable UUID getOwnerUUID() {
		return null;
	}
}
