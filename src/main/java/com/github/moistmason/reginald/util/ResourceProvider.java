package com.github.moistmason.reginald.util;

import net.minecraft.resources.Identifier;

public class ResourceProvider {
    private final String modId;

    public ResourceProvider(final String modId) {
        this.modId = modId;
    }

    public Identifier get(final String id) {
        return Identifier.fromNamespaceAndPath(modId, id);
    }
}
