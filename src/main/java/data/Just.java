package data;

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
    public <V> Maybe<V> amap(Applicative<Maybe<?>, Function<? super T, ? extends V>> f) {
        Maybe<Function<? super T, ? extends V>> af = (Maybe<Function<? super T, ? extends V>>) f;
        if (af.isNothing()) return new Nothing<>();
        return this.fmap(af.projectJust().value);
    }

    @Override
    public <V> Maybe<V> bind(Function<? super T, ? extends Monad<Maybe<?>, ? extends V>> f) {
        return (Maybe<V>) f.apply(value);
    }

    @Override
    public boolean isNothing() {
        return false;
    }

    @Override
    public Nothing<T> projectNothing() {
        return null;
    }

    @Override
    public boolean isJust() {
        return true;
    }

    @Override
    public Just<T> projectJust() {
        return this;
    }

    @Override
    public String read() {
        return value.toString();
    }
}
