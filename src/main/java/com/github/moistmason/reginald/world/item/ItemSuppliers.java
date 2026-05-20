package com.github.moistmason.reginald.world.item;

import com.github.moistmason.reginald.util.function.QuadFunction;
import com.github.moistmason.reginald.util.function.TriFunction;
import com.github.moistmason.reginald.util.annotation.VersionDifferent;
import com.github.moistmason.reginald.util.annotation.VersionUnique;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.BiFunction;
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

    @VersionDifferent
    public static <T extends ArmorItem> Supplier<T> createArmorItem(
            final TriFunction<Holder<ArmorMaterial>, ArmorItem.Type, Properties, T> factory,
            final Holder<ArmorMaterial> material,
            final ArmorItem.Type type,
            final Properties properties,
            final int maxDamage
    ) {
        return () -> factory.apply(material, type, properties.durability(maxDamage));
    }

    public static <T extends Item> Supplier<T> createFoodItem(
            final Function<Properties, T> factory,
            final Properties properties,
            final FoodProperties foodProperties
    ) {
        return createItem(factory, properties.food(foodProperties));
    }

    @VersionDifferent
    public static <T extends TieredItem> Supplier<T> createTieredItem(
            final BiFunction<Tier, Properties, T> factory,
            final Tier tier,
            final ItemAttributeModifiers attributes,
            final Properties properties
    ) {
        return () -> factory.apply(tier, properties.attributes(attributes));
    }

    @VersionUnique("1.21.1")
    public static <T extends SpawnEggItem> Supplier<T> createSpawnEggItem(
            final QuadFunction<EntityType<? extends Mob>, Integer, Integer, Properties, T> factory,
            final EntityType<? extends Mob> mob,
            final int backgroundColor,
            final int highlightColor,
            final Properties properties
    ) {
        return () -> factory.apply(mob, backgroundColor, highlightColor, properties);
    }
}
