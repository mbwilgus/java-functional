package data.maybe;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public final class Just<T> extends Maybe<T> {
    private final T value;

    public Just(T value) { this.value = value; }

    @Override
    public <V> Maybe<V> fmap(Function<? super T, ? extends V> f) {
        return new Just<>(f.apply(value));
    }

    @Override
    public <V> Maybe<V> apply(Applicative<Maybe<?>, Function<? super T, ? extends V>> f) {
        Maybe<Function<? super T, ? extends V>> af = (Maybe<Function<? super T, ? extends V>>) f;
        if (af.isNothing()) return new Nothing<>();
        return this.fmap(af.get());
    }

    @Override
    public <V> Maybe<V> bind(Function<? super T, ? extends Monad<Maybe<?>, ? extends V>> f) {
        @SuppressWarnings("unchecked")
        Maybe<V> r =(Maybe<V>) f.apply(value);
        return r;
    }

    @Override
    public boolean isNothing() {
        return false;
    }

    @Override
    public boolean isJust() {
        return true;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public String read() {
        return value.toString();
    }

    @Override
    public String toString() { return "Just " + read(); }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Just<?>) {
            return ((Just<?>) other).value.equals(value);
        }

        return false;
    }
}
