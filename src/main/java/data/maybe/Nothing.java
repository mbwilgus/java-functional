package data.maybe;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public final class Nothing<T> extends Maybe<T> {
    @Override
    public <V> Maybe<V> fmap(Function<? super T, ? extends V> f) {
        return new Nothing<>();
    }

    @Override
    public <V> Maybe<V> apply(Applicative<Maybe<?>, Function<? super T, ? extends V>> f) {
        return new Nothing<>();
    }

    @Override
    public <V> Maybe<V> bind(Function<? super T, ? extends Monad<Maybe<?>, ? extends V>> f) {
        return new Nothing<>();
    }

    @Override
    public boolean isNothing() {
        return true;
    }

    @Override
    public boolean isJust() {
        return false;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public String read() {
        return "Nothing";
    }

    @Override
    public String toString() { return read(); }

    @Override
    public boolean equals(Object other) {
        return other instanceof Nothing<?>;
    }
}
