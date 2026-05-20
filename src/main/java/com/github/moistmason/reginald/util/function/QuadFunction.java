package com.github.moistmason.reginald.util.function;

@FunctionalInterface
public interface QuadFunction<T, U, V, W, R> {
    R apply(final T t, final U u, final V v, final W w);
}