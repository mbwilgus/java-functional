package data;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public abstract class Maybe<T> implements Monad<Maybe<?>, T> {
    @Override
    public abstract <V> Maybe<V> fmap(Function<? super T, ? extends V> f);

    @Override
    public abstract <V> Maybe<V> amap(Applicative<Maybe<?>, Function<? super T, ? extends V>> f);

    @Override
    public abstract <V> Maybe<V> bind(Function<? super T, ? extends Monad<Maybe<?>, ? extends V>> f);

    public abstract boolean isNothing();
    public abstract Nothing<T> projectNothing();
    public abstract boolean isJust();
    public abstract Just<T> projectJust();

    public abstract String read();
}
