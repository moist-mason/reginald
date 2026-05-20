package com.github.moistmason.reginald.util;

import net.minecraft.resources.ResourceLocation;

public class ResourceProvider {
    private final String modId;

    public ResourceProvider(final String modId) {
        this.modId = modId;
    }

    public ResourceLocation get(final String id) {
        return ResourceLocation.fromNamespaceAndPath(modId, id);
    }
}
