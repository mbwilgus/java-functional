package typeclass;

import data.Either;
import data.Right;

import java.util.function.Function;

public interface Applicative<A extends Applicative<A, ?>, U> extends Functor<A, U> {
    static <T, U> Right<T, U> pure(U value) {
        return new Right<>(value);
    }

    @Override
    <V> Applicative<A, V> fmap(Function<? super U, ? extends V> f);

    <V> Applicative<A, V> amap(Applicative<A, Function<? super U, ? extends V>> f);
}
