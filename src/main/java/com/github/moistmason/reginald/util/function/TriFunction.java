package com.github.moistmason.reginald.util.function;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(final T t, final U u, final V v);
}
