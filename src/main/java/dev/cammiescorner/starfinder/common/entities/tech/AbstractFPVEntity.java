package dev.cammiescorner.starfinder.common.entities.tech;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.Ownable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractFPVEntity extends Entity implements Ownable {
	public AbstractFPVEntity(EntityType<?> variant, World world) {
		super(variant, world);
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

	@Nullable
	@Override
	public Entity getOwner() {
		return null;
	}
}
