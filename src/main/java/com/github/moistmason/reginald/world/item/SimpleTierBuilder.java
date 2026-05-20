package com.github.moistmason.reginald.world.item;

import com.github.moistmason.reginald.util.annotation.VersionDifferent;
import com.github.moistmason.reginald.util.annotation.VersionUnique;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.function.Supplier;

@VersionUnique("1.21.1")
public class SimpleTierBuilder {
    private TagKey<Block> incorrectBlocksForDrops;
    private int uses;
    private float speed;
    private float attackDamageBonus;
    private int enchantmentValue;
    private Supplier<Ingredient> repairIngredient;

    public SimpleTierBuilder incorrectBlocksForDrops(final TagKey<Block> incorrectBlocksForDrops) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        return this;
    }

    public SimpleTierBuilder uses(final int uses) {
        this.uses = uses;
        return this;
    }

    public SimpleTierBuilder speed(final float speed) {
        this.speed = speed;
        return this;
    }

    public SimpleTierBuilder attackDamageBonus(final float attackDamageBonus) {
        this.attackDamageBonus = attackDamageBonus;
        return this;
    }

    public SimpleTierBuilder enchantmentValue(final int enchantmentValue) {
        this.enchantmentValue = enchantmentValue;
        return this;
    }

    public SimpleTierBuilder repairIngredient(final Supplier<Ingredient> repairIngredient) {
        this.repairIngredient = repairIngredient;
        return this;
    }

    public SimpleTierBuilder repairIngredient(final ItemLike item) {
        this.repairIngredient = () -> Ingredient.of(item);
        return this;
    }

    public SimpleTierBuilder repairIngredient(final TagKey<Item> tag) {
        this.repairIngredient = () -> Ingredient.of(tag);
        return this;
    }

    public SimpleTier build() {
        return new SimpleTier(incorrectBlocksForDrops, uses, speed, attackDamageBonus, enchantmentValue, repairIngredient);
    }
}
