package com.github.moistmason.reginald.world.item;

import com.github.moistmason.reginald.util.annotation.VersionUnique;
import net.minecraft.Util;
import net.minecraft.world.item.ArmorItem.Type;

import java.util.EnumMap;

@VersionUnique("1.21.1")
public class ArmorProtectionMapBuilder {
    private int helmet;
    private int chestplate;
    private int leggings;
    private int boots;
    private int body;

    public ArmorProtectionMapBuilder helmet(final int helmet) {
        this.helmet = helmet;
        return this;
    }

    public ArmorProtectionMapBuilder chestplate(final int chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    public ArmorProtectionMapBuilder leggings(final int leggings) {
        this.leggings = leggings;
        return this;
    }

    public ArmorProtectionMapBuilder boots(final int boots) {
        this.boots = boots;
        return this;
    }

    public ArmorProtectionMapBuilder body(final int body) {
        this.body = body;
        return this;
    }

    public EnumMap<Type, Integer> build() {
        return Util.make(new EnumMap<>(Type.class), map -> {
            map.put(Type.HELMET, helmet);
            map.put(Type.CHESTPLATE, chestplate);
            map.put(Type.LEGGINGS, leggings);
            map.put(Type.BOOTS, boots);
            map.put(Type.BODY, body);
        });
    }
}
