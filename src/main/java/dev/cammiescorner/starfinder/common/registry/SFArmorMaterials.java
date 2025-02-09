package dev.cammiescorner.starfinder.common.registry;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum SFArmorMaterials implements ArmorMaterial {
	SPACE_SUIT("space_suit", 0, Util.make(new EnumMap<ArmorItem.ArmorSlot, Integer>(ArmorItem.ArmorSlot.class), map -> {
		map.put(ArmorItem.ArmorSlot.BOOTS, 2);
		map.put(ArmorItem.ArmorSlot.LEGGINGS, 5);
		map.put(ArmorItem.ArmorSlot.CHESTPLATE, 7);
		map.put(ArmorItem.ArmorSlot.HELMET, 3);
	}), 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1F, 0.1F, () -> Ingredient.ofItems(Items.IRON_INGOT));

	private static final EnumMap<ArmorItem.ArmorSlot, Integer> BASE_DURABILITY_VALUES = Util.make(new EnumMap<ArmorItem.ArmorSlot, Integer>(ArmorItem.ArmorSlot.class), map -> {
		map.put(ArmorItem.ArmorSlot.BOOTS, 13);
		map.put(ArmorItem.ArmorSlot.LEGGINGS, 15);
		map.put(ArmorItem.ArmorSlot.CHESTPLATE, 16);
		map.put(ArmorItem.ArmorSlot.HELMET, 11);
	});
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.ArmorSlot, Integer> slotProtections;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Lazy<Ingredient> repairIngredientSupplier;

	SFArmorMaterials(
			String name,
			int durabilityMultiplier,
			EnumMap<ArmorItem.ArmorSlot, Integer> slotProtections,
			int enchantability,
			SoundEvent equipSound,
			float toughness,
			float knockbackResistance,
			Supplier<Ingredient> repairIngredientSupplier
	) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
	}

	@Override
	public int getDurability(ArmorItem.ArmorSlot slot) {
		return BASE_DURABILITY_VALUES.get(slot) * this.durabilityMultiplier;
	}

	@Override
	public int getProtection(ArmorItem.ArmorSlot slot) {
		return this.slotProtections.get(slot);
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredientSupplier.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
