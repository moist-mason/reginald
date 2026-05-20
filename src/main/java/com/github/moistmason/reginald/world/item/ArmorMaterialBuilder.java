package com.github.moistmason.reginald.world.item;

import com.github.moistmason.reginald.util.ResourceProvider;
import com.github.moistmason.reginald.util.annotation.VersionDifferent;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

@VersionDifferent // may be unique, not sure yet
public class ArmorMaterialBuilder {
    private final ResourceProvider resourceProvider;
    private ResourceLocation location;

    /** Use {@link ArmorProtectionMapBuilder} for easy creation of this map. */
    private EnumMap<Type, Integer> protection;

    private int enchantability;
    private float toughness;
    private float knockbackResistance;
    private Supplier<Ingredient> ingredient;
    private Holder<SoundEvent> sound;

    public ArmorMaterialBuilder(final String id) {
        this.resourceProvider = new ResourceProvider(id);
    }

    public ArmorMaterialBuilder location(final String id) {
        this.location = resourceProvider.get(id);
        return this;
    }

    public ArmorMaterialBuilder protection(EnumMap<Type, Integer> protection) {
        this.protection = protection;
        return this;
    }

    public ArmorMaterialBuilder protection(int enchantability) {
        this.enchantability = enchantability;
        return this;
    }

    public ArmorMaterialBuilder toughness(float toughness) {
        this.toughness = toughness;
        return this;
    }

    public ArmorMaterialBuilder knockbackResistance(float knockbackResistance) {
        this.knockbackResistance = knockbackResistance;
        return this;
    }

    public ArmorMaterialBuilder ingredient(final Ingredient ingredient) {
        return ingredient(() -> ingredient);
    }

    public ArmorMaterialBuilder ingredient(final ItemLike item) {
        return ingredient(() -> Ingredient.of(item));
    }

    public ArmorMaterialBuilder ingredient(final TagKey<Item> tag) {
        return ingredient(() -> Ingredient.of(tag));
    }

    public ArmorMaterialBuilder ingredient(final Supplier<Ingredient> ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public ArmorMaterialBuilder sound(final Holder<SoundEvent> sound) {
        this.sound = sound;
        return this;
    }

    public <T extends SoundEvent> ArmorMaterialBuilder sound(final DeferredHolder<SoundEvent, T> sound) {
        this.sound = sound.getDelegate();
        return this;
    }

    public Holder<ArmorMaterial> build() {
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(protection, enchantability, sound, ingredient, layers, toughness, knockbackResistance));
    }
}
