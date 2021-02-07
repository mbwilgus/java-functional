package typeclass;

import data.Either;
import data.Right;

import java.util.function.Function;

public interface Monad<M extends Monad<M, ?>, U> extends Applicative<M, U> {
    static <T, U> Right<T, U> unit(U value) {
        return new Right<>(value);
    }

    @Override
    <V> Monad<M, V> fmap(Function<? super U, ? extends V> f);

    @Override
    <V> Monad<M, V> amap(Applicative<M, Function<? super U, ? extends V>> f);

    <V> Monad<M, V> bind(Function<? super U, ? extends Monad<M, ? extends V>> f);
}
