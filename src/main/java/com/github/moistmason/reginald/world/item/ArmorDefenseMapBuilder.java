package com.github.moistmason.reginald.world.item;

import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public class ArmorDefenseMapBuilder {
    private int helmet;
    private int chestplate;
    private int leggings;
    private int boots;
    private int body;

    public ArmorDefenseMapBuilder helmet(int helmet) {
        this.helmet = helmet;
        return this;
    }

    public ArmorDefenseMapBuilder chestplate(int chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    public ArmorDefenseMapBuilder leggings(int leggings) {
        this.leggings = leggings;
        return this;
    }

    public ArmorDefenseMapBuilder boots(int boots) {
        this.boots = boots;
        return this;
    }

    public ArmorDefenseMapBuilder body(int body) {
        this.body = body;
        return this;
    }

    public EnumMap<ArmorType, Integer> build() {
        return Util.make(new EnumMap<>(ArmorType.class), attribute -> {
            attribute.put(ArmorType.HELMET, helmet);
            attribute.put(ArmorType.CHESTPLATE, chestplate);
            attribute.put(ArmorType.LEGGINGS, leggings);
            attribute.put(ArmorType.BOOTS, boots);
            attribute.put(ArmorType.BODY, body);
        });
    }
}
