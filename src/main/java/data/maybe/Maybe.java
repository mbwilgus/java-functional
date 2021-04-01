package data.maybe;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public abstract class Maybe<T> implements Monad<Maybe<?>, T> {
    public static <T> Just<T> pure(T value) {
        return new Just<>(value);
    }

    public static <T> Just<T> unit(T value) {
        return pure(value);
    }

    @Override
    public abstract <V> Maybe<V> fmap(Function<? super T, ? extends V> f);

    @Override
    public abstract <V> Maybe<V> apply(Applicative<Maybe<?>, Function<? super T, ? extends V>> f);

    @Override
    public abstract <V> Maybe<V> bind(Function<? super T, ? extends Monad<Maybe<?>, ? extends V>> f);

    public abstract boolean isNothing();
    public abstract boolean isJust();
    public abstract T get();

    public abstract String read();
}
