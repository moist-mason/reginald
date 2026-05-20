package com.github.moistmason.reginald.world.item;

import com.github.moistmason.reginald.util.annotation.VersionDifferent;
import com.github.moistmason.reginald.util.annotation.VersionUnique;
import net.minecraft.core.Holder;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;
import java.util.function.Supplier;

public final class ItemSuppliers {
    public static Supplier<Item> createItem() {
        return createItem(Item::new, new Properties());
    }

    public static Supplier<Item> createItem(final Properties properties) {
        return createItem(Item::new, properties);
    }

    public static <T extends Item> Supplier<T> createItem(final Function<Properties, T> factory, final Properties properties) {
        return () -> factory.apply(properties);
    }

    public static <T extends Item> Supplier<T> createItem(
            final Function<Properties, T> factory,
            final Function<Properties, Properties> propertiesFactory,
            final Properties properties) {
        return () -> factory.apply(propertiesFactory.apply(properties));
    }

    @VersionDifferent
    public static <T extends Item> Supplier<T> createArmorItem(
            final Function<Properties, T> factory,
            final Holder<ArmorMaterial> material,
            final ArmorType type,
            final Properties properties
    ) {
        return () -> factory.apply(properties.humanoidArmor(material.value(), type));
    }

    public static <T extends Item> Supplier<T> createFoodItem(
            final Function<Properties, T> factory,
            final Properties properties,
            final FoodProperties foodProperties
    ) {
        return createItem(factory, properties.food(foodProperties));
    }

    @VersionUnique("26.1.x")
    public static <T extends Item> Supplier<T> createSwordItem(
            final Function<Properties, T> factory,
            final Properties properties,
            final ToolMaterial toolMaterial,
            final float attackDamageBaseline,
            final float attackSpeedBaseline
    ) {
        return createItem(factory, properties.sword(toolMaterial, attackDamageBaseline, attackSpeedBaseline));
    }

    @VersionUnique("26.1.x")
    public static <T extends Item> Supplier<T> createPickaxeItem(
            final Function<Properties, T> factory,
            final Properties properties,
            final ToolMaterial toolMaterial,
            final float attackDamageBaseline,
            final float attackSpeedBaseline
    ) {
        return createItem(factory, properties.pickaxe(toolMaterial, attackDamageBaseline, attackSpeedBaseline));
    }

    @VersionUnique("26.1.x")
    public static <T extends Item> Supplier<T> createShovelItem(
            final Function<Properties, T> factory,
            final Properties properties,
            final ToolMaterial toolMaterial,
            final float attackDamageBaseline,
            final float attackSpeedBaseline
    ) {
        return createItem(factory, properties.shovel(toolMaterial, attackDamageBaseline, attackSpeedBaseline));
    }

    @VersionUnique("26.1.x")
    public static <T extends Item> Supplier<T> createAxeItem(
            final Function<Properties, T> factory,
            final Properties properties,
            final ToolMaterial toolMaterial,
            final float attackDamageBaseline,
            final float attackSpeedBaseline
    ) {
        return createItem(factory, properties.axe(toolMaterial, attackDamageBaseline, attackSpeedBaseline));
    }

    @VersionUnique("26.1.x")
    public static <T extends Item> Supplier<T> createHoeItem( // I guess bro
            final Function<Properties, T> factory,
            final Properties properties,
            final ToolMaterial toolMaterial,
            final float attackDamageBaseline,
            final float attackSpeedBaseline
    ) {
        return createItem(factory, properties.hoe(toolMaterial, attackDamageBaseline, attackSpeedBaseline));
    }
}
