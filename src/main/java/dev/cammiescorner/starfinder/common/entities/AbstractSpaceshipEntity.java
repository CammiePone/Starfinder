package dev.cammiescorner.starfinder.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public abstract class AbstractSpaceshipEntity extends Entity {
	public AbstractSpaceshipEntity(EntityType<?> type, World world) {
		super(type, world);
	}

	@Override
	public void tick() {
		if(!hasNoGravity())
			setVelocity(getVelocity().add(0.0, -0.04, 0.0));

		move(MovementType.SELF, getVelocity());
	}

	@Override
	protected void initDataTracker() {

	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {

	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {

	}
}
