package com.github.moistmason.reginald.world;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public final class BlockSuppliers {
    public static <T extends Block> Properties propertiesOf(final T base) {
        return Properties.ofFullCopy(base);
    }

    public static <T extends Block> Properties propertiesOf(final DeferredBlock<T> base) {
        return Properties.ofFullCopy(base.get());
    }

    public static Supplier<Block> createBlock(final Block base) {
        return createBlock(Block::new, base);
    }

    public static Supplier<Block> createBlock(final Properties properties) {
        return createBlock(Block::new, properties);
    }

    public static <T extends Block> Supplier<T> createBlock(final Function<Properties, T> factory, final Block base) {
        return createBlock(factory, propertiesOf(base));
    }

    public static <T extends Block> Supplier<T> createBlock(final Function<Properties, T> factory, final DeferredBlock<? extends Block> base) {
        return createBlock(factory, propertiesOf(base));
    }

    public static <T extends Block> Supplier<T> createBlock(final Function<Properties, T> factory, final Properties properties) {
        return () -> factory.apply(properties);
    }

    public static <T extends DropExperienceBlock> Supplier<T> createExperienceBlock(
            final BiFunction<IntProvider, Properties, T> factory,
            final int min,
            final int max,
            final Block base
    ) {
        return createExperienceBlock(factory, min, max, propertiesOf(base));
    }

    public static <T extends DropExperienceBlock> Supplier<T> createExperienceBlock(
            final BiFunction<IntProvider, Properties, T> factory,
            final int min,
            final int max,
            final DeferredBlock<? extends Block> base
    ) {
        return createExperienceBlock(factory, min, max, propertiesOf(base));
    }

    public static <T extends DropExperienceBlock> Supplier<T> createExperienceBlock(
            final BiFunction<IntProvider, Properties, T> factory,
            final int min,
            final int max,
            final Properties properties
    ) {
        return () -> factory.apply(UniformInt.of(min, max), properties);
    }

    public static <T extends StairBlock> Supplier<T> createStairBlock(
            final BiFunction<BlockState, Properties, T> factory,
            final DeferredBlock<? extends Block> base
    ) {
        return createStairBlock(factory, base, propertiesOf(base));
    }

    public static <T extends StairBlock> Supplier<T> createStairBlock(
            final BiFunction<BlockState, Properties, T> factory,
            final DeferredBlock<? extends Block> base,
            final Properties properties
    ) {
        return () -> factory.apply(base.get().defaultBlockState(), properties);
    }
}
