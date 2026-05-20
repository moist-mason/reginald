package com.github.moistmason.reginald.world.item;

import com.github.moistmason.reginald.util.ResourceProvider;
import com.github.moistmason.reginald.util.annotation.VersionDifferent;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.EnumMap;

@VersionDifferent // may be unique, not sure yet
public class ArmorMaterialBuilder {
    private final ResourceProvider resourceProvider;
    private ResourceKey<EquipmentAsset> assetId;

    /** Use {@link ArmorDefenseMapBuilder} for easy creation of this map. */
    private EnumMap<ArmorType, Integer> defense;

    private int durability;
    private int enchantmentValue;
    private float toughness;
    private float knockbackResistance;
    private TagKey<Item> repairIngredient;
    private Holder<SoundEvent> equipSound;

    public ArmorMaterialBuilder(final String id) {
        this.resourceProvider = new ResourceProvider(id);
    }

    public ArmorMaterialBuilder durability(final int durability) {
        this.durability = durability;
        return this;
    }

    public ArmorMaterialBuilder assetId(final String id) {
        final Identifier identifier = resourceProvider.get(id);
        this.assetId = ResourceKey.create(EquipmentAssets.ROOT_ID, identifier);
        return this;
    }

    public ArmorMaterialBuilder defense(final EnumMap<ArmorType, Integer> defense) {
        this.defense = defense;
        return this;
    }

    public ArmorMaterialBuilder enchantmentValue(final int enchantmentValue) {
        this.enchantmentValue = enchantmentValue;
        return this;
    }

    public ArmorMaterialBuilder toughness(final float toughness) {
        this.toughness = toughness;
        return this;
    }

    public ArmorMaterialBuilder knockbackResistance(float knockbackResistance) {
        this.knockbackResistance = knockbackResistance;
        return this;
    }

    public ArmorMaterialBuilder repairIngredient(final TagKey<Item> repairIngredient) {
        this.repairIngredient = repairIngredient;
        return this;
    }

    public ArmorMaterialBuilder equipSound(final Holder<SoundEvent> equipSound) {
        this.equipSound = equipSound;
        return this;
    }

    public <T extends SoundEvent> ArmorMaterialBuilder equipSound(final DeferredHolder<SoundEvent, T> equipSound) {
        this.equipSound = equipSound.getDelegate();
        return this;
    }

    public ArmorMaterial build() {
        return new ArmorMaterial(durability, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, assetId);
    }
}
