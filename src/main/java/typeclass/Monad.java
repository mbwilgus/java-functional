package typeclass;

import data.Either;
import data.Right;

import java.util.function.Function;

public interface Monad<M extends Monad<M, ?>, U> extends Applicative<M, U> {
    static <T, U> Either<T, U> unit(U value) {
        return new Right<>(value);
    }

    @Override
    <V> Monad<M, V> fmap(Function<U, V> f);

    @Override
    <V> Monad<M, V> amap(Applicative<M, Function<U, V>> f);

    <V> Monad<M, V> bind(Function<U, ? extends Monad<M, V>> f);
}
