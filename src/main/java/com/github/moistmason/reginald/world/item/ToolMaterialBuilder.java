package com.github.moistmason.reginald.world.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

public class ToolMaterialBuilder {
    private TagKey<Block> incorrectBlocksForDrops;
    private int durability;
    private float speed;
    private float attackDamageBonus;
    private int enchantmentValue;
    private TagKey<Item> repairItems;

    public ToolMaterialBuilder incorrectBlocksForDrops(final TagKey<Block> incorrectBlocksForDrops) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        return this;
    }

    public ToolMaterialBuilder durability(final int durability) {
        this.durability = durability;
        return this;
    }

    public ToolMaterialBuilder speed(final float speed) {
        this.speed = speed;
        return this;
    }

    public ToolMaterialBuilder attackDamageBonus(final int attackDamageBonus) {
        this.attackDamageBonus = attackDamageBonus;
        return this;
    }

    public ToolMaterialBuilder enchantmentValue(final int enchantmentValue) {
        this.enchantmentValue = enchantmentValue;
        return this;
    }

    public ToolMaterialBuilder repairItems(final TagKey<Item> repairItems) {
        this.repairItems = repairItems;
        return this;
    }

    public ToolMaterial build() {
        return new ToolMaterial(incorrectBlocksForDrops, durability, speed, attackDamageBonus, enchantmentValue, repairItems);
    }
}
