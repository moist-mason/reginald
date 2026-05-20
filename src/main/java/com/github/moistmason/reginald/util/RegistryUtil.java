package com.github.moistmason.reginald.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class RegistryUtil {

    /** @return The given vanilla registry as a stream. */
    public static <T> Stream<T> toStream(final Registry<T> registry) {
        return registry.stream();
    }

    /** @return The given vanilla registry as a list. */
    public static <T> List<T> toList(final Registry<T> registry) {
        return toStream(registry).toList();
    }

    /** @return The given vanilla registry as a list, filtered based on the given predicate. */
    public static <T> List<T> toList(final Registry<T> registry, final Predicate<T> predicate) {
        return toStream(registry).filter(predicate).toList();
    }

    public static <T> Stream<T> toStream(final DeferredRegister<T> registry) {
        return registry.getEntries().stream().map(DeferredHolder::get);
    }

    /** @return The given mod registry as a list. */
    public static <T> List<T> toList(final DeferredRegister<T> registry) {
        return toStream(registry).toList();
    }

    /** @return The given mod registry as a list, filtered based on the given predicate. */
    public static <T> List<T> toList(final DeferredRegister<T> registry, final Predicate<T> predicate) {
        return toStream(registry).filter(predicate).toList();
    }

    /** @return The given vanilla registry as a map, with its keys being the in-game String IDs, and its values being the corresponding entries in the registry. */
    public static <T> BiMap<String, T> toMap(final Registry<T> registry) {
        Map<String, T> map = registry.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().identifier().getPath(), Map.Entry::getValue));
        return HashBiMap.create(map);
    }

    /** @return The given mod registry as a map, with its keys being the string IDs, and its values being the corresponding entries in the registry. */
    public static <T> BiMap<String, T> toMap(final DeferredRegister<T> registry) {
        Map<String, T> map = registry.getEntries()
                .stream()
                .collect(Collectors.toMap(e -> e.getId().getPath(), DeferredHolder::get));
        return HashBiMap.create(map);
    }

    /** @return The given vanilla registry as a map, with its keys being the registry items, and its values being the corresponding string IDs. */
    public static <T> BiMap<T, String> toIdMap(final Registry<T> registry) {
        return toMap(registry).inverse();
    }

    /** @return The given mod registry as a map, with its keys being the registry items, and its values being the corresponding string IDs. */
    public static <T> BiMap<T, String> toIdMap(final DeferredRegister<T> registry) {
        return toMap(registry).inverse();
    }

    /** @return The object in the vanilla registry with the provided ID. */
    public static <T> T get(final Registry<T> registry, final String id) {
        Map<String, T> map = toMap(registry);
        return map.get(id);
    }

    /** @return The object in the mod registry with the provdied ID. */
    public static <T> T get(final DeferredRegister<T> registry, final String id) {
        Map<String, T> map = toMap(registry);
        return map.get(id);
    }

    /** @return The ID of the provided object in the vanilla registry. */
    public static <T> String getId(final Registry<T> registry, final T item) {
        Map<T, String> map = toIdMap(registry);
        return map.get(item);
    }

    /** @return The ID of the provided object in the mod registry. */
    public static <T> String getId(final DeferredRegister<T> registry, final T item) {
        Map<T, String> map = toIdMap(registry);
        return map.get(item);
    }
}
